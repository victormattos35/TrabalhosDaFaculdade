package br.com.mercado.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.mercado.factory.Conexao;
import br.com.mercado.model.Fornecedor;
import br.com.mercado.model.Produto;

public class ProdutoDAO {
	public void salvar(Produto p) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO produto ");
		sql.append("(descricao, marca, departamento, referencia, valor_custo, valor_venda, fornecedor_idfornecedor) ");
		sql.append("VALUES (?, ?, ?, ?, ?, ?, ?) ");

		Connection conexao = Conexao.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		comando.setString(1, p.getDescricao());
		comando.setString(2, p.getMarca());
		comando.setString(3, p.getDepartamento());
		comando.setString(4, p.getReferencia());
		comando.setDouble(5, p.getValor_custo());
		comando.setDouble(6, p.getValor_venda());
		comando.setLong(7, p.getFornecedor().getIdfornecedor());

		comando.executeUpdate();
	}

	public ArrayList<Produto> listar() throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT p.idproduto, p.descricao, p.marca, p.departamento, p.referencia, p.quantidade, p.valor_custo, p.valor_venda, f.idfornecedor, f.nome ");
		sql.append("FROM produto p ");
		sql.append("inner join fornecedor f on f.idfornecedor = p.fornecedor_idfornecedor ");

		Connection conexao = Conexao.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		ResultSet resultado = comando.executeQuery();

		ArrayList<Produto> itens = new ArrayList<Produto>();

		while (resultado.next()) {
			Fornecedor f = new Fornecedor();
			f.setIdfornecedor(resultado.getLong("f.idfornecedor"));
			f.setNome(resultado.getString("f.nome"));

			Produto p = new Produto();
			p.setIdproduto(resultado.getLong("p.idproduto"));
			p.setDescricao(resultado.getString("p.descricao"));
			p.setMarca(resultado.getString("p.marca"));
			p.setDepartamento(resultado.getString("p.departamento"));
			p.setReferencia(resultado.getString("p.referencia"));
			p.setQuantidade(resultado.getLong("p.quantidade"));
			p.setValor_custo(resultado.getDouble("p.valor_custo"));
			p.setValor_venda(resultado.getDouble("p.valor_venda"));
			p.setFornecedor(f);

			itens.add(p);
		}

		return itens;

	}

	public void excluir(Produto p) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM produto ");
		sql.append("WHERE idproduto = ? ");

		Connection conexao = Conexao.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		comando.setLong(1, p.getIdproduto());

		comando.executeUpdate();
	}

	public void editar(Produto p) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE produto ");
		sql.append("SET descricao = ?, marca = ?, departamento = ?, referencia = ?, quantidade = ?, valor_custo = ?, valor_venda = ?, fornecedor_idfornecedor = ? ");
		sql.append("WHERE idproduto = ? ");

		Connection conexao = Conexao.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		comando.setString(1, p.getDescricao());
		comando.setString(2, p.getMarca());
		comando.setString(3, p.getDepartamento());
		comando.setString(4, p.getReferencia());
		comando.setLong(5, p.getQuantidade());
		comando.setDouble(6, p.getValor_custo());
		comando.setDouble(7, p.getValor_venda());
		comando.setLong(8, p.getFornecedor().getIdfornecedor());
		comando.setLong(9, p.getIdproduto());

		comando.executeUpdate();
	}
}
