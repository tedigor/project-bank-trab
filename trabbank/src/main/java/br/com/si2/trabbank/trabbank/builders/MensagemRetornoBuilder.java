package br.com.si2.trabbank.trabbank.builders;

import br.com.si2.trabbank.trabbank.constants.MensagensConstants;
import br.com.si2.trabbank.trabbank.dtos.MensagemRetorno;

public class MensagemRetornoBuilder {
	
	private MensagemRetorno mensagemRetorno;
	
	private MensagemRetornoBuilder() { 
		this.mensagemRetorno = new MensagemRetorno();
	}
	
	public static MensagemRetornoBuilder sucesso() {
		return new MensagemRetornoBuilder();
	}
	
	public MensagemRetornoBuilder dadosAlterados() {
		this.mensagemRetorno.setMensagem(MensagensConstants.MENSAGEM_SUCESSO_07);
		return this;
	}
	
	public MensagemRetorno build() {
		return this.mensagemRetorno;
	}
	
}