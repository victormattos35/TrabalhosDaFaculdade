package br.com.controlefazenda.view;

import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import br.com.controlefazenda.R;
import br.com.controlefazenda.adapter.FazendaAdapter;
import br.com.controlefazenda.bo.FazendaBO;
import br.com.controlefazenda.vo.FazendaVO;

public class ListaFazenda extends ListActivity {

	public static final int REQUEST_INSERIR = 1000;
	public static final int REQUEST_ALTERAR = 1001;
	public static final int REQUEST_SEARCH = 1002;
	public static final String FAZENDA = "FAZENDA";
	
	private FazendaBO fazendaBO = FazendaBO.getInstance();

	private List<FazendaVO> fazendas = null;
	private FazendaVO fazenda = null;

	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> adapter, View view, int position,
					long id) {
				fazenda = fazendas.get(position);
				Toast.makeText(ListaFazenda.this, fazenda.toString(), Toast.LENGTH_SHORT).show();
				
			}
			
		});
		carregarFazendas();
	}
	
	private void carregarFazendas() {
		this.fazenda = null;
		try {
			this.fazendas = fazendaBO.selecionarTodos(this);
		} catch (Exception e) {
			Toast.makeText(this,  e.getMessage(), Toast.LENGTH_SHORT).show();
		}
		
		FazendaAdapter faz = new FazendaAdapter(this, fazendas);
		getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		setListAdapter(faz);
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu_listagem, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.itemInserir:
			gravar();
			break;
		case R.id.itemAlterar:
			alterar();
			break;
		case R.id.itemRemover:
			confirmarRemocao();
			break;
		}
		return true;
	}

	private void gravar() {
		Intent iFaz = new Intent(ListaFazenda.this, CadastroFazenda.class);
		startActivityForResult(iFaz, REQUEST_INSERIR);
	}
	
	private void alterar() {
		Intent iFaz = new Intent(ListaFazenda.this, CadastroFazenda.class);
		
		Bundle parametros = new Bundle();
		parametros.putSerializable(FAZENDA, fazenda);
		
		iFaz.putExtras(parametros);
		startActivityForResult(iFaz, REQUEST_ALTERAR);
		
	}
	
	private void confirmarRemocao() {
		if (fazenda != null) {
			AlertDialog.Builder builder = new AlertDialog.Builder(ListaFazenda.this);
			builder.setTitle(getResources().getString(R.string.lblJanelaConfirmacao));
			builder.setMessage(getResources().getString(R.string.lblConfirmaRemocaoFazenda));
			builder.setCancelable(false);
			builder.setPositiveButton(getResources().getString(R.string.lblSim), new DialogInterface.OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int position) {
					remover();
				}
			});
			builder.setNegativeButton(getResources().getString(R.string.lblNao), null);
			builder.setNeutralButton(getResources().getString(R.string.lblCancelar), null);

			AlertDialog dialog = builder.create();
			dialog.show();
		}
	}
	
	private void remover() {
		try {
			fazendaBO.remover(this, fazenda.getCodigo());
		} catch (Exception e) {
			Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
		}
		carregarFazendas();
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == REQUEST_INSERIR || requestCode == REQUEST_ALTERAR) {
			if (resultCode == Activity.RESULT_OK) {
				carregarFazendas();

				Toast.makeText(ListaFazenda.this, getResources().getString(R.string.lblMensagemOk), Toast.LENGTH_SHORT).show();
			} else {
				Toast.makeText(ListaFazenda.this, getResources().getString(R.string.lblMensagemCancelada), Toast.LENGTH_SHORT).show();
			}
		}
	}
}
