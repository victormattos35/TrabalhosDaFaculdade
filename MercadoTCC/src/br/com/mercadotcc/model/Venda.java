package br.com.mercadotcc.model;

import java.util.Date;

public class Venda {
	private Long idvenda;
	private Date dia;
	private Double valortotal;
	private Cliente cliente;

	public Long getIdvenda() {
		return idvenda;
	}

	public void setIdvenda(Long idvenda) {
		this.idvenda = idvenda;
	}

	public Date getDia() {
		return dia;
	}

	public void setDia(Date dia) {
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
