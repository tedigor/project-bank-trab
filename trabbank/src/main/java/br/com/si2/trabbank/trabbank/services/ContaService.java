package br.com.si2.trabbank.trabbank.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.si2.trabbank.trabbank.builders.MensagemRetornoBuilder;
import br.com.si2.trabbank.trabbank.constants.MensagensConstants;
import br.com.si2.trabbank.trabbank.daos.ContaDAO;
import br.com.si2.trabbank.trabbank.dtos.AdicionarSaldoDTO;
import br.com.si2.trabbank.trabbank.dtos.AlterarDadosDTO;
import br.com.si2.trabbank.trabbank.dtos.ExibirInfoClienteDTO;
import br.com.si2.trabbank.trabbank.dtos.MensagemErro;
import br.com.si2.trabbank.trabbank.dtos.MensagemRetorno;
import br.com.si2.trabbank.trabbank.dtos.MensagemSucesso;
import br.com.si2.trabbank.trabbank.dtos.TransacaoDTO;
import br.com.si2.trabbank.trabbank.dtos.TransacaoExtratoDTO;
import br.com.si2.trabbank.trabbank.exceptions.BankTrabException;
import br.com.si2.trabbank.trabbank.models.Conta;
import br.com.si2.trabbank.trabbank.security.ContextoAutorizacao;

@Service
public class ContaService {

	@Autowired
	private ContaDAO dao;

	@Autowired
	private TransacaoService transacaoService;

	@Autowired
	private ContextoAutorizacao context;

	public Conta findConta(Long id) {

		Conta c = dao.findById(id);
		if (c == null) {
			throw new BankTrabException(new MensagemErro(MensagensConstants.MENSAGEM_ERRO_01));
		}
		return c;

	}

	public MensagemSucesso desativarConta(Long id) {

		Conta c = findConta(id);
		if (isSaldoContaValido(c)) {
			throw new BankTrabException(new MensagemErro(MensagensConstants.MENSAGEM_ERRO_02));
		}
		c.setAtivo(false);
		dao.save(c);

		return new MensagemSucesso(MensagensConstants.MENSAGEM_SUCESSO_01);

	}

	/* TODO se for usar só aki põe privado */
	public Boolean isSaldoContaValido(Conta c) {
		return c.getSaldo().compareTo(BigDecimal.ZERO) > 0;

	}

	/* TODO se nao for usar apaga */
	public Boolean isSaldoContaValidoPorId(Long id) {
		return isSaldoContaValido(findConta(id));
	}

	public List<Conta> findAll() {
		return dao.findAll();
	}

	public MensagemSucesso adiconarSaldo(AdicionarSaldoDTO adicionarSaldoDTO) {

		Conta conta = dao.findById(adicionarSaldoDTO.getIdConta());

		if (!Boolean.TRUE.equals(conta.getAtivo())) {
			throw new BankTrabException(new MensagemErro(MensagensConstants.MENSAGEM_ERRO_03));
		}

		conta.setSaldo(conta.getSaldo().add(adicionarSaldoDTO.getDeposito()));

		dao.save(conta);

		return new MensagemSucesso(MensagensConstants.MENSAGEM_SUCESSO_02);
	}

	public void save(Conta conta) {
		dao.save(conta);
	}

	public Conta findByNumero(Long numero) {

		List<Conta> list = dao.findByNumero(numero);

		if (list.size() > 1) {
			throw new BankTrabException(new MensagemErro(MensagensConstants.MENSAGEM_ERRO_05));
		} else if (list.size() == 0) {
			throw new BankTrabException(new MensagemErro(MensagensConstants.MENSAGEM_ERRO_06));
		}

		return list.get(0);

	}

	public ExibirInfoClienteDTO consultarSaldo(String token) {
		Conta c = context.getConta(token);
		return  new ExibirInfoClienteDTO(c.getSaldo());
	}

	public MensagemSucesso realizarTransacao(String token, TransacaoDTO transacao) {
		context.getConta(token);
		return transacaoService.realizarTransacao(transacao);
	}

	public List<TransacaoExtratoDTO> findExtrato(String token) {
		Conta conta = context.getConta(token);
		return conta.getTransacoes().stream().map(TransacaoExtratoDTO::build).collect(Collectors.toList());
	}

	public MensagemRetorno alterarDados(String token, AlterarDadosDTO dto) {
		Conta c = dao.findById(dto.getId());
		c.setSenha(dto.getSenha());
		dao.save(c);
		return MensagemRetornoBuilder.sucesso().dadosAlterados().build();
	}

}
