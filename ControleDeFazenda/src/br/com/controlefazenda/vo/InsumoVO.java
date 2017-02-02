package br.com.controlefazenda.vo;

import java.io.Serializable;

public class InsumoVO implements Serializable {

	private static final long serialVersionUID = -7213665316719480649L;

	private long codigo;
	private String descricao;
	private String descricaoAbreviada;
	private String unidadeMedida;
	private long quantidadeDisponivel;

	public InsumoVO() {
		super();
	}

	public InsumoVO(long codigo, String descricao, String descricaoAbreviada,
			String unidadeMedida, long quantidadeDisponivel) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.descricaoAbreviada = descricaoAbreviada;
		this.unidadeMedida = unidadeMedida;
		this.quantidadeDisponivel = quantidadeDisponivel;
	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricaoAbreviada() {
		return descricaoAbreviada;
	}

	public void setDescricaoAbreviada(String descricaoAbreviada) {
		this.descricaoAbreviada = descricaoAbreviada;
	}

	public String getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(String unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

	public long getQuantidadeDisponivel() {
		return quantidadeDisponivel;
	}

	public void setQuantidadeDisponivel(long quantidadeDisponivel) {
		this.quantidadeDisponivel = quantidadeDisponivel;
	}
	public String toString() {
		return descricaoAbreviada;
	}
}