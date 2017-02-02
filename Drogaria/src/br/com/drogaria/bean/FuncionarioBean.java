package br.com.drogaria.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.drogaria.dao.FuncionarioDAO;

import br.com.drogaria.dominio.Funcionario;
import br.com.drogaria.util.JSFUtil;

@ManagedBean(name = "MBFuncionario")
@ViewScoped
public class FuncionarioBean {
	private ArrayList<Funcionario> itens;
	private ArrayList<Funcionario> itensFiltrados;
	private ArrayList<Funcionario> comboFuncionario;
	public ArrayList<Funcionario> getComboFuncionario() {
		return comboFuncionario;
	}

	public void setComboFuncionario(ArrayList<Funcionario> comboFuncionario) {
		this.comboFuncionario = comboFuncionario;
	}

	private Funcionario funcionario;

	public ArrayList<Funcionario> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Funcionario> itens) {
		this.itens = itens;
	}

	public ArrayList<Funcionario> getItensFiltrados() {
		return itensFiltrados;
	}

	public void setItensFiltrados(ArrayList<Funcionario> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public void carregarListagem() {
		try {
			FuncionarioDAO dao = new FuncionarioDAO();
			itens = dao.listar();
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.adicionarMessagemErro(e.getMessage());
		}
	}

	public void prepararNovo() {
		funcionario = new Funcionario();
	}

	public void novo() {
		try {
			FuncionarioDAO dao = new FuncionarioDAO();
			dao.salvar(funcionario);
			itens = dao.listar();
			JSFUtil.adicionarMessagemSucesso("Funcionario Cadastrado com Sucesso.");
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.adicionarMessagemErro(e.getMessage());
		}
	}
	
	@PostConstruct
	public void prepararPesquisa() {
		try {
			FuncionarioDAO dao = new FuncionarioDAO();
			itens = dao.listar();
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.adicionarMessagemErro(e.getMessage());
		}
	}

	public void excluir() {
		try {
			FuncionarioDAO dao = new FuncionarioDAO();
			dao.excluir(funcionario);

			itens = dao.listar();
			JSFUtil.adicionarMessagemSucesso("Funcionario Removido com Sucesso.");
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.adicionarMessagemErro(e.getMessage());
		}
	}

	public void editar() {
		try {
			FuncionarioDAO dao = new FuncionarioDAO();
			dao.editar(funcionario);
			itens = dao.listar();
			JSFUtil.adicionarMessagemSucesso("Funcionario Alterado com Sucesso.");
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.adicionarMessagemErro(e.getMessage());
		}
	}
}