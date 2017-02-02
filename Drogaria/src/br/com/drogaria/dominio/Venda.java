package br.com.drogaria.dominio;

/**
 * @author Victor Elias
 *
 */
public class Venda {
	private Long idvenda;
	private String dia;
	private Double valortotal;
	private Cliente cliente;

	public Long getIdvenda() {
		return idvenda;
	}

	public void setIdvenda(Long idvenda) {
		this.idvenda = idvenda;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public Double getValortotal() {
		return valortotal;
	}

	public void setValortotal(Double valortotal) {
		this.valortotal = valortotal;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
