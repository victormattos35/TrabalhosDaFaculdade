package br.com.mercadotcc.view;

import br.com.mercadotcc.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

public class InicioActivity extends Activity {
	private Button btnLista = null;
	private Button btnCompra = null;
	private Button btnLogout = null;
	private ImageView imgBanner = null;
	
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
		setContentView(R.layout.inicio_view);
		
		btnLista = (Button) findViewById(R.id.btnLista);
		btnCompra = (Button) findViewById(R.id.btnCompra);
		btnLogout = (Button) findViewById(R.id.btnLogout);
		imgBanner = (ImageView) findViewById(R.id.imgBanner);
		imgBanner.setImageResource(R.drawable.banner2);
		
		btnLogout.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent it = new Intent(InicioActivity.this, LoginActivity.class);
				startActivity(it);
			}
		});
		
		btnCompra.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent it = new Intent(InicioActivity.this, ListaActivity.class);
				startActivity(it);
				
			}
		});
		
		btnLista.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent it = new Intent(InicioActivity.this, ProdutoView.class);
				startActivity(it);
			}
		});
	}
}
