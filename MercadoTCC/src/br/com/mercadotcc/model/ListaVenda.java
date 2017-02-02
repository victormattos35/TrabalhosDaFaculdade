package br.com.mercadotcc.model;

public class ListaVenda {
	private Long idvendaitens;
	private Long quantidade;
	private Double valortotal;
	private Venda venda;
	private Produto produto;
	public Long getIdvendaitens() {
		return idvendaitens;
	}
	public void setIdvendaitens(Long idvendaitens) {
		this.idvendaitens = idvendaitens;
	}
	public Long getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}
	public Double getValortotal() {
		return valortotal;
	}
	public void setValortotal(Double valortotal) {
		this.valortotal = valortotal;
	}
	public Venda getVenda() {
		return venda;
	}
	public void setVenda(Venda venda) {
		this.venda = venda;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
}
