package br.com.mercado.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.mercado.factory.Conexao;
import br.com.mercado.model.Produto;
import br.com.mercado.model.Saida;
import br.com.mercado.util.Datas;

public class SaidaDAO {
	public void salvar(Saida s) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO saidaproduto ");
		sql.append("(dia, observacao, produto_idproduto) ");
		sql.append("VALUES (?, ?, ?) ");

		Connection conexao = Conexao.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		Date dia = Datas.javaDateParaSqlDate(s.getDia());

		comando.setDate(1, dia);
		comando.setString(2, s.getObservacao());
		comando.setLong(3, s.getProduto().getIdproduto());

		comando.executeUpdate();
	}

	public ArrayList<Saida> listar() throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT s.idsaidaproduto, s.dia, s.observacao, p.idproduto, p.descricao ");
		sql.append("FROM saidaproduto s ");
		sql.append("inner join produto p on p.idproduto = s.produto_idproduto ");

		Connection conexao = Conexao.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		ResultSet resultado = comando.executeQuery();

		ArrayList<Saida> itens = new ArrayList<Saida>();

		while (resultado.next()) {
			Produto p = new Produto();
			p.setIdproduto(resultado.getLong("p.idproduto"));
			p.setDescricao(resultado.getString("p.descricao"));

			Saida s = new Saida();
			s.setIdsaidaproduto(resultado.getLong("s.idsaidaproduto"));
			s.setDia(Datas.sqlDateParaJavaDate(resultado.getDate("s.dia")));
			s.setObservacao(resultado.getString("s.observacao"));
			s.setProduto(p);

			itens.add(s);
		}

		return itens;

	}

	public void excluir(Saida s) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM saidaproduto ");
		sql.append("WHERE idsaidaproduto = ? ");

		Connection conexao = Conexao.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		comando.setLong(1, s.getIdsaidaproduto());

		comando.executeUpdate();
	}

	public void editar(Saida s) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE saidaproduto ");
		sql.append("SET dia = ?, observacao = ?, produto_idproduto = ? ");
		sql.append("WHERE idsaidaproduto = ? ");

		Connection conexao = Conexao.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		Date dia = Datas.javaDateParaSqlDate(s.getDia());

		comando.setDate(1, dia);
		comando.setString(2, s.getObservacao());
		comando.setLong(3, s.getProduto().getIdproduto());
		comando.setLong(4, s.getIdsaidaproduto());

		comando.executeUpdate();
	}
}
