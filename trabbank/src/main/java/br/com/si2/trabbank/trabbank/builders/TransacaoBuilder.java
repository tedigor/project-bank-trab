package br.com.si2.trabbank.trabbank.builders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.si2.trabbank.trabbank.models.Transacao;
import br.com.si2.trabbank.trabbank.services.TipoTransacaoService;

@Component
public class TransacaoBuilder {

	@Autowired
	private TipoTransacaoService service;

	public Transacao transacaoSaqueBuild() {
		Transacao trans = new Transacao();

		trans.setTipoTransacao(service.findById(1));

		return trans;
	}

	public Transacao transacaoDepositoBuild() {
		Transacao trans = new Transacao();

		trans.setTipoTransacao(service.findById(3));
		return trans;
	}

	public Transacao transacaoTransferenciaSaidaBuild() {
		Transacao trans = new Transacao();

		trans.setTipoTransacao(service.findById(2));
		return trans;
	}
	
	public Transacao transacaoTransferenciaEntradaBuild() {
		Transacao trans = new Transacao();

		trans.setTipoTransacao(service.findById(5));
		return trans;
	}
	
	public Transacao transacaoEmprestimoBuild() {
		Transacao trans = new Transacao();

		trans.setTipoTransacao(service.findById(4));
		return trans;
	}

}
