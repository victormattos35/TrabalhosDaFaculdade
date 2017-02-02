package br.com.mercadotcc.util;

import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class Validate {
	public static boolean validateNotNull(View pView, String pMessage) {
		if (pView instanceof EditText) {
			EditText edText = (EditText) pView;
			Editable text = edText.getText();
			if (text != null) {
				String strText = text.toString().trim();
				if (!TextUtils.isEmpty(strText)) {
					return true;
				}
			}
			// em qualquer outra condição é gerado um erro
			edText.setError(pMessage);
			edText.setFocusable(true);
			edText.requestFocus();
			return false;
		}
		return false;
	}
}
