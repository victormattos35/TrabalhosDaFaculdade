package br.com.mercado.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.mercado.factory.Conexao;
import br.com.mercado.model.Filial;

public class FilialDAO {

	public void salvar(Filial f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO filial ");
		sql.append("(nome, rua, numero, bairro, cidade, estado, telefone, email, fax) ");
		sql.append("VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) ");

		Connection conexao = Conexao.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, f.getNome());
		comando.setString(2, f.getRua());
		comando.setLong(3, f.getNumero());
		comando.setString(4, f.getBairro());
		comando.setString(5, f.getCidade());
		comando.setString(6, f.getEstado());
		comando.setString(7, f.getTelefone());
		comando.setString(8, f.getEmail());
		comando.setString(9, f.getFax());

		comando.executeUpdate();

	}

	public void excluir(Filial f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM filial ");
		sql.append("WHERE idfilial = ? ");

		Connection conexao = Conexao.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setLong(1, f.getIdfilial());
		comando.executeUpdate();
	}

	public void editar(Filial f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE filial ");
		sql.append("SET nome = ?, rua = ?, numero = ?, bairro = ?, cidade = ?, estado = ?, telefone = ?, email = ?, fax = ? ");
		sql.append("WHERE idfilial = ? ");

		Connection conexao = Conexao.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, f.getNome());
		comando.setString(2, f.getRua());
		comando.setLong(3, f.getNumero());
		comando.setString(4, f.getBairro());
		comando.setString(5, f.getCidade());
		comando.setString(6, f.getEstado());
		comando.setString(7, f.getTelefone());
		comando.setString(8, f.getEmail());
		comando.setString(9, f.getFax());
		comando.setLong(10, f.getIdfilial());

		comando.executeUpdate();
	}

	public ArrayList<Filial> listar() throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT idfilial, nome, rua, numero, bairro, cidade, estado, telefone, email, fax ");
		sql.append("FROM filial ");
		sql.append("ORDER BY nome ASC ");

		Connection conexao = Conexao.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		ResultSet resultado = comando.executeQuery();

		ArrayList<Filial> lista = new ArrayList<Filial>();

		while (resultado.next()) {
			Filial f = new Filial();
			f.setIdfilial(resultado.getLong("idfilial"));
			f.setNome(resultado.getString("nome"));
			f.setRua(resultado.getString("rua"));
			f.setNumero(resultado.getLong("numero"));
			f.setBairro(resultado.getString("bairro"));
			f.setCidade(resultado.getString("cidade"));
			f.setEstado(resultado.getString("estado"));
			f.setTelefone(resultado.getString("telefone"));
			f.setEmail(resultado.getString("email"));
			f.setFax(resultado.getString("fax"));
			lista.add(f);
		}

		return lista;
	}
}