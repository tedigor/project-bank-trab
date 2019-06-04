package br.com.unifacisa.si2.banktrab.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Clientes")
public class Cliente extends EntityBase<Long>{

	private static final long serialVersionUID = -7292871415138894605L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_cliente")
	private Long id;
	
	@Column(name = "cod_cliente", nullable = false, unique = true)
	private String codigo;
	
	@Column(name = "nome_pessoa")
	private String nome;
	
	@Column(name = "ativo")
	private Boolean isAtivo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public void setAtivo(Boolean exclusaoLogica) {
		this.isAtivo = exclusaoLogica;		
	}

	@Override
	public Boolean getAtivo() {
		return isAtivo;
	}
	
	
}
