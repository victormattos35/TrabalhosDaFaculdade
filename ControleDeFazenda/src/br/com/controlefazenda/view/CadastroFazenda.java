package br.com.controlefazenda.view;

import br.com.controlefazenda.R;
import br.com.controlefazenda.bo.FazendaBO;
import br.com.controlefazenda.vo.FazendaVO;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;


public class CadastroFazenda extends Activity{
	private FazendaVO fazenda = null;
	private FazendaBO fazendaBO = FazendaBO.getInstance();
	private boolean isUpdate = false;
	
	private TextView txtCodigo = null;
	private TextView txtDescricao = null;
	private TextView txtProprietario = null;
	private TextView txtQtdeProdutiva = null;
	private TextView txtLatitude = null;
	private TextView txtLongitude = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cadastro_fazenda);
		
		txtCodigo = (TextView) findViewById(R.id.txtCodigo);
		txtDescricao = (TextView) findViewById(R.id.txtDescricao);
		txtProprietario = (TextView) findViewById(R.id.txtProprietario);
		txtQtdeProdutiva = (TextView) findViewById(R.id.txtQtdeProdutiva);
		txtLatitude = (TextView) findViewById(R.id.txtLatitude);
		txtLongitude = (TextView) findViewById(R.id.txtLongitude);
		
		Bundle parametros = getIntent().getExtras();
		
		if (parametros != null && !parametros.isEmpty()) {
			if (parametros.containsKey(ListaFazenda.FAZENDA)) {
				this.fazenda = (FazendaVO) parametros.getSerializable(ListaFazenda.FAZENDA);
				this.isUpdate = true;
				
				txtCodigo.setText(Long.toString(this.fazenda.getCodigo()));
				txtDescricao.setText(this.fazenda.getDescricao());
				txtProprietario.setText(this.fazenda.getProprietario());
				txtQtdeProdutiva.setText(Long.toString(this.fazenda.getQtdeAreaProdutiva()));
				txtLatitude.setText(Long.toString(this.fazenda.getLatitude()));
				txtLongitude.setText(Long.toString(this.fazenda.getLongitude()));
				}
		}
		
		if (!this.isUpdate) {
			this.fazenda = new FazendaVO();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		
		inflater.inflate(R.menu.menu_cadastro, menu);
		
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.itemConfirmar:
			confirmar();
			break;
		case R.id.itemCancelar:
			cancelar();
		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}
	
	
	
	private void confirmar() {
		Long codigo = Long.parseLong(txtCodigo.getText().toString());
		String descricao = txtDescricao.getText().toString();
		String proprietario = txtProprietario.getText().toString();
		Long qtdeProduto = Long.parseLong(txtQtdeProdutiva.getText().toString());
		Long latitude = Long.parseLong(txtLatitude.getText().toString());
		Long longitude = Long.parseLong(txtLongitude.getText().toString());
		
		this.fazenda.setCodigo(codigo);
		this.fazenda.setDescricao(descricao);
		this.fazenda.setProprietario(proprietario);
		this.fazenda.setQtdeAreaProdutiva(qtdeProduto);
		this.fazenda.setLatitude(latitude);
		this.fazenda.setLongitude(longitude);
		
		try {
			if (!this.isUpdate) {
				fazendaBO.inserir(this, this.fazenda);
			} else {
				fazendaBO.alterar(this, this.fazenda);
			}
		} catch (Exception e) {
			Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
		}
		
		setResult(Activity.RESULT_OK);
		finish();
	}
	
	private void cancelar() {
		setResult(Activity.RESULT_CANCELED);
		finish();
	}

}
