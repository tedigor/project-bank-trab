package br.com.unifacisa.si2.banktrab.dtos;

public class MensagemErro extends MensagemRetorno{

	public MensagemErro(String mensagem) {
		super(mensagem,"erro");
	}
}
