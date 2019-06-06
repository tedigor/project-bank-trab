package br.com.si2.trabbank.trabbank.services;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.si2.trabbank.trabbank.constants.MensagensConstants;
import br.com.si2.trabbank.trabbank.daos.ContaDAO;
import br.com.si2.trabbank.trabbank.dtos.AdicionarSaldoDTO;
import br.com.si2.trabbank.trabbank.dtos.MensagemErro;
import br.com.si2.trabbank.trabbank.dtos.MensagemSucesso;
import br.com.si2.trabbank.trabbank.exceptions.BankTrabException;
import br.com.si2.trabbank.trabbank.models.Conta;

@Service
public class ContaService {

	@Autowired
	private ContaDAO dao;

	public Conta findConta(Long id) {

		Conta c = dao.findById(id);
		if (c == null) {
			throw new BankTrabException(new MensagemErro(MensagensConstants.ME01));
		}
		return c;

	}

	public MensagemSucesso desativarConta(Long id) {

		Conta c = findConta(id);
		if (isSaldoContaValido(c)) {
			throw new BankTrabException(new MensagemErro(MensagensConstants.ME02));
		}
		c.setAtivo(false);
		dao.save(c);

		return new MensagemSucesso(MensagensConstants.MS01);

	}

	/* TODO se for usar só aki põe privado */
	public Boolean isSaldoContaValido(Conta c) {
		return c.getSaldo().compareTo(BigDecimal.ZERO) > 0;

	}

	/* TODO se nao for usar apaga */
	public Boolean isSaldoContaValidoPorId(Long id) {
		return isSaldoContaValido(findConta(id));
	}

	public MensagemSucesso adiconarSaldo(AdicionarSaldoDTO adicionarSaldoDTO) {

		Conta conta = dao.findById(adicionarSaldoDTO.getIdConta());

		if (!Boolean.TRUE.equals(conta.getAtivo())) {
			throw new BankTrabException(new MensagemErro(MensagensConstants.ME03));
		}

		conta.setSaldo(conta.getSaldo().add(adicionarSaldoDTO.getDeposito()));

		dao.save(conta);

		return new MensagemSucesso(MensagensConstants.MS02);
	}

	public void save(Conta conta) {
		dao.save(conta);
	}
}
