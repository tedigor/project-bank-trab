package br.com.si2.trabbank.trabbank.dtos;

import br.com.si2.trabbank.trabbank.enums.TipoConta;

public class ClienteDTO {

	private String nome;
	
	private String codigo;
	
	private TipoConta tipoConta;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public TipoConta getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(TipoConta tipoConta) {
		this.tipoConta = tipoConta;
	}
}
