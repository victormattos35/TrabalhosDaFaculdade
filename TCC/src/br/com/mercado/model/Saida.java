package br.com.mercado.model;

import java.util.Date;

public class Saida {
	private Long idsaidaproduto;
	private Date dia;
	private String observacao;
	private Produto produto = new Produto();
	public Long getIdsaidaproduto() {
		return idsaidaproduto;
	}
	public void setIdsaidaproduto(Long idsaidaproduto) {
		this.idsaidaproduto = idsaidaproduto;
	}
	public Date getDia() {
		return dia;
	}
	public void setDia(Date dia) {
		this.dia = dia;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	
}
