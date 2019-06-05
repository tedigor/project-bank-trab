package br.com.si2.trabbank.trabbank.services;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.si2.trabbank.trabbank.daos.ContaDAO;
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
			throw new BankTrabException(new MensagemErro("Conta com esse id n�o encontrada"));
		}
		return c;

	}

	public MensagemSucesso desativarConta(Long id) {

		Conta c = findConta(id);
		if (isSaldoContaValido(c)) {
			throw new BankTrabException(new MensagemErro(
					"A conta ainda possui saldo, por favor, realize uma transfer�ncia ou saque do valor"));
		}
		c.setAtivo(false);
		dao.save(c);

		return new MensagemSucesso("A conta foi encerrada com sucesso!");

	}

	public Boolean isSaldoContaValido(Conta c) {
		return c.getSaldo().compareTo(BigDecimal.ZERO) > 0;

	}

	public Boolean isSaldoContaValidoPorId(Long id) {
		return isSaldoContaValido(findConta(id));
	}

}
