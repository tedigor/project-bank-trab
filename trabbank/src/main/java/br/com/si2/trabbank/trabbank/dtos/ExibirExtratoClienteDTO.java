package br.com.si2.trabbank.trabbank.dtos;

import java.util.List;

import br.com.si2.trabbank.trabbank.models.Transacao;

public class ExibirExtratoClienteDTO {

	private List<Transacao> transacoes;

	public ExibirExtratoClienteDTO() {
	}

	public ExibirExtratoClienteDTO(List<Transacao> transacoes) {
		this.transacoes = transacoes;
	}

	public List<Transacao> getTransacoes() {
		return transacoes;
	}

	public void setTransacoes(List<Transacao> transacoes) {
		this.transacoes = transacoes;
	}

}
