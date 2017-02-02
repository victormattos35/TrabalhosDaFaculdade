package br.com.controlefazenda.view;

import br.com.controlefazenda.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FazendaActivity extends Activity{
	
	private Button cadFunc = null;
	private Button cadInsu = null;
	private Button cadFaz = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.principal_layout);
		
		cadFaz = (Button) findViewById(R.id.cadFaz);
		cadFunc = (Button) findViewById(R.id.cadFunc);
		cadInsu = (Button) findViewById(R.id.cadInsu);
		
		cadFaz.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				exibirFazendas();
			}
		});
		
		cadFunc.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				exibirFuncionario();
			}
		});
		
		cadInsu.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				exibirInsumo();
			}
		});
		
	}
	

	private void exibirFuncionario() {
		Intent iFunc = new Intent(this, ListaFuncionario.class);
		startActivity(iFunc);
	}

	private void exibirFazendas() {
		Intent iFaz = new Intent(this, ListaFazenda.class);
		startActivity(iFaz);
	}
	
	private void exibirInsumo() {
		Intent iIns = new Intent(this, ListaInsumo.class);
		startActivity(iIns);
	}

}
