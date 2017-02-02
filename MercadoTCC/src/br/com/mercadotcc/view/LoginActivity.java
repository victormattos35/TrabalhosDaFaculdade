package br.com.mercadotcc.view;

import br.com.jansenfelipe.androidmask.MaskEditTextChangedListener;
import br.com.mercadotcc.R;
import br.com.mercadotcc.util.Validate;
import br.com.mercadotcc.DO.LoginDO;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DigitalClock;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends Activity {
	private TextView txtLogin = null;
	private TextView txtSenha = null;
	private Button btnEntrar = null;
	private Button btnLimpar = null;
	private Button btnSair = null;
	private DigitalClock dgtRelogio = null;
	private TextView txtCadastrar = null;
	private ImageView imgLogin = null;

	/*@Override
	public void onAttachedToWindow() {
		this.getWindow().setType(WindowManager.LayoutParams.TYPE_KEYGUARD);
		super.onAttachedToWindow();
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.ECLAIR
				&& (keyCode == KeyEvent.KEYCODE_BACK || keyCode == KeyEvent.KEYCODE_HOME)
				&& event.getRepeatCount() == 0) {
			onBackPressed();
		}
		return super.onKeyDown(keyCode, event);
	}

	@Override
	public void onBackPressed() {
		// Do nothing
		return;
	}*/

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_view);

		if (android.os.Build.VERSION.SDK_INT > 9) {
			StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
					.permitAll().build();
			StrictMode.setThreadPolicy(policy);
		}

		txtLogin = (EditText) findViewById(R.id.txtLogin);
		txtSenha = (EditText) findViewById(R.id.txtSenha);
		btnEntrar = (Button) findViewById(R.id.btnEntrar);
		btnLimpar = (Button) findViewById(R.id.btnLimpar);
		btnSair = (Button) findViewById(R.id.btnSair);
		dgtRelogio = (DigitalClock) findViewById(R.id.dgtRelogio);
		txtCadastrar = (TextView) findViewById(R.id.txtCadastrar);
		imgLogin = (ImageView) findViewById(R.id.imgLogin);
		imgLogin.setImageResource(R.drawable.login);

		MaskEditTextChangedListener maskCPF = new MaskEditTextChangedListener(
				"###.###.###-##", (EditText) txtLogin);

		txtLogin.addTextChangedListener(maskCPF);

		txtLogin.setText("");
		txtSenha.setText("");

		btnSair.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Intent.ACTION_MAIN);
				intent.addCategory(Intent.CATEGORY_HOME);
				intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(intent);

			}
		});

		txtCadastrar.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				Intent it = new Intent(LoginActivity.this,
						CadastroActivity.class);
				startActivity(it);
			}
		});

		btnEntrar.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				boolean senha = Validate.validateNotNull(txtSenha,
						"SENHA EM BRANCO!");
				boolean login = Validate.validateNotNull(txtLogin,
						"LOGIN EM BRANCO!");

				if (!login) {

				} else if (!senha) {

				} else {
					LoginDO logindo = new LoginDO();
					boolean resultado = false;
					resultado = logindo.validate(txtLogin.getText().toString(),
							txtSenha.getText().toString());
					if (resultado == true) {
						Intent it = new Intent(LoginActivity.this,
								InicioActivity.class);
						startActivity(it);
					} else {
						Toast.makeText(LoginActivity.this,
								"Login ou Senha Incorretos !",
								Toast.LENGTH_SHORT).show();
					}

				}
			}
		});

		btnLimpar.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				txtLogin.setText("");
				txtSenha.setText("");
			}
		});
	}

}
