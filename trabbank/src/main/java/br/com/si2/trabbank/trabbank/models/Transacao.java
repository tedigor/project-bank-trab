package br.com.si2.trabbank.trabbank.models;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "transacao")
public class Transacao extends EntityBase<Long> {

	private static final long serialVersionUID = 6147092979232488852L;

	@Id
	@GeneratedValue
	@Column(name = "id_transacao")
	private Long id;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_transacao")
	private Transacao transacao;
	
	@ManyToOne
	@JoinColumn(name = "fktipo_transacao")
	private TipoTransacao tipoTransacao;

	@Column(name = "valor")
	private BigDecimal valor;

	@Column(name = "ativo")
	private Boolean isAtivo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoTransacao getTipoTransacao() {
		return tipoTransacao;
	}

	public void setTipoTransacao(TipoTransacao tipoTransacao) {
		this.tipoTransacao = tipoTransacao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	@Override
	public void setAtivo(Boolean exclusaoLogica) {
		this.isAtivo = exclusaoLogica;

	}

	@Override
	public Boolean getAtivo() {
		return this.isAtivo;
	}

	public Transacao getTransacao() {
		return transacao;
	}

	public void setTransacao(Transacao transacao) {
		this.transacao = transacao;
	}
	
}
