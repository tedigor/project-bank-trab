package br.com.si2.trabbank.trabbank.builders;

import java.math.BigDecimal;
import java.util.Date;

import br.com.si2.trabbank.trabbank.enums.TipoConta;
import br.com.si2.trabbank.trabbank.models.Conta;

public class ContaBuilder {

	public static Conta contaCorrenteBuild() {
		Conta conta = ContaDefault();

		conta.setTipoConta(TipoConta.CONTA_CORRENTE);

		return conta;
	}

	public static Conta contaPoupancaBuild() {
		Conta conta = ContaDefault();

		conta.setTipoConta(TipoConta.POUPANCA);

		return conta;
	}

	private static Conta ContaDefault() {

		Conta conta = new Conta();

		Long timestamp = new Date().getTime();

		conta.setNumeroConta(Long.parseLong(timestamp.toString().substring(0, 5)));
		conta.setSaldo(BigDecimal.ZERO);

		return conta;
	}
}
