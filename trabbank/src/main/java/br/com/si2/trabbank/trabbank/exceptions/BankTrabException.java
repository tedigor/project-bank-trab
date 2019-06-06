package br.com.si2.trabbank.trabbank.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.si2.trabbank.trabbank.dtos.MensagemErro;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class BankTrabException extends RuntimeException {

	private static final long serialVersionUID = -2825806295171631257L;
	
	private MensagemErro erro;
	
	public BankTrabException(MensagemErro erro) {
		this.erro = erro;
	}
	
}
