package br.com.controlefazenda.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
import br.com.controlefazenda.R;
import br.com.controlefazenda.bo.InsumoBO;
import br.com.controlefazenda.vo.InsumoVO;

public class CadastroInsumo extends Activity{
	private InsumoVO insumo = null;
	private InsumoBO insumoBO = InsumoBO.getInstance();
	private boolean isUpdate = false;
	
	private TextView lblCodigoInsumo = null;
	private TextView lblDescricaoInsumo = null;
	private TextView lblDescricaoAbreviadaInsumo = null;
	private TextView lblUnidadeMedidaInsumo = null;
	private TextView lblQtdeDisponivelInsumo = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cadastro_insumo);
		
		lblCodigoInsumo = (TextView) findViewById(R.id.lblCodigoInsumo);
		lblDescricaoInsumo = (TextView) findViewById(R.id.lblDescricaoInsumo);
		lblDescricaoAbreviadaInsumo = (TextView) findViewById(R.id.lblDescricaoAbreviadaInsumo);
		lblUnidadeMedidaInsumo = (TextView) findViewById(R.id.lblUnidadeMedidaInsumo);
		lblQtdeDisponivelInsumo = (TextView) findViewById(R.id.lblQtdeDisponivelInsumo);
		
		Bundle parametros = getIntent().getExtras();
		
		if (parametros != null && !parametros.isEmpty()) {
			if (parametros.containsKey(ListaInsumo.INSUMO)) {
				this.insumo = (InsumoVO) parametros.getSerializable(ListaInsumo.INSUMO);
				this.isUpdate = true;
				
				lblCodigoInsumo.setText(Long.toString(this.insumo.getCodigo()));
				lblDescricaoInsumo.setText(this.insumo.getDescricao());
				lblDescricaoAbreviadaInsumo.setText(this.insumo.getDescricaoAbreviada());
				lblUnidadeMedidaInsumo.setText(this.insumo.getUnidadeMedida());
				lblQtdeDisponivelInsumo.setText(Long.toString(this.insumo.getQuantidadeDisponivel()));
				}
		}
		
		if (!this.isUpdate) {
			this.insumo = new InsumoVO();
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
		Long codigo = Long.parseLong(lblCodigoInsumo.getText().toString());
		String descricao = lblDescricaoInsumo.getText().toString();
		String descricaoAbreviada = lblDescricaoAbreviadaInsumo.getText().toString();
		String unidadeMedida = lblUnidadeMedidaInsumo.getText().toString();
		Long qtdeDisponivel = Long.parseLong(lblQtdeDisponivelInsumo.getText().toString());
		
		this.insumo.setCodigo(codigo);
		this.insumo.setDescricao(descricao);
		this.insumo.setDescricaoAbreviada(descricaoAbreviada);
		this.insumo.setUnidadeMedida(unidadeMedida);
		this.insumo.setQuantidadeDisponivel(qtdeDisponivel);
		
		try {
			if (!this.isUpdate) {
				insumoBO.inserir(this, this.insumo);
			} else {
				insumoBO.alterar(this, this.insumo);
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
