package br.com.controlefazenda.view;

import java.util.Date;

import br.com.controlefazenda.R;
import br.com.controlefazenda.bo.FuncionarioBO;
import br.com.controlefazenda.util.DateUtil;
import br.com.controlefazenda.vo.FuncionarioVO;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class CadastroFuncionario extends Activity{
	
	private FuncionarioVO funcionario = null;
	private FuncionarioBO funcionarioBO = FuncionarioBO.getInstance();
	private boolean isUpdate = false;
	
	private TextView txtMatricula = null;
	private TextView txtNome = null;
	private RadioGroup rdgSexo = null;
	private TextView txtDataNascimento = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cadastro_funcionario);
		
		txtMatricula = (TextView) findViewById(R.id.lblMatricula);
		txtNome = (TextView) findViewById(R.id.lblNome);
		rdgSexo = (RadioGroup) findViewById(R.id.rdgSexo);
		txtDataNascimento = (TextView) findViewById(R.id.lblDataNascimento);
		
		Bundle parametros = getIntent().getExtras();
		
		if (parametros != null && !parametros.isEmpty()) {
			if (parametros.containsKey(ListaFuncionario.FUNCIONARIO)) {
				this.funcionario = (FuncionarioVO) parametros.getSerializable(ListaFuncionario.FUNCIONARIO);
				this.isUpdate = true;
				
				txtMatricula.setText(Long.toString(this.funcionario.getMatricula()));
				txtNome.setText(this.funcionario.getNome());
				txtDataNascimento.setText(this.funcionario.getDataDeNascimento() != null ? DateUtil.format(this.funcionario.getDataDeNascimento()) : "");
				rdgSexo.check("M".equals(this.funcionario.getSexo()) ? R.id.rdMasculino : R.id.rdFeminino);
			}
		}
		
		if (!this.isUpdate) {
			this.funcionario = new FuncionarioVO();
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
		Long matricula = Long.parseLong(txtMatricula.getText().toString());
		String nome = txtNome.getText().toString();
		Date dataNascimento = null;
		try {
			dataNascimento = DateUtil.parse(txtDataNascimento.getText().toString());
		} catch (Exception e) {
		}
		String sexo = rdgSexo.getCheckedRadioButtonId() == R.id.rdMasculino ? "M" : "F";

		
		this.funcionario.setMatricula(matricula);
		this.funcionario.setNome(nome);
		this.funcionario.setSexo(sexo);
		this.funcionario.setDataDeNascimento(dataNascimento);

		try {
			if (!this.isUpdate) {
				funcionarioBO.inserir(this, this.funcionario);
			} else {
				funcionarioBO.alterar(this, this.funcionario);
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
