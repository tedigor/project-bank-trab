package br.com.si2.trabbank.trabbank.exceptions;

import br.com.si2.trabbank.trabbank.dtos.MensagemErro;

public class BankTrabException extends RuntimeException {

	private MensagemErro erro;
	
	public BankTrabException(MensagemErro erro) {
		this.erro = erro;
	}
	
}
