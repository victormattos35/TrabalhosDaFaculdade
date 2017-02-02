package br.com.controlefazenda.util;

import java.util.LinkedList;
import java.util.List;

public class ListUtil {

	public static List<String> convertToStringList(List<?> objects) {
		List<String> newList = new LinkedList<String>();

		if (objects != null && !objects.isEmpty()) {
			for (Object o : objects) {
				newList.add(o.toString());
			}
		}

		return newList;
	}

}
