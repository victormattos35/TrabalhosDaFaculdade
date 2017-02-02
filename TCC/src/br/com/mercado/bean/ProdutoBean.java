package br.com.mercado.bean;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.mercado.DAO.FornecedorDAO;
import br.com.mercado.DAO.ProdutoDAO;
import br.com.mercado.model.Fornecedor;
import br.com.mercado.model.Produto;
import br.com.mercado.util.JSFUtil;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@ManagedBean(name = "MBProduto")
@ViewScoped
public class ProdutoBean {
	private Produto produto = new Produto();
	private ArrayList<Produto> itens;
	private ArrayList<Produto> itensFiltrados;
	private String path; // Caminho base

	private String pathToReportPackage; // Caminho para o package onde estão
										// armazenados os relatorios Jarper

	private ArrayList<Fornecedor> comboFornecedor;

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public ArrayList<Fornecedor> getComboFornecedor() {
		return comboFornecedor;
	}

	public void setComboFornecedor(ArrayList<Fornecedor> comboFornecedor) {
		this.comboFornecedor = comboFornecedor;
	}

	public ArrayList<Produto> getItensFiltrados() {
		return itensFiltrados;
	}

	public void setItensFiltrados(ArrayList<Produto> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}

	public ArrayList<Produto> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Produto> itens) {
		this.itens = itens;
	}

	public void prepararNovo() {
		try {
			FornecedorDAO dao1 = new FornecedorDAO();
			comboFornecedor = dao1.listar();
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.adicionarMessagemErro(e.getMessage());
		}

	}

	public void relatorio() throws Exception {

		// Recupera os caminhos para que a classe possa encontrar os relatórios

		this.path = this.getClass().getClassLoader().getResource("").getPath();
		this.pathToReportPackage = this.path + "br/com/mercado/relatorio/";
		System.out.println(path);
		imprimir();

	}

	@PostConstruct
	public void prepararPesquisa() {
		try {
			ProdutoDAO dao = new ProdutoDAO();
			itens = dao.listar();
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.adicionarMessagemErro(e.getMessage());
		}
	}

	public void novo() {
		try {
			ProdutoDAO dao = new ProdutoDAO();
			dao.salvar(produto);
			itens = dao.listar();
			JSFUtil.adicionarMessagemSucesso("Produto Cadastrado com Sucesso.");
			produto = new Produto();
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.adicionarMessagemErro(e.getMessage());
		}
	}

	public void excluir() {
		try {
			ProdutoDAO dao = new ProdutoDAO();
			dao.excluir(produto);
			itens = dao.listar();
			JSFUtil.adicionarMessagemSucesso("Produto Removido com Sucesso.");
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.adicionarMessagemErro(e.getMessage());
		}
	}

	public void editar() {
		try {
			ProdutoDAO dao = new ProdutoDAO();
			dao.editar(produto);
			itens = dao.listar();
			JSFUtil.adicionarMessagemSucesso("Produto Alterado com Sucesso.");
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.adicionarMessagemErro(e.getMessage());
		}
	}

	// Imprime/gera uma lista de Clientes
	public void imprimir() throws Exception {
		ProdutoDAO dao = new ProdutoDAO();
		List<Produto> produto = new ArrayList<Produto>();
		produto = dao.listar();
		JasperReport report = JasperCompileManager.compileReport(this
				.getPathToReportPackage() + "produto1.jrxml");

		JasperPrint print = JasperFillManager.fillReport(report, null,
				new JRBeanCollectionDataSource(produto));

		JasperExportManager.exportReportToPdfFile(print,
				"c:/Relatorio_de_Clientes.pdf");
	}

	public String getPathToReportPackage() {
		return this.pathToReportPackage;
	}

	public String getPath() {
		return this.path;
	}
}
