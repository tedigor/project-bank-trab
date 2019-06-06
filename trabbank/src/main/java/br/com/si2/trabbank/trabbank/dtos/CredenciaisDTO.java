package br.com.si2.trabbank.trabbank.dtos;

public class CredenciaisDTO {

	private Long numero;
	private String senha;

	public CredenciaisDTO() {
	}

	public CredenciaisDTO(Long numero, String senha) {
		this.numero = numero;
		this.senha = senha;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
