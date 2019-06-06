package br.com.si2.trabbank.trabbank.dtos;

import java.math.BigDecimal;

import br.com.si2.trabbank.trabbank.models.TipoTransacao;
import br.com.si2.trabbank.trabbank.models.Transacao;

public class TransacaoExtratoDTO {

	private BigDecimal valor;
	private TipoTransacao tipo;

	public TransacaoExtratoDTO(TipoTransacao tipoTransacao, BigDecimal valor) {
		this.tipo = tipoTransacao;
		this.valor = valor;
	}

	public static TransacaoExtratoDTO build(Transacao t) {
		return new TransacaoExtratoDTO(t.getTipoTransacao(), t.getValor());
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public TipoTransacao getTipo() {
		return tipo;
	}

	public void setTipo(TipoTransacao tipo) {
		this.tipo = tipo;
	}

}
