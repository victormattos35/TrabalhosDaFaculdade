package br.com.drogaria.util;

import java.text.DateFormat;
import java.util.Date;

public class ConverteDate {
	public String date(){
		Date data = new Date();
		DateFormat formataData = DateFormat.getDateInstance();
		return formataData.format(data);
	}
}
