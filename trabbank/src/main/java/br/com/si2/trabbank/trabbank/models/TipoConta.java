package br.com.si2.trabbank.trabbank.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_conta")
public class TipoConta extends EntityBase<Integer>{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1903911076119352952L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_tipo_conta")
	private Integer id;
	
	@Column(name = "nom_tipo_conta")
	private String tipoConta;
	
	@Column(name = "ativo")
	private Boolean isAtivo;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(String tipoConta) {
		this.tipoConta = tipoConta;
	}

	@Override
	public void setAtivo(Boolean exclusaoLogica) {
		this.isAtivo = exclusaoLogica;
	}

	@Override
	public Boolean getAtivo() {
		return this.isAtivo;
	}
	
}
