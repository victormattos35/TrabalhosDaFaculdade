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
import br.com.controlefazenda.adapter.FuncionarioAdapter;
import br.com.controlefazenda.bo.FuncionarioBO;
import br.com.controlefazenda.vo.FuncionarioVO;

public class ListaFuncionario extends ListActivity{
	public static final int REQUEST_INSERIR = 1000;
	public static final int REQUEST_ALTERAR = 1001;
	public static final int REQUEST_SEARCH = 1002;
	public static final String FUNCIONARIO = "FUNCIONARIO";
	
	private FuncionarioBO funcionarioBO = FuncionarioBO.getInstance();

	private List<FuncionarioVO> funcionarios = null;
	private FuncionarioVO funcionario = null;

	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> adapter, View view, int position,
					long id) {
				funcionario = funcionarios.get(position);
				Toast.makeText(ListaFuncionario.this, funcionario.toString(), Toast.LENGTH_SHORT).show();
				
			}
			
		});
		carregarFuncionarios();
	}
	
	private void carregarFuncionarios() {
		this.funcionario = null;
		try {
			this.funcionarios = funcionarioBO.selecionarTodos(this);
		} catch (Exception e) {
			Toast.makeText(this,  e.getMessage(), Toast.LENGTH_SHORT).show();
		}
		
		FuncionarioAdapter fun = new FuncionarioAdapter(this, funcionarios);
		getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		setListAdapter(fun);
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
		Intent iFunc = new Intent(ListaFuncionario.this, CadastroFuncionario.class);
		startActivityForResult(iFunc, REQUEST_INSERIR);
	}
	
	private void alterar() {
		Intent iFunc = new Intent(ListaFuncionario.this, CadastroFuncionario.class);
		
		Bundle parametros = new Bundle();
		parametros.putSerializable(FUNCIONARIO, funcionario);
		
		iFunc.putExtras(parametros);
		startActivityForResult(iFunc, REQUEST_ALTERAR);
		
	}
	
	private void confirmarRemocao() {
		if (funcionario != null) {
			AlertDialog.Builder builder = new AlertDialog.Builder(ListaFuncionario.this);
			builder.setTitle(getResources().getString(R.string.lblJanelaConfirmacao));
			builder.setMessage(getResources().getString(R.string.lblConfirmaRemocaoFuncionario));
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
			funcionarioBO.remover(this, funcionario.getMatricula());
		} catch (Exception e) {
			Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
		}
		carregarFuncionarios();
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == REQUEST_INSERIR || requestCode == REQUEST_ALTERAR) {
			if (resultCode == Activity.RESULT_OK) {
				carregarFuncionarios();

				Toast.makeText(ListaFuncionario.this, getResources().getString(R.string.lblMensagemOk), Toast.LENGTH_SHORT).show();
			} else {
				Toast.makeText(ListaFuncionario.this, getResources().getString(R.string.lblMensagemCancelada), Toast.LENGTH_SHORT).show();
			}
		}
	}
}
