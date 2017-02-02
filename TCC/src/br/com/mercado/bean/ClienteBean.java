package br.com.mercado.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.mercado.DAO.ClienteDAO;
import br.com.mercado.model.Cliente;
import br.com.mercado.util.JSFUtil;

@ManagedBean(name="MBCliente")
@ViewScoped
public class ClienteBean {
	private Cliente cliente = new Cliente();
	private ArrayList<Cliente> itens;
	private ArrayList<Cliente> itensFiltrados;
	
	public ArrayList<Cliente> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Cliente> itens) {
		this.itens = itens;
	}

	public ArrayList<Cliente> getItensFiltrados() {
		return itensFiltrados;
	}

	public void setItensFiltrados(ArrayList<Cliente> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public void novo() {
		try {
			ClienteDAO dao = new ClienteDAO();
			dao.salvar(cliente);
			JSFUtil.adicionarMessagemSucesso("Cliente salvo com sucesso.");
			cliente = new Cliente();
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.adicionarMessagemErro(e.getMessage());
		}
	}
	
	@PostConstruct
	public void prepararPesquisa() {
		try {
			ClienteDAO dao = new ClienteDAO();
			itens = dao.listar();
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.adicionarMessagemErro(e.getMessage());
		}
	}
	
	public void excluir() {

		try {
			ClienteDAO dao = new ClienteDAO();
			dao.excluir(cliente);
			itens = dao.listar();

			JSFUtil.adicionarMessagemSucesso("Cliente excluido com sucesso.");
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.adicionarMessagemErro(e.getMessage());
		}

	}


	public void editar() {
		try {
			ClienteDAO dao = new ClienteDAO();
			dao.editar(cliente);
			itens = dao.listar();
			
			JSFUtil.adicionarMessagemSucesso("Cliente alterado com sucesso.");
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.adicionarMessagemErro(e.getMessage());
		}
	}
}
