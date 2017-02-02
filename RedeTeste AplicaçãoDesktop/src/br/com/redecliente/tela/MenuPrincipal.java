package br.com.redecliente.tela;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class MenuPrincipal extends JDialog {

	private final JPanel contentPanel = new JPanel();

	//MenuPrincipal menu = new MenuPrincipal();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			MenuPrincipal dialog = new MenuPrincipal();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public MenuPrincipal() {
		setBounds(100, 100, 493, 180);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton btnSalvar = new JButton("Novo");
			btnSalvar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Cadastro cad = new Cadastro();
					cad.setLocationRelativeTo(null);
					dispose();
					cad.setVisible(true);
					//menu.dispose();
					
				}
			});
			btnSalvar.setBounds(67, 75, 89, 23);
			contentPanel.add(btnSalvar);
		}
		{
			JButton btnListar = new JButton("Listar");
			btnListar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Listar list = new Listar();
					list.setLocationRelativeTo(null);
					dispose();
					list.setVisible(true);
				}
			});
			btnListar.setBounds(190, 75, 89, 23);
			contentPanel.add(btnListar);
		}
		{
			JButton btnSair = new JButton("Sair");
			btnSair.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnSair.setBounds(319, 75, 89, 23);
			contentPanel.add(btnSair);
		}
		
		JLabel lblMenuDeOpes = new JLabel("MENU DE OPÇÕES");
		lblMenuDeOpes.setBounds(190, 30, 187, 14);
		contentPanel.add(lblMenuDeOpes);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}
}
