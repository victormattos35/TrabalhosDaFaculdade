package br.com.drogaria.test;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogaria.dao.ClienteDAO;
import br.com.drogaria.dao.FiliaisDAO;
import br.com.drogaria.dao.FuncionarioDAO;
import br.com.drogaria.dao.VendaDAO;
import br.com.drogaria.dominio.Cliente;
import br.com.drogaria.dominio.Filiais;
import br.com.drogaria.dominio.Funcionario;
import br.com.drogaria.dominio.Venda;


public class FuncionarioDAOTeste {

	@Test
	public void salvar() throws SQLException {
		Venda ven = new Venda();
		ven.setDia("00/00/0000");
		ven.setValortotal(199D);
		Cliente cliente = new Cliente();
		cliente.setIdcliente(32L);
		ven.setCliente(cliente);
		VendaDAO vendao = new VendaDAO();
		vendao.salvar(ven);
	}

	@Test
	@Ignore
	public void listar() throws SQLException {
		FuncionarioDAO dao = new FuncionarioDAO();
		ArrayList<Funcionario> lista = dao.listar();

		for (Funcionario f : lista) {
			System.out.println("Código: " + f.getCodigo());
			System.out.println("Nome: " + f.getNome());
			System.out.println("Cpf: " + f.getCpf());
			System.out.println("Quantidade: " + f.getFuncao());
			}
	}

	@Test
	@Ignore
	public void excluir() throws SQLException {
		Funcionario f = new Funcionario();
		f.setCodigo(2L);
		FuncionarioDAO dao = new FuncionarioDAO();
		dao.excluir(f);
	}

	@Test
	@Ignore
	public void editar() throws SQLException {
		Filiais f = new Filiais();
		f.setIdfiliais(6L);
		f.setNome("KKKKKKKK");
		f.setEndereco("5265");
		f.setBairro("111111");
		f.setNumero(2L);
		f.setEstado("SP");
		f.setTelefone("(18)3324-5401");
		f.setCidade("Assis");
		FiliaisDAO dao = new FiliaisDAO();
		dao.editar(f);
	}
}
