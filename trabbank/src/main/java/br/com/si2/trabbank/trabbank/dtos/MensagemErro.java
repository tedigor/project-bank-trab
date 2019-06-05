package br.com.si2.trabbank.trabbank.dtos;

public class MensagemErro extends MensagemRetorno{

	public MensagemErro(String mensagem) {
		super(mensagem,"erro");
	}
}
