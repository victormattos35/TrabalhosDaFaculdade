package br.com.redeteste.domain;

public class Dados {
	private String DEPCODIGO;

	private String DEPDESCRI;

	private boolean nextpageurl;

	private String links;

	public String getDEPCODIGO() {
		return DEPCODIGO;
	}

	public void setDEPCODIGO(String dEPCODIGO) {
		this.DEPCODIGO = dEPCODIGO;
	}

	public String getDEPDESCRI() {
		return DEPDESCRI;
	}

	public void setDEPDESCRI(String dEPDESCRI) {
		this.DEPDESCRI = dEPDESCRI;
	}

	public boolean getNextpageurl() {
		return nextpageurl;
	}

	public void setNextpageurl(boolean nextpageurl) {
		this.nextpageurl = nextpageurl;
	}

	public String getLinks() {
		return this.links;
	}

	public void setLinks(String links) {
		this.links = links;
	}

	@Override
	public String toString() {
		return "Dados [DEPCODIGO=" + DEPCODIGO + ", DEPDESCRI=" + DEPDESCRI
				+ ", nextpageurl=" + nextpageurl + ", links=" + links + "]";
	}
	
	

}
