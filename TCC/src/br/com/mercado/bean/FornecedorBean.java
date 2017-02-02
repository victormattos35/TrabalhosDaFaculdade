package br.com.mercado.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.mercado.DAO.FornecedorDAO;
import br.com.mercado.model.Fornecedor;
import br.com.mercado.util.JSFUtil;

@ManagedBean(name = "MBFornecedor")
@ViewScoped
public class FornecedorBean {
	private Fornecedor fornecedor = new Fornecedor();
	private ArrayList<Fornecedor> itens;
	private ArrayList<Fornecedor> itensFiltrados;

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public ArrayList<Fornecedor> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Fornecedor> itens) {
		this.itens = itens;
	}

	public ArrayList<Fornecedor> getItensFiltrados() {
		return itensFiltrados;
	}

	public void setItensFiltrados(ArrayList<Fornecedor> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}

	public void novo() {
		try {
			FornecedorDAO dao = new FornecedorDAO();
			dao.salvar(fornecedor);
			JSFUtil.adicionarMessagemSucesso("Fornecedor salvo com sucesso.");
			fornecedor = new Fornecedor();
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.adicionarMessagemErro(e.getMessage());
		}
	}

	@PostConstruct
	public void prepararPesquisa() {
		try {
			FornecedorDAO dao = new FornecedorDAO();
			itens = dao.listar();
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.adicionarMessagemErro(e.getMessage());
		}
	}

	public void excluir() {

		try {
			FornecedorDAO dao = new FornecedorDAO();
			dao.excluir(fornecedor);
			itens = dao.listar();

			JSFUtil.adicionarMessagemSucesso("Fornecedor excluido com sucesso.");
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.adicionarMessagemErro(e.getMessage());
		}

	}

	public void editar() {
		try {
			FornecedorDAO dao = new FornecedorDAO();
			dao.editar(fornecedor);
			itens = dao.listar();
			JSFUtil.adicionarMessagemSucesso("Fornecedor alterado com sucesso.");
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.adicionarMessagemErro(e.getMessage());
		}
	}
}
