package br.com.si2.trabbank.trabbank.dtos;

import java.math.BigDecimal;

public class ExibirInfoClienteDTO {

	private BigDecimal saldo;

	public ExibirInfoClienteDTO(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public ExibirInfoClienteDTO() {
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

}
