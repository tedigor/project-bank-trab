package br.com.si2.trabbank.trabbank.dtos;

public class MensagemRetorno {
	
	private String mensagem;
	
	private String type;

	public MensagemRetorno(String mensagem, String type) {
		super();
		this.mensagem = mensagem;
		this.type = type;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
