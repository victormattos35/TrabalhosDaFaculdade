package br.com.mercadotcc.view;

import java.util.ArrayList;

import br.com.mercadotcc.R;
import br.com.mercadotcc.DO.ProdutoDO;
import br.com.mercadotcc.model.Produto;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class ProdutoView extends Activity {
	private ListView viewProduto;
	private Button btnVoltar = null;
	
	/*@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.ECLAIR
				&& (keyCode == KeyEvent.KEYCODE_BACK || keyCode == KeyEvent.KEYCODE_HOME)
				&& event.getRepeatCount() == 0) {
			onBackPressed();
		}
		return super.onKeyDown(keyCode, event);
	}

	@Override
	public void onBackPressed() {
		// Do nothing
		return;
	}*/

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lista_produto_view);
		btnVoltar = (Button) findViewById(R.id.btnVoltar);
		viewProduto = (ListView) findViewById(R.id.viewProduto);
		ProdutoDO prodo = new ProdutoDO();
		ArrayList<Produto> lista = prodo.listar();
		ArrayAdapter<Produto> adpProduto = new ArrayAdapter<Produto>(this,
				android.R.layout.simple_list_item_1, lista);
		viewProduto.setAdapter(adpProduto);
		btnVoltar.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent it = new Intent(ProdutoView.this, InicioActivity.class);
				startActivity(it);

			}
		});

	}

}
