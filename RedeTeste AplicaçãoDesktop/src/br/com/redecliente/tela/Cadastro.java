package br.com.redecliente.tela;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import br.com.redecliente.client.RedeClient;
import br.com.redecliente.domain.Rede;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;

public class Cadastro extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtNome;
	private JTextField txtIdade;
	private JButton btnSalvar;
	private JLabel txtResultado;
	private JFormattedTextField txtData;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Cadastro dialog = new Cadastro();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Cadastro() {
		MaskFormatter maskData = null;
		try {
			maskData = new MaskFormatter("##/##/####");
		} catch (Exception e) {
			e.printStackTrace();
		}

		setBounds(100, 100, 432, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		txtNome = new JTextField();
		txtNome.setBounds(106, 28, 184, 20);
		contentPanel.add(txtNome);
		txtNome.setColumns(10);

		txtIdade = new JTextField();
		txtIdade.setBounds(106, 59, 184, 20);
		contentPanel.add(txtIdade);
		txtIdade.setColumns(10);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 31, 46, 14);
		contentPanel.add(lblNome);

		JLabel lblIdade = new JLabel("Idade:");
		lblIdade.setBounds(10, 62, 46, 14);
		contentPanel.add(lblIdade);

		JLabel lblDataInsero = new JLabel("Data Inser\u00E7\u00E3o:");
		lblDataInsero.setBounds(10, 93, 86, 14);
		contentPanel.add(lblDataInsero);

		JLabel lblCadastroDePessoa = new JLabel("Cadastro de Pessoa");
		lblCadastroDePessoa.setBounds(47, 3, 184, 14);
		contentPanel.add(lblCadastroDePessoa);

		txtData = new JFormattedTextField(maskData);
		txtData.setBounds(106, 90, 184, 20);
		contentPanel.add(txtData);

		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Rede rede = new Rede();
					rede.setNome(txtNome.getText());
					rede.setIdade(Long.parseLong(txtIdade.getText()));
					rede.setDataInsercao(txtData.getText());
					RedeClient redecli = new RedeClient();
					redecli.salvar(rede);
					txtResultado.setText("SUCESSO!");

					limpar();
				} catch (Exception e1) {
					e1.printStackTrace();
					txtResultado.setText("ERRO!");

				}
			}
		});
		btnSalvar.setBounds(28, 121, 89, 23);
		contentPanel.add(btnSalvar);

		JButton btnCancelar = new JButton("Sair");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(127, 121, 89, 23);
		contentPanel.add(btnCancelar);

		txtResultado = new JLabel("");
		txtResultado.setBounds(244, 130, 136, 14);
		contentPanel.add(txtResultado);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(75, 164, 89, 23);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPrincipal menu = new MenuPrincipal();
				menu.setLocationRelativeTo(null);
				dispose();
				menu.setVisible(true);
			}
		});
		contentPanel.add(btnVoltar);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}

	}

	public void limpar() {
		txtNome.setText("");
		txtIdade.setText("");
		txtData.setText("");
	}
}
