package br.com.si2.trabbank.trabbank.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.si2.trabbank.trabbank.builders.TransacaoBuilder;
import br.com.si2.trabbank.trabbank.constants.MensagensConstants;
import br.com.si2.trabbank.trabbank.daos.TransacaoDAO;
import br.com.si2.trabbank.trabbank.dtos.MensagemErro;
import br.com.si2.trabbank.trabbank.dtos.MensagemSucesso;
import br.com.si2.trabbank.trabbank.dtos.TransacaoDTO;
import br.com.si2.trabbank.trabbank.enums.TipoTransacao;
import br.com.si2.trabbank.trabbank.exceptions.BankTrabException;
import br.com.si2.trabbank.trabbank.models.Conta;
import br.com.si2.trabbank.trabbank.models.Transacao;

@Service
public class TransacaoService {

	@Autowired
	private ContaService contaService;

	@Autowired
	private TransacaoDAO transacaoDao;
	
	@Autowired
	private TransacaoBuilder transacaoBuilder;

	public MensagemSucesso realizarTransacao(TransacaoDTO transacaoDTO) {

		return inicarChain(transacaoDTO);

	}

	private MensagemSucesso inicarChain(TransacaoDTO transacaoDTO) {
		return saque(transacaoDTO);
	}

	private MensagemSucesso saque(TransacaoDTO transacaoDTO) {

		if (TipoTransacao.SAQUE.equals(transacaoDTO.getTipoTransacao())) {

			Conta conta = contaService.findByNumero(transacaoDTO.getContaFinal());

			validarSaldo(transacaoDTO, conta);

			Transacao transacao = transacaoBuilder.transacaoSaqueBuild();
			transacao.setValor(transacaoDTO.getValor());

			conta.setSaldo(conta.getSaldo().subtract(transacaoDTO.getValor()));

			conta.getTransacoes().add(transacao);

			transacaoDao.save(transacao);
			contaService.save(conta);

			return new MensagemSucesso(MensagensConstants.MENSAGEM_SUCESSO_04);
		} else {
			return emprestimo(transacaoDTO);
		}

	}
	
	private MensagemSucesso emprestimo(TransacaoDTO transacaoDTO) {

		if (TipoTransacao.EMPRESTIMO.equals(transacaoDTO.getTipoTransacao())) {

			Conta conta = contaService.findByNumero(transacaoDTO.getContaFinal());

			validarLimite(transacaoDTO, conta);

			Transacao transacao = transacaoBuilder.transacaoEmprestimoBuild();
			transacao.setValor(transacaoDTO.getValor());

			conta.setSaldo(conta.getSaldo().add(transacaoDTO.getValor()));
			conta.setLimite(conta.getLimite().subtract(transacaoDTO.getValor()));
			
			conta.getTransacoes().add(transacao);

			transacaoDao.save(transacao);
			contaService.save(conta);

			return new MensagemSucesso(MensagensConstants.MENSAGEM_SUCESSO_06);
		} else {
			return transferencia(transacaoDTO);
		}

	}

	private MensagemSucesso transferencia(TransacaoDTO transacaoDTO) {

		if (TipoTransacao.TRANSFERENCIA.equals(transacaoDTO.getTipoTransacao())) {

			Conta contaFinal = contaService.findByNumero(transacaoDTO.getContaFinal());
			Conta contaOrigem = contaService.findByNumero(transacaoDTO.getContaOrigem());

			validarSaldo(transacaoDTO, contaOrigem);

			Transacao transacaoOri = transacaoBuilder.transacaoTransferenciaSaidaBuild();
			transacaoOri.setValor(transacaoDTO.getValor());
			Transacao transacaoFinal = transacaoBuilder.transacaoTransferenciaEntradaBuild();
			transacaoFinal.setValor(transacaoDTO.getValor());

			contaOrigem.setSaldo(contaOrigem.getSaldo().subtract(transacaoDTO.getValor()));
			contaFinal.setSaldo(contaFinal.getSaldo().add(transacaoDTO.getValor()));

			contaOrigem.getTransacoes().add(transacaoOri);
			contaFinal.getTransacoes().add(transacaoFinal);

			transacaoOri.setTransacao(transacaoFinal);
			
			transacaoDao.save(transacaoOri);
			transacaoDao.save(transacaoFinal);

			contaService.save(contaFinal);
			contaService.save(contaOrigem);

			return new MensagemSucesso(MensagensConstants.MENSAGEM_SUCESSO_05);
		} else {
			return deposito(transacaoDTO);
		}
	}

	private MensagemSucesso deposito(TransacaoDTO transacaoDTO) {

		if (TipoTransacao.DEPOSITO.equals(transacaoDTO.getTipoTransacao())) {

			Conta conta = contaService.findByNumero(transacaoDTO.getContaFinal());

			Transacao transacao = transacaoBuilder.transacaoDepositoBuild();
			transacao.setValor(transacaoDTO.getValor());

			conta.setSaldo(conta.getSaldo().add(transacaoDTO.getValor()));

			conta.getTransacoes().add(transacao);

			transacaoDao.save(transacao);
			contaService.save(conta);

			return new MensagemSucesso(MensagensConstants.MENSAGEM_SUCESSO_02);
		} else {
			throw new BankTrabException(new MensagemErro(MensagensConstants.MENSAGEM_ERRO_09));
		}
	}

	private void validarSaldo(TransacaoDTO transacaoDTO, Conta conta) {
		if (conta.getSaldo().compareTo(transacaoDTO.getValor()) < 0) {
			throw new BankTrabException(new MensagemErro(MensagensConstants.MENSAGEM_ERRO_08));
		}
	}
	
	private void validarLimite(TransacaoDTO transacaoDTO, Conta conta) {
		if (conta.getLimite().compareTo(transacaoDTO.getValor()) < 0) {
			throw new BankTrabException(new MensagemErro(MensagensConstants.MENSAGEM_ERRO_08));
		}
	}

}
