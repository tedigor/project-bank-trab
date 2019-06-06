package br.com.si2.trabbank.trabbank.dtos;

public class AlterarDadosDTO {

	private Long id;

	private String senha;

	public AlterarDadosDTO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AlterarDadosDTO(String senha) {
		this.senha = senha;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
