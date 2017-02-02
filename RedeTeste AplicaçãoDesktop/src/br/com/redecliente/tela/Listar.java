package br.com.redecliente.tela;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import br.com.redecliente.client.RedeClient;
import br.com.redecliente.domain.Rede;

import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class Listar extends JFrame {

	private final JPanel contentPanel = new JPanel();
	private List<Rede> rede;
	private JTable table;
	private JScrollPane scrollPane;

	public List<Rede> getRede() {
		return rede;
	}

	public void setRede(List<Rede> rede) {
		this.rede = rede;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Listar dialog = new Listar();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Listar() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		{
			JLabel lblListaDePessoas = new JLabel("Lista de Pessoas Cadastradas");
			lblListaDePessoas.setBounds(113, 9, 187, 14);
			contentPanel.add(lblListaDePessoas);
		}
		{
			JButton btnExcluir = new JButton("Excluir");
			btnExcluir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					excluirPessoa();
				}
			});
			btnExcluir.setBounds(20, 228, 89, 23);
			contentPanel.add(btnExcluir);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(20, 32, 378, 185);
			contentPanel.add(scrollPane);

			table = new JTable();
			scrollPane.setViewportView(table);
		}
		{
			JButton btnAlterar = new JButton("Alterar");
			btnAlterar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					alterarPessoa();
				}
			});
			btnAlterar.setBounds(139, 228, 89, 23);
			contentPanel.add(btnAlterar);
		}
		{
			JButton btnSair = new JButton("Sair");
			btnSair.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnSair.setBounds(275, 228, 89, 23);
			contentPanel.add(btnSair);
		}

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
		mostrarDados();
	}

	private void mostrarDados() {
		try {
			RedeClient redeclient = new RedeClient();
			rede = redeclient.listar();

			DefaultTableModel d = new DefaultTableModel();

			d.addColumn("Codigo");
			d.addColumn("Nome");
			d.addColumn("Idade");
			d.addColumn("Data Insercao");

			for (Rede r : rede) {
				String[] linha = new String[4];
				linha[0] = Long.toString(r.getCodigo());
				linha[1] = r.getNome().toString();
				linha[2] = Long.toString(r.getIdade());
				linha[3] = r.getDataInsercao().toString();
				System.out.println(r.getDataInsercao());
				d.addRow(linha);
			}
			table.setModel(d);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluirPessoa() {
		try {
			int i = table.getSelectedRow();
			if (i >= 0) {
				Rede r = rede.get(i);
				RedeClient redecli = new RedeClient();
				System.out.println(r.getCodigo());
				redecli.deletar(r);
				mostrarDados();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void alterarPessoa() {
		try {
			int i = table.getSelectedRow();
			System.out.println("AQUI");
			if (i >= 0) {
				Rede r = rede.get(i);
				System.out.println(r.getNome());
				Alterar alt = new Alterar(r);
				alt.setVisible(true);
				mostrarDados();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
