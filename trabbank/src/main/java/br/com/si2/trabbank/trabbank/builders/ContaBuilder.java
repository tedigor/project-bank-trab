package br.com.si2.trabbank.trabbank.builders;

import java.math.BigDecimal;
import java.util.Date;

import br.com.si2.trabbank.trabbank.enums.TipoConta;
import br.com.si2.trabbank.trabbank.models.Conta;

public class ContaBuilder {

	private static Long numero_conta = 1000L;

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

		conta.setNumeroConta(numero_conta);
		conta.setSaldo(BigDecimal.ZERO);

		numero_conta++;

		return conta;
	}
}
