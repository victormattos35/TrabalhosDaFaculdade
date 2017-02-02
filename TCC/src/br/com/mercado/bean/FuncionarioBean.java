package br.com.mercado.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.mercado.DAO.FuncionarioDAO;
import br.com.mercado.model.Funcionario;
import br.com.mercado.util.JSFUtil;

@ManagedBean(name ="MBFuncionario")
@ViewScoped
public class FuncionarioBean {
	private Funcionario funcionario = new Funcionario();
	private ArrayList<Funcionario> itens;
	private ArrayList<Funcionario> itensFiltrados;
	
	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

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

	public void novo() {
		try {
			FuncionarioDAO dao = new FuncionarioDAO();
			dao.salvar(funcionario);
			JSFUtil.adicionarMessagemSucesso("Funcionário salvo com sucesso.");
			funcionario = new Funcionario();
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

			JSFUtil.adicionarMessagemSucesso("Funcionário excluido com sucesso.");
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
			JSFUtil.adicionarMessagemSucesso("Funcionario alterado com sucesso.");
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.adicionarMessagemErro(e.getMessage());
		}
	}
}
