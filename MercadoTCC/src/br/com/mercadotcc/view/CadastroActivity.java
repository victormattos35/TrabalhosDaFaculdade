package br.com.mercadotcc.view;

import br.com.jansenfelipe.androidmask.MaskEditTextChangedListener;
import br.com.mercadotcc.R;
import br.com.mercadotcc.DO.ClienteDO;
import br.com.mercadotcc.model.Cliente;
import br.com.mercadotcc.util.Validate;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CadastroActivity extends Activity {

	/*
	 * @Override public boolean onKeyDown(int keyCode, KeyEvent event) { if
	 * (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.ECLAIR
	 * && (keyCode == KeyEvent.KEYCODE_BACK || keyCode == KeyEvent.KEYCODE_HOME)
	 * && event.getRepeatCount() == 0) { onBackPressed(); } return
	 * super.onKeyDown(keyCode, event); }
	 * 
	 * @Override public void onBackPressed() { // Do nothing return; }
	 */

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cadastro_view);
		if (android.os.Build.VERSION.SDK_INT > 9) {
			StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
					.permitAll().build();
			StrictMode.setThreadPolicy(policy);
		}

		final EditText txtNome = (EditText) findViewById(R.id.txtCliente);
		final EditText txtCpf = (EditText) findViewById(R.id.txtCpf);
		final EditText txtSenha = (EditText) findViewById(R.id.txtSenha);
		final EditText txtTelefone = (EditText) findViewById(R.id.txtTelefone);
		final EditText txtCelular = (EditText) findViewById(R.id.txtCelular);
		final EditText txtEmail = (EditText) findViewById(R.id.txtEmail);
		final EditText txtCep = (EditText) findViewById(R.id.txtCep);
		final EditText txtEndereco = (EditText) findViewById(R.id.txtEndereco);
		final EditText txtNumero = (EditText) findViewById(R.id.txtNumero);
		final EditText txtBairro = (EditText) findViewById(R.id.txtBairro);
		final EditText txtComplemento = (EditText) findViewById(R.id.txtComplemento);
		final EditText txtCidade = (EditText) findViewById(R.id.txtCidade);
		final EditText txtEstado = (EditText) findViewById(R.id.txtEstado);
		Button btnCadastro = (Button) findViewById(R.id.btnCadastro);
		Button btnLimpar = (Button) findViewById(R.id.btnLimpar);
		Button btnCancelar = (Button) findViewById(R.id.btnCancelar);

		MaskEditTextChangedListener maskCPF = new MaskEditTextChangedListener(
				"###.###.###-##", (EditText) txtCpf);
		MaskEditTextChangedListener maskTelefone = new MaskEditTextChangedListener(
				"(##)####-####", (EditText) txtTelefone);
		MaskEditTextChangedListener maskCelular = new MaskEditTextChangedListener(
				"(##)#####-####", (EditText) txtCelular);
		MaskEditTextChangedListener maskCEP = new MaskEditTextChangedListener(
				"##.###-###", (EditText) txtCep);

		txtCpf.addTextChangedListener(maskCPF);
		txtTelefone.addTextChangedListener(maskTelefone);
		txtCelular.addTextChangedListener(maskCelular);
		txtCep.addTextChangedListener(maskCEP);

		txtNome.setText("");
		txtCpf.setText("");
		txtSenha.setText("");
		txtTelefone.setText("");
		txtCelular.setText("");
		txtEmail.setText("");
		txtCep.setText("");
		txtEndereco.setText("");
		txtNumero.setText("0");
		txtBairro.setText("");
		txtComplemento.setText("");
		txtCidade.setText("");
		txtEstado.setText("");

		btnLimpar.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				txtNome.setText("");
				txtCpf.setText("");
				txtSenha.setText("");
				txtTelefone.setText("");
				txtCelular.setText("");
				txtEmail.setText("");
				txtCep.setText("");
				txtEndereco.setText("");
				txtNumero.setText("0");
				txtBairro.setText("");
				txtComplemento.setText("");
				txtCidade.setText("");
				txtEstado.setText("");
			}
		});

		btnCadastro.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				try {
					boolean senha = Validate.validateNotNull(txtSenha,
							"SENHA EM BRANCO!");
					boolean cpf = Validate.validateNotNull(txtCpf,
							"CPF EM BRANCO!");
					boolean nome = Validate.validateNotNull(txtNome,
							"NOME EM BRANCO!");

					if (!nome && !senha && !cpf) {

					} else {

						ClienteDO clido = new ClienteDO();
						boolean resultado = clido.salvar(new Cliente(0L,
								txtNome.getText().toString(), txtCpf.getText()
										.toString(), txtSenha.getText()
										.toString(), txtTelefone.getText()
										.toString(), txtCelular.getText()
										.toString(), txtEmail.getText()
										.toString(), txtCep.getText()
										.toString(), txtEndereco.getText()
										.toString(), Long.parseLong(txtNumero
										.getText().toString()), txtComplemento
										.getText().toString(), txtBairro
										.getText().toString(), txtCidade
										.getText().toString(), txtEstado
										.getText().toString()));
						if (resultado) {
							finish();
						} else {
							Toast.makeText(CadastroActivity.this,
									"Erro no Cadastro!", Toast.LENGTH_LONG)
									.show();
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
					Toast.makeText(CadastroActivity.this, "Campos em Branco!",
							Toast.LENGTH_LONG).show();
				}

			}

		});
		btnCancelar.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent it = new Intent(CadastroActivity.this,
						LoginActivity.class);
				startActivity(it);
			}
		});

	}
}
