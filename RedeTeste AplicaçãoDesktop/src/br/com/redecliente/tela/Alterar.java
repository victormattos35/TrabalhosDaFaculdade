package br.com.redecliente.tela;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;


import br.com.redecliente.client.RedeClient;
import br.com.redecliente.domain.Rede;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Alterar extends JDialog {

	private JPanel contentPane;
	private JTextField textNome;
	private JTextField txtIdade;
	private Rede rede;
	private JLabel txtCodigo;
	private JFormattedTextField txtData;

	/**
	 * Launch the application.
	 */

	public Alterar(Rede r) {
		Alterar();
		mostrarDados(r);
		rede = r;
		setModal(true);
		
	}

	private void mostrarDados(Rede r) {
		txtCodigo.setText(Long.toString(r.getCodigo()));
		textNome.setText(r.getNome());
		txtIdade.setText(Long.toString(r.getIdade()));
		txtData.setText(r.getDataInsercao());
	}

	/**
	 * Create the frame.
	 */
	public void Alterar() {

		MaskFormatter maskData = null;
		try {
			maskData = new MaskFormatter("##/##/####");
		} catch (Exception e) {
			e.printStackTrace();
		}
		txtData = new JFormattedTextField(maskData);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCdigo = new JLabel("C\u00F3digo:");
		lblCdigo.setBounds(10, 37, 46, 14);
		contentPane.add(lblCdigo);

		txtCodigo = new JLabel("");
		txtCodigo.setBounds(97, 37, 46, 14);
		contentPane.add(txtCodigo);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 65, 46, 14);
		contentPane.add(lblNome);

		JLabel lblIdade = new JLabel("Idade:");
		lblIdade.setBounds(10, 90, 46, 14);
		contentPane.add(lblIdade);

		JLabel lblDataInsero = new JLabel("Data Inser\u00E7\u00E3o:");
		lblDataInsero.setBounds(10, 115, 90, 14);
		contentPane.add(lblDataInsero);

		textNome = new JTextField();
		textNome.setBounds(97, 62, 181, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);

		txtIdade = new JTextField();
		txtIdade.setBounds(97, 87, 181, 20);
		contentPane.add(txtIdade);
		txtIdade.setColumns(10);

		txtData = new JFormattedTextField();
		txtData.setBounds(97, 112, 181, 20);
		contentPane.add(txtData);

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alterarPessoa();
			}
		});
		btnAlterar.setBounds(11, 161, 89, 23);
		contentPane.add(btnAlterar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPrincipal menu = new MenuPrincipal();
				menu.setLocationRelativeTo(null);
				dispose();
				menu.setVisible(true);
			}
		});
		btnCancelar.setBounds(114, 161, 89, 23);
		contentPane.add(btnCancelar);

		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSair.setBounds(222, 161, 89, 23);
		contentPane.add(btnSair);

		JLabel lblAlterarPessoa = new JLabel("Alterar Pessoa");
		lblAlterarPessoa.setBounds(129, 12, 99, 14);
		contentPane.add(lblAlterarPessoa);
	}

	private void alterarPessoa() {
		try {
			rede.setNome(textNome.getText());
			rede.setIdade(Long.parseLong(txtIdade.getText()));
			rede.setDataInsercao(txtData.getText());
			RedeClient redecli = new RedeClient();
			redecli.alterar(rede);
			dispose();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}
}
