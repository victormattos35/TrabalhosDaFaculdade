package br.com.drogaria.dominio;


public class Item {
	private Long codigo;
	private Double valor_parcial;
	private Integer quantidade;
	private Venda venda;
	private Produto produto;
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Double getValor_parcial() {
		return valor_parcial;
	}
	public void setValor_parcial(Double valor_parcial) {
		this.valor_parcial = valor_parcial;
	}

	
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
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
