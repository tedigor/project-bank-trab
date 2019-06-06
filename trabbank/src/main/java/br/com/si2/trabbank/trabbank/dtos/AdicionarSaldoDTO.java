package br.com.si2.trabbank.trabbank.dtos;

import java.math.BigDecimal;

public class AdicionarSaldoDTO {

	private Long idConta;
	
	private BigDecimal deposito;

	public Long getIdConta() {
		return idConta;
	}

	public void setIdConta(Long idConta) {
		this.idConta = idConta;
	}

	public BigDecimal getDeposito() {
		return deposito;
	}

	public void setDeposito(BigDecimal deposito) {
		this.deposito = deposito;
	}
	
	
	
}
