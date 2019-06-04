package br.com.unifacisa.si2.banktrab.services;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unifacisa.si2.banktrab.daos.ContaDAO;
import br.com.unifacisa.si2.banktrab.dtos.MensagemErro;
import br.com.unifacisa.si2.banktrab.dtos.MensagemSucesso;
import br.com.unifacisa.si2.banktrab.exceptions.BankTrabException;
import br.com.unifacisa.si2.banktrab.models.Conta;

@Service
public class ContaService {

	@Autowired
	private ContaDAO dao;
	
	public Conta findConta(Long id) {

		Conta c = dao.findById(id);
		if (c == null) {
			throw new BankTrabException(new MensagemErro("Conta com esse id não encontrada"));
		}
		return c;

	}

	public MensagemSucesso desativarConta(Long id) {

		Conta c = findConta(id);
		if (isSaldoContaValido(c)) {
			throw new BankTrabException(new MensagemErro(
					"A conta ainda possui saldo, por favor, realize uma transferência ou saque do valor"));
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
