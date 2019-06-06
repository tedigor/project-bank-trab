package br.com.si2.trabbank.trabbank.builders;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.si2.trabbank.trabbank.models.Conta;
import br.com.si2.trabbank.trabbank.services.TipoContaService;

@Component
public class ContaBuilder {

	private static Long numero_conta = 1000L;
	
	@Autowired
	private TipoContaService service;

	public Conta contaCorrenteBuild() {
		Conta conta = ContaDefault();

		conta.setTipoConta(service.findById(1));

		return conta;
	}

	public Conta contaPoupancaBuild() {
		Conta conta = ContaDefault();

		conta.setTipoConta(service.findById(2));

		return conta;
	}

	private static Conta ContaDefault() {

		Conta conta = new Conta();

		conta.setNumeroConta(numero_conta);
		conta.setSaldo(BigDecimal.ZERO);
		conta.setLimite(new BigDecimal("500"));

		numero_conta++;

		return conta;
	}
}
