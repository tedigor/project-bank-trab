package br.com.si2.trabbank.trabbank.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.si2.trabbank.trabbank.enums.TipoConta;

@Entity
@Table(name = "Contas")
public class Conta extends EntityBase<Long> {

	private static final long serialVersionUID = 5457433679259238167L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_conta")
	private Long id;

	@Column(name = "numero")
	private Long numeroConta;

	@Column(name = "saldo")
	private BigDecimal saldo;

	@Column(name = "tipo")
	@Enumerated(EnumType.STRING)
	private TipoConta tipoConta;

	@Column(name = "flagAtivo")
	private Boolean isAtivo;

	@Column(name = "senha")
	private String senha;

	@OneToOne
	@JoinColumn(name = "id_cliente", nullable = false)
	private Cliente cliente;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
	@JoinColumn(name = "fk_conta")
	private List<Transacao> transacoes = new ArrayList<>();

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public Long getId() {
		return id;
	}

	public TipoConta getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(TipoConta tipoConta) {
		this.tipoConta = tipoConta;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Transacao> getTransacoes() {
		return transacoes;
	}

	public void setTransacoes(List<Transacao> transacoes) {
		this.transacoes = transacoes;
	}
}
