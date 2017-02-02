package br.com.drogaria.test;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogaria.dao.ProdutoDAO;
import br.com.drogaria.dominio.Fabricante;
import br.com.drogaria.dominio.Produto;

public class ProdutoDAOTeste {

	@Test
	@Ignore
	public void salvar() throws SQLException {
		Produto p = new Produto();
		p.setDescricao("NOVALGINA COM 10 COMP.");
		p.setPreco(2.45D);
		p.setQuantidade(2);

		Fabricante f = new Fabricante();
		f.setCodigo(24L);

		p.setFabricante(f);

		ProdutoDAO dao = new ProdutoDAO();
		dao.salvar(p);
	}

	@Test
	@Ignore
	public void listar() throws SQLException {
		ProdutoDAO dao = new ProdutoDAO();
		ArrayList<Produto> lista = dao.listar();

		for (Produto p : lista) {
			System.out.println("Código: " + p.getCodigo());
			System.out.println("Descricao: " + p.getDescricao());
			System.out.println("Preço: " + p.getPreco());
			System.out.println("Quantidade: " + p.getQuantidade());
			System.out.println("Fabricante: " + p.getFabricante().getCodigo());
			System.out.println("Descricao Fab: "
					+ p.getFabricante().getDescricao());
			System.out.println("");
		}
	}

	@Test
	public void excluir() throws SQLException {
		Produto p = new Produto();
		p.setCodigo(2L);
		ProdutoDAO dao = new ProdutoDAO();
		dao.excluir(p);
	}

	@Test
	@Ignore
	public void editar() throws SQLException {
		Produto p = new Produto();
		p.setCodigo(2L);
		p.setDescricao("ARROZ CARNE FEIJAO");
		p.setPreco(235D);
		p.setQuantidade(20);
		
		Fabricante f = new Fabricante();
		f.setCodigo(20L);
		
		p.setFabricante(f);
		
		ProdutoDAO dao = new ProdutoDAO();
		dao.editar(p);
	}
}
