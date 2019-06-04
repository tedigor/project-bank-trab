package br.com.unifacisa.si2.banktrab.exceptions;

import br.com.unifacisa.si2.banktrab.dtos.MensagemErro;

public class BankTrabException extends RuntimeException {

	private MensagemErro erro;
	
	public BankTrabException(MensagemErro erro) {
		this.erro = erro;
	}
	
}
