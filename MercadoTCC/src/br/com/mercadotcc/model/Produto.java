package br.com.mercadotcc.model;

public class Produto {
	private Long idproduto;
	private String descricao;
	private String marca;
	private String departamento;
	private String referencia;
	private Long quantidade;
	private Double valor_custo;
	private Double valor_venda;

	public Produto(Long idproduto, String descricao, String marca,
			String departamento, String referencia, Long quantidade,
			Double valor_custo, Double valor_venda) {
		this.idproduto = idproduto;
		this.descricao = descricao;
		this.marca = marca;
		this.departamento = departamento;
		this.referencia = referencia;
		this.quantidade = quantidade;
		this.valor_custo = valor_custo;
		this.valor_venda = valor_venda;

	}

	public Produto() {
		super();
	}

	public Long getIdproduto() {
		return idproduto;
	}

	public void setIdproduto(Long idproduto) {
		this.idproduto = idproduto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public Long getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}

	public Double getValor_custo() {
		return valor_custo;
	}

	public void setValor_custo(Double valor_custo) {
		this.valor_custo = valor_custo;
	}

	public Double getValor_venda() {
		return valor_venda;
	}

	public void setValor_venda(Double valor_venda) {
		this.valor_venda = valor_venda;
	}

	@Override
	public String toString() {
		return idproduto + " - " + descricao + " - R$: " + valor_venda;
	}

}
