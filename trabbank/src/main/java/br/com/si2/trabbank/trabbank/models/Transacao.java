package br.com.si2.trabbank.trabbank.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Transacoes")
public class Transacao {

	@Column(name = "receiver")
	@ManyToOne
	@JoinColumn(name = "id_receiver")
	private Conta receiver;

	@ManyToOne
	@JoinColumn(name = "id_sender")
	@Column(name = "sender")
	private Conta sender;

	@Column(name = "valor_transferido")
	private String valor;

}
