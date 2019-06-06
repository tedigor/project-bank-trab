package br.com.si2.trabbank.trabbank.builders;

import br.com.si2.trabbank.trabbank.enums.TipoTransacao;
import br.com.si2.trabbank.trabbank.models.Transacao;

public class TransacaoBuilder {

	public static Transacao transacaoSaqueBuild() {
		Transacao trans = new Transacao();
		
		trans.setTipoTransacao(TipoTransacao.SAQUE);
		
		return trans;
	}
	
	public static Transacao transacaoDepositoBuild() {
		Transacao trans = new Transacao();
		
		trans.setTipoTransacao(TipoTransacao.DEPOSITO
				);
		return trans;
	}
	
	public static Transacao transacaoTransferenciaBuild() {
		Transacao trans = new Transacao();
		
		trans.setTipoTransacao(TipoTransacao.TRANSFERENCIA
				);
		return trans;
	}
	
}
