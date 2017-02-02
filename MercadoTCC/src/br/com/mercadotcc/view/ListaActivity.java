package br.com.mercadotcc.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import br.com.mercadotcc.R;
import br.com.mercadotcc.DO.ListaVendaDO;

public class ListaActivity extends Activity {

	public static final int REQUEST_CODE = 0;
	private TextView txtResult;
	private TextView txtTeste;
	private String teste;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lista_compra_view);

		txtTeste = (TextView) findViewById(R.id.txtTeste);
		

	}

	public void callZXing(View view) {
		Intent it = new Intent(ListaActivity.this,
				com.google.zxing.client.android.CaptureActivity.class);
		startActivityForResult(it, REQUEST_CODE);
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (REQUEST_CODE == requestCode && RESULT_OK == resultCode) {
			teste = data.getStringExtra("SCAN_RESULT");
			ListaVendaDO vendado = new ListaVendaDO();
			txtTeste.setText("" + vendado.buscar(teste));
		}
	}
}