package br.com.controlefazenda.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class DateUtil {

	public static DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
	public static DateFormat full_fmt = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	public static Date parse(String data) {
		try {
			return fmt.parse(data);
		} catch (Exception e) {
			return null;
		}
	}

	public static String format(Date data) {
		try {
			return fmt.format(data);
		} catch (Exception e) {
			return null;
		}
	}

}
