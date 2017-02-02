package br.com.drogaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.drogaria.dominio.Funcionario;
import br.com.drogaria.factory.ConexaoFactory;

public class FuncionarioDAO {
	public void salvar(Funcionario f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO funcionario ");
		sql.append("(nome, cpf, senha, funcao) ");
		sql.append("VALUES (?, ?, ?, ?) ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		comando.setString(1, f.getNome());
		comando.setString(2, f.getCpf());
		comando.setString(3, f.getSenha());
		comando.setString(4, f.getFuncao());

		comando.executeUpdate();
	}

	public ArrayList<Funcionario> listar() throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT codigo, nome, cpf, funcao ");
		sql.append("FROM funcionario ");
		sql.append("ORDER BY nome ASC ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		ResultSet resultado = comando.executeQuery();

		ArrayList<Funcionario> itens = new ArrayList<Funcionario>();

		while (resultado.next()){
			Funcionario f = new Funcionario();
			f.setCodigo(resultado.getLong("codigo"));
			f.setNome(resultado.getString("nome"));
			f.setCpf(resultado.getString("cpf"));
			f.setFuncao(resultado.getString("funcao"));

			itens.add(f);
		}

		return itens;

	}

	public void excluir(Funcionario f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM funcionario ");
		sql.append("WHERE codigo = ? ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		comando.setLong(1, f.getCodigo());

		comando.executeUpdate();
	}

	public void editar(Funcionario f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE funcionario ");
		sql.append("SET nome = ?, cpf = ?, senha = ?, funcao = ? ");
		sql.append("WHERE codigo = ? ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		comando.setString(1, f.getNome());
		comando.setString(2, f.getCpf());
		comando.setString(3, f.getSenha());
		comando.setString(4, f.getFuncao());
		comando.setLong(5, f.getCodigo());

		comando.executeUpdate();
	}
	
	public Funcionario buscarPorCodigo(Funcionario f) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT codigo, nome, senha, funcao ");
		sql.append("FROM funcionario ");
		sql.append("WHERE codigo = ? ");
		
		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setLong(1, f.getCodigo());
		
		ResultSet resultado = comando.executeQuery();
		
		Funcionario retorno = null;
		
		if(resultado.next()){
			retorno = new Funcionario();
			retorno.setCodigo(resultado.getLong("codigo"));
			retorno.setNome(resultado.getString("nome"));
			retorno.setSenha(resultado.getString("senha"));
			retorno.setFuncao(resultado.getString("funcao"));
		}
		
		return retorno;
		
	}
}