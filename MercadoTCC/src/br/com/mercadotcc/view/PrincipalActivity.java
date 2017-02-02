package br.com.mercadotcc.view;

import java.util.ArrayList;

import br.com.mercadotcc.R;
import br.com.mercadotcc.DO.ClienteDO;
import br.com.mercadotcc.model.Cliente;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class PrincipalActivity extends Activity {

	private ListView viewCliente; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.principal_view);

		Button btnCadastro1 = (Button) findViewById(R.id.btnCadastro1);
		viewCliente = (ListView) findViewById(R.id.viewCliente);
		
		if (android.os.Build.VERSION.SDK_INT > 9) {
			StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
					.permitAll().build();
			StrictMode.setThreadPolicy(policy);
		}
		
		btnCadastro1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent it = new Intent(PrincipalActivity.this, CadastroActivity.class);
				startActivity(it);
			}
		});

		
		/*ClienteDO clido = new ClienteDO();
		boolean resultado = clido.salvar(new Cliente(0L, "2", "1", "1", "1",
				"1", "1", "1", "1", 0L, "1", "1", "1", "1"));
		Log.d("Exemplo", resultado + "");

		ArrayList<Cliente> lista = clido.listar();
		Log.d("Exemplo", lista.toString() + "");

		boolean resp = clido.editar(new Cliente(3L, "2", "2", "2", "2", "2",
				"2", "2", "2", 0L, "1", "1", "1", "1"));
		Log.d("Exemplo", resp + "");

		boolean resp2 = clido.excluir(2L);
		Log.d("Exemplo", resp2 + "");*/
		
		
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		ClienteDO clido = new ClienteDO();
		ArrayList<Cliente> lista = clido.listar();
		ArrayAdapter<Cliente> adpCliente = new ArrayAdapter<Cliente>(this, android.R.layout.simple_list_item_1, lista);
		viewCliente.setAdapter(adpCliente);
	}
}