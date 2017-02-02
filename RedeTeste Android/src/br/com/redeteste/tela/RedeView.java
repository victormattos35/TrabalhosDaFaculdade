package br.com.redeteste.tela;

import java.util.ArrayList;

import br.com.redeteste.R;
import br.com.redeteste.domain.Dados;
import br.com.redeteste.service.BuscaService;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class RedeView extends Activity {

	private Button btnVoltar = null;
	private ListView viewDados = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.view_rede);
		btnVoltar = (Button) findViewById(R.id.btnVoltar);
		viewDados = (ListView) findViewById(R.id.listDados);
		BuscaService buscaService = new BuscaService();
		ArrayList<Dados> lista = buscaService.listar();
		System.out.println(lista);
		Log.i("Erro: ", lista.toString());
		ArrayAdapter<Dados> adpDados = new ArrayAdapter<Dados>(this,
				android.R.layout.simple_list_item_1, lista);
		viewDados.setAdapter(adpDados);
		btnVoltar.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Intent.ACTION_MAIN);
				intent.addCategory(Intent.CATEGORY_HOME);
				intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(intent);

			}
		});
	}
}
