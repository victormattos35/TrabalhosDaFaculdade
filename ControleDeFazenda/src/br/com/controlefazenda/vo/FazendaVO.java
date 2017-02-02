package br.com.controlefazenda.vo;

import java.io.Serializable;

public class FazendaVO implements Serializable {

	private static final long serialVersionUID = -5060790594357924761L;

	private long codigo;
	private String descricao;
	private String proprietario;
	private long qtdeAreaProdutiva;
	private long latitude;
	private long longitude;

	public FazendaVO() {
		super();
	}

	public FazendaVO(long codigo, String descricao, String proprietario,
			long qtdeAreaProdutiva, long latitude, long longitude) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.proprietario = proprietario;
		this.qtdeAreaProdutiva = qtdeAreaProdutiva;
		this.latitude = latitude;
		this.longitude = longitude;
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

	public String getProprietario() {
		return proprietario;
	}

	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}

	public long getQtdeAreaProdutiva() {
		return qtdeAreaProdutiva;
	}

	public void setQtdeAreaProdutiva(long qtdeAreaProdutiva) {
		this.qtdeAreaProdutiva = qtdeAreaProdutiva;
	}

	public long getLatitude() {
		return latitude;
	}

	public void setLatitude(long latitude) {
		this.latitude = latitude;
	}

	public long getLongitude() {
		return longitude;
	}

	public void setLongitude(long longitude) {
		this.longitude = longitude;
	}
	@Override
	public String toString() {
		return descricao;
	}
}