package br.com.mercado.util;

import java.util.Date;

public class Datas {
	public static java.sql.Date javaDateParaSqlDate(java.util.Date data) {
		return new java.sql.Date(data.getTime());
	}

	public static java.util.Date sqlDateParaJavaDate(java.sql.Date data) {
		return new Date(data.getTime());
	}
}
