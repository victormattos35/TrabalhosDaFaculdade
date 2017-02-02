package br.com.drogaria.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.drogaria.dao.ClienteDAO;
import br.com.drogaria.dominio.Cliente;
import br.com.drogaria.util.JSFUtil;

@ManagedBean(name="MBCliente")
@ViewScoped
public class ClienteBean {
	private Cliente cliente;
	private ArrayList<Cliente> itens;
	private ArrayList<Cliente> itensFiltrados;
	
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

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

	public void prepararNovo() {
		cliente = new Cliente();
	}

	public void novo() {
		try {
			ClienteDAO dao = new ClienteDAO();
			dao.salvar(cliente);
			itens = dao.listar();
			JSFUtil.adicionarMessagemSucesso("Cliente salvo com sucesso.");
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


