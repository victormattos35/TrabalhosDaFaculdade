package br.com.drogaria.bean;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.drogaria.dominio.Funcionario;
import br.com.drogaria.dominio.Item;
import br.com.drogaria.dominio.Produto;
import br.com.drogaria.dominio.Venda;

@ManagedBean(name = "MBVenda")
@ViewScoped
public class VendaBean {
	private ArrayList<Produto> itens;
	private ArrayList<Produto> itensFiltrados;
	private Venda vendaCadastro;
	private ArrayList<Item> listaItem;
	private ArrayList<Funcionario> comboFuncionario;

	public ArrayList<Funcionario> getComboFuncionario() {
		return comboFuncionario;
	}

	public void setComboFuncionario(ArrayList<Funcionario> comboFuncionario) {
		this.comboFuncionario = comboFuncionario;
	}

	public Venda getVendaCadastro() {
		return vendaCadastro;
	}

	public void setVendaCadastro(Venda vendaCadastro) {
		this.vendaCadastro = vendaCadastro;
	}

	public ArrayList<Item> getListaItem() {
		if (listaItem == null) {
			listaItem = new ArrayList<Item>();
		}
		return listaItem;
	}

	public void setListaItem(ArrayList<Item> listaItem) {
		this.listaItem = listaItem;
	}

	public ArrayList<Produto> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Produto> itens) {
		this.itens = itens;
	}

	public ArrayList<Produto> getItensFiltrados() {
		return itensFiltrados;
	}

	public void setItensFiltrados(ArrayList<Produto> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}

	/*public void carregarProdutos() {
		try {
			ProdutoDAO dao = new ProdutoDAO();
			itens = dao.listar();
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.adicionarMessagemErro(e.getMessage());
		}
	}

	public void adicionar(Produto produto) {
		//int posEncontrada = -2;
		Item item = new Item();

		/*for (int pos = 0; pos < listaItem.size(); pos++) {
			Item ItemTemp = listaItem.get(pos);

			if (ItemTemp.getProduto().equals(item.getProduto())) {
				posEncontrada = pos;

			}
		}

		item.setProduto(produto);

		//if (posEncontrada < 0) {
			item.setQuantidade(1);
			item.setValor_parcial(produto.getPreco());
			listaItem.add(item);
		} else {
			Item ItemTemp = listaItem.get(posEncontrada);
			item.setQuantidade(ItemTemp.getQuantidade() + 1);
			item.setValor_parcial(produto.getPreco() * item.getQuantidade());
			listaItem.set(posEncontrada, item);
		}

		vendaCadastro.setValortotal(vendaCadastro.getValortotal() + produto.getPreco());
	}

	public void remover(Item item) {
		int posEncontrada = -1;

		for (int pos = 0; pos < listaItem.size() && posEncontrada < 0; pos++) {
			Item ItemTemp = listaItem.get(pos);

			if (ItemTemp.getProduto().equals(item.getProduto())) {
				posEncontrada = pos;

			}
		}
		if (posEncontrada > -1) {
			listaItem.remove(posEncontrada);
			vendaCadastro.setValor(vendaCadastro.getValor()
					- item.getValor_parcial());
		}
	}

	public void carregarDadosVenda() {
		vendaCadastro.setDia(new Date());
	}
		try {
			FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
			Funcionario f1 = new Funcionario();
			f1.setCodigo(4L);
			Funcionario funcionario = funcionarioDAO.buscarPorCodigo(f1);
			vendaCadastro.setFuncionario(funcionario);
		} catch (SQLException e) {
			JSFUtil.adicionarMessagemErro(e.getMessage());
			e.printStackTrace();
		}


	public void prepararFuncionario() {
		
	}
	
	public void salvar() {
		try {
			VendaDAO vendaDAO = new VendaDAO();
			vendaDAO.salvar(vendaCadastro);
			
			FuncionarioDAO dao = new FuncionarioDAO();
			comboFuncionario = dao.listar();

			vendaCadastro = new Venda();
			vendaCadastro.setValor(new Double("0.00"));
			
			listaItem = new ArrayList<Item>();
			JSFUtil.adicionarMessagemSucesso("Venda Salva com Sucesso");
		} catch (SQLException e) {
			JSFUtil.adicionarMessagemErro(e.getMessage());
		}
	}*/
}
