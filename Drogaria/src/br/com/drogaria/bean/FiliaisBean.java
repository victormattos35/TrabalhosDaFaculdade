package br.com.drogaria.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.drogaria.dao.FiliaisDAO;
import br.com.drogaria.dominio.Filiais;
import br.com.drogaria.util.JSFUtil;

@ManagedBean(name="MBFilial")
@ViewScoped
public class FiliaisBean {
	private Filiais filiais;
	private ArrayList<Filiais> itens;
	private ArrayList<Filiais> itensFiltrados;
	
	
	public Filiais getFiliais() {
		return filiais;
	}

	public void setFiliais(Filiais filiais) {
		this.filiais = filiais;
	}

	public ArrayList<Filiais> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Filiais> itens) {
		this.itens = itens;
	}

	public ArrayList<Filiais> getItensFiltrados() {
		return itensFiltrados;
	}

	public void setItensFiltrados(ArrayList<Filiais> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}

	@PostConstruct
	public void prepararPesquisa() {
		try {
			FiliaisDAO dao = new FiliaisDAO();
			itens = dao.listar();
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.adicionarMessagemErro(e.getMessage());
		}
	}

	public void prepararNovo() {
		filiais = new Filiais();
	}

	public void novo() {
		try {
			FiliaisDAO dao = new FiliaisDAO();
			dao.salvar(filiais);
			itens = dao.listar();

			JSFUtil.adicionarMessagemSucesso("Filial salvo com sucesso.");
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.adicionarMessagemErro(e.getMessage());
		}
	}

	public void excluir() {

		try {
			FiliaisDAO dao = new FiliaisDAO();
			dao.excluir(filiais);
			itens = dao.listar();

			JSFUtil.adicionarMessagemSucesso("Filial excluido com sucesso.");
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.adicionarMessagemErro(e.getMessage());
		}

	}


	public void editar() {
		try {
			FiliaisDAO dao = new FiliaisDAO();
			dao.editar(filiais);
			itens = dao.listar();
			
			JSFUtil.adicionarMessagemSucesso("Filial alterado com sucesso.");
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.adicionarMessagemErro(e.getMessage());
		}
	}

}
