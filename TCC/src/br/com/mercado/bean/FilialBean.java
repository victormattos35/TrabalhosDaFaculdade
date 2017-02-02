package br.com.mercado.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.mercado.DAO.FilialDAO;
import br.com.mercado.model.Filial;
import br.com.mercado.util.JSFUtil;

@ManagedBean(name="MBFilial")
@ViewScoped
public class FilialBean {
	private Filial filial = new Filial();
	private ArrayList<Filial> itens;
	private ArrayList<Filial> itensFiltrados;

	public Filial getFilial() {
		return filial;
	}

	public void setFilial(Filial filial) {
		this.filial = filial;
	}

	public ArrayList<Filial> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Filial> itens) {
		this.itens = itens;
	}

	public ArrayList<Filial> getItensFiltrados() {
		return itensFiltrados;
	}

	public void setItensFiltrados(ArrayList<Filial> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}

	@PostConstruct
	public void prepararPesquisa() {
		try {
			FilialDAO dao = new FilialDAO();
			itens = dao.listar();
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.adicionarMessagemErro(e.getMessage());
		}
	}

	public void novo() {
		try {
			FilialDAO dao = new FilialDAO();
			dao.salvar(filial);
			JSFUtil.adicionarMessagemSucesso("Filial salvo com sucesso.");
			filial = new Filial();
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.adicionarMessagemErro(e.getMessage());
		}
	}

	public void excluir() {

		try {
			FilialDAO dao = new FilialDAO();
			dao.excluir(filial);
			itens = dao.listar();
			JSFUtil.adicionarMessagemSucesso("Filial excluido com sucesso.");
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.adicionarMessagemErro(e.getMessage());
		}

	}

	public void editar() {
		try {
			FilialDAO dao = new FilialDAO();
			dao.editar(filial);
			itens = dao.listar();
			JSFUtil.adicionarMessagemSucesso("Filial alterado com sucesso.");
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.adicionarMessagemErro(e.getMessage());
		}
	}
}
