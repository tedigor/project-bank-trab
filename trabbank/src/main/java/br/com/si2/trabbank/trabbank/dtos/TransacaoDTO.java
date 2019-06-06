package br.com.si2.trabbank.trabbank.dtos;

import java.math.BigDecimal;

import br.com.si2.trabbank.trabbank.enums.TipoTransacao;

public class TransacaoDTO {

	private Long contaOrigem;
	
	private Long contaFinal;
	
	private TipoTransacao tipoTransacao;
	
	private BigDecimal valor;

	public Long getContaOrigem() {
		return contaOrigem;
	}

	public void setContaOrigem(Long contaOrigem) {
		this.contaOrigem = contaOrigem;
	}

	public Long getContaFinal() {
		return contaFinal;
	}

	public void setContaFinal(Long contaFinal) {
		this.contaFinal = contaFinal;
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
	
}
