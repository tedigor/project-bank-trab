package br.com.si2.trabbank.trabbank.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.si2.trabbank.trabbank.constants.MensagensConstants;
import br.com.si2.trabbank.trabbank.daos.ContaDAO;
import br.com.si2.trabbank.trabbank.dtos.AdicionarSaldoDTO;
import br.com.si2.trabbank.trabbank.dtos.MensagemErro;
import br.com.si2.trabbank.trabbank.dtos.MensagemSucesso;
import br.com.si2.trabbank.trabbank.dtos.TransacaoDTO;
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

	public BigDecimal consultarSaldo(String token) {
		Conta c = context.getConta(token);
		return c.getSaldo();
	}

	public MensagemSucesso realizarTransacao(String token,TransacaoDTO transacao) {
		Conta conta = context.getConta(token);
		return transacaoService.realizarTransacao(transacao);
	}
	
}
