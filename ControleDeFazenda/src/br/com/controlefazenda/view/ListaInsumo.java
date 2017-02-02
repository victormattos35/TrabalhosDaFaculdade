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
import br.com.controlefazenda.adapter.InsumoAdapter;
import br.com.controlefazenda.bo.InsumoBO;
import br.com.controlefazenda.vo.InsumoVO;

public class ListaInsumo extends ListActivity {
	public static final int REQUEST_INSERIR = 1000;
	public static final int REQUEST_ALTERAR = 1001;
	public static final int REQUEST_SEARCH = 1002;
	public static final String INSUMO = "INSUMO";

	private InsumoBO insumoBO = InsumoBO.getInstance();

	private List<InsumoVO> insumos = null;
	private InsumoVO insumo = null;

	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		getListView().setOnItemClickListener(
				new AdapterView.OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> adapter, View view,
							int position, long id) {
						insumo = insumos.get(position);
						Toast.makeText(ListaInsumo.this, insumo.toString(),
								Toast.LENGTH_SHORT).show();

					}

				});
		carregarInsumos();
	}

	private void carregarInsumos() {
		this.insumo = null;
		try {
			this.insumos = insumoBO.selecionarTodos(this);
		} catch (Exception e) {
			Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
		}

		InsumoAdapter insumo = new InsumoAdapter(this, insumos);
		getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		setListAdapter(insumo);
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
		Intent iIns = new Intent(ListaInsumo.this, CadastroInsumo.class);
		startActivityForResult(iIns, REQUEST_INSERIR);
	}

	private void alterar() {
		Intent iIns = new Intent(ListaInsumo.this, CadastroInsumo.class);

		Bundle parametros = new Bundle();
		parametros.putSerializable(INSUMO, insumo);

		iIns.putExtras(parametros);
		startActivityForResult(iIns, REQUEST_ALTERAR);

	}

	private void confirmarRemocao() {
		if (insumo != null) {
			AlertDialog.Builder builder = new AlertDialog.Builder(
					ListaInsumo.this);
			builder.setTitle(getResources().getString(
					R.string.lblJanelaConfirmacao));
			builder.setMessage(getResources().getString(
					R.string.lblConfirmaRemocaoInsumo));
			builder.setCancelable(false);
			builder.setPositiveButton(
					getResources().getString(R.string.lblSim),
					new DialogInterface.OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int position) {
							remover();
						}
					});
			builder.setNegativeButton(
					getResources().getString(R.string.lblNao), null);
			builder.setNeutralButton(
					getResources().getString(R.string.lblCancelar), null);

			AlertDialog dialog = builder.create();
			dialog.show();
		}
	}

	private void remover() {
		try {
			insumoBO.remover(this, insumo.getCodigo());
		} catch (Exception e) {
			Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
		}
		carregarInsumos();
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == REQUEST_INSERIR || requestCode == REQUEST_ALTERAR) {
			if (resultCode == Activity.RESULT_OK) {
				carregarInsumos();

				Toast.makeText(ListaInsumo.this,
						getResources().getString(R.string.lblMensagemOk),
						Toast.LENGTH_SHORT).show();
			} else {
				Toast.makeText(
						ListaInsumo.this,
						getResources().getString(R.string.lblMensagemCancelada),
						Toast.LENGTH_SHORT).show();
			}
		}
	}
}
