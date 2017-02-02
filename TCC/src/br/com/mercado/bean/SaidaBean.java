package br.com.mercado.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.mercado.DAO.ProdutoDAO;
import br.com.mercado.DAO.SaidaDAO;
import br.com.mercado.model.Produto;
import br.com.mercado.model.Saida;
import br.com.mercado.util.JSFUtil;

@ManagedBean(name = "MBSaida")
@ViewScoped
public class SaidaBean {
	private Saida saida = new Saida();
	private ArrayList<Saida> itens;
	private ArrayList<Saida> itensFiltrados;
	private ArrayList<Produto> comboProduto;

	public Saida getSaida() {
		return saida;
	}

	public void setSaida(Saida saida) {
		this.saida = saida;
	}

	public ArrayList<Saida> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Saida> itens) {
		this.itens = itens;
	}

	public ArrayList<Saida> getItensFiltrados() {
		return itensFiltrados;
	}

	public void setItensFiltrados(ArrayList<Saida> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}

	public ArrayList<Produto> getComboProduto() {
		return comboProduto;
	}

	public void setComboProduto(ArrayList<Produto> comboProduto) {
		this.comboProduto = comboProduto;
	}

	public void prepararNovo() {
		try {
			ProdutoDAO dao = new ProdutoDAO();
			comboProduto = dao.listar();
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.adicionarMessagemErro(e.getMessage());
		}

	}

	@PostConstruct
	public void prepararPesquisa() {
		try {
			SaidaDAO dao = new SaidaDAO();
			itens = dao.listar();
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.adicionarMessagemErro(e.getMessage());
		}
	}

	public void novo() {
		try {
			SaidaDAO dao = new SaidaDAO();
			dao.salvar(saida);
			itens = dao.listar();
			JSFUtil.adicionarMessagemSucesso("Produto Adicionado com Sucesso.");
			saida = new Saida();
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.adicionarMessagemErro(e.getMessage());
		}
	}

	public void excluir() {
		try {
			SaidaDAO dao = new SaidaDAO();
			dao.excluir(saida);
			itens = dao.listar();
			JSFUtil.adicionarMessagemSucesso("Produto Removido com Sucesso.");
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.adicionarMessagemErro(e.getMessage());
		}
	}

	public void editar() {
		try {
			SaidaDAO dao = new SaidaDAO();
			dao.editar(saida);
			itens = dao.listar();
			JSFUtil.adicionarMessagemSucesso("Produto Alterado com Sucesso.");
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.adicionarMessagemErro(e.getMessage());
		}
	}
}
