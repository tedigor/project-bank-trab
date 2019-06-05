package br.com.si2.trabbank.trabbank.models;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Contas")
public class Conta extends EntityBase<Long> {

	private static final long serialVersionUID = 5457433679259238167L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id_conta")
	private Long id;

	@Column(name = "Numero")
	private Long numeroConta;

	@Column(name = "Saldo")
	private BigDecimal saldo;

	@Column(name = "flagAtivo")
	private Boolean isAtivo;
	
	@OneToOne
	@JoinColumn(name = "Id_cliente", nullable = false)
	private Cliente cliente;

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setAtivo(Boolean exclusaoLogica) {
		this.isAtivo = exclusaoLogica;
	}

	@Override
	public Boolean getAtivo() {
		return this.isAtivo;
	}

	public Long getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(Long numeroConta) {
		this.numeroConta = numeroConta;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public Boolean getIsAtivo() {
		return isAtivo;
	}

	public void setIsAtivo(Boolean isAtivo) {
		this.isAtivo = isAtivo;
	}
}
