package br.com.si2.trabbank.trabbank.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_transacao")
public class TipoTransacao extends EntityBase<Integer> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_tipo_transacao")
	private Integer id;
	
	@Column(name = "nom_tipo_transacao")
	private String tipo;
	
	@Column(name = "ativo")
	private Boolean isAtivo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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
