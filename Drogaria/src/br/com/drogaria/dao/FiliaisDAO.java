package br.com.drogaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.drogaria.dominio.Filiais;
import br.com.drogaria.factory.ConexaoFactory;

public class FiliaisDAO {

	public void salvar(Filiais f) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO filiais ");
		sql.append("(nome, endereco, bairro, numero, estado, telefone, cidade) ");
		sql.append("VALUES (?, ?, ?, ?, ?, ?, ?) ");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, f.getNome());
		comando.setString(2, f.getEndereco());
		comando.setString(3, f.getBairro());
		comando.setLong(4, f.getNumero());
		comando.setString(5, f.getEstado());
		comando.setString(6, f.getTelefone());
		comando.setString(7, f.getCidade());
		
		comando.executeUpdate();
		
	}
	
	public void excluir(Filiais f) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM filiais ");
		sql.append("WHERE idfiliais = ? ");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setLong(1, f.getIdfiliais());

		
		comando.executeUpdate();
	}
	
	public void editar(Filiais f) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE filiais ");
		sql.append("SET nome = ?, endereco = ?, bairro = ? , numero = ? , estado = ?, telefone = ?, cidade = ? ");
		sql.append("WHERE idfiliais = ? ");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, f.getNome());
		comando.setString(2, f.getEndereco());
		comando.setString(3, f.getBairro());
		comando.setLong(4, f.getNumero());
		comando.setString(5, f.getEstado());
		comando.setString(6, f.getTelefone());
		comando.setString(7, f.getCidade());
		comando.setLong(8, f.getIdfiliais());
		
		comando.executeUpdate();
	}

	public ArrayList<Filiais> listar() throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT idfiliais, nome, endereco, bairro, numero, estado, telefone, cidade ");
		sql.append("FROM filiais ");
		sql.append("ORDER BY nome ASC ");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		
		ResultSet resultado = comando.executeQuery();
		
		ArrayList<Filiais> lista = new ArrayList<Filiais>();
		
		while(resultado.next()){
			Filiais f = new Filiais();
			f.setIdfiliais(resultado.getLong("idfiliais"));
			f.setNome(resultado.getString("nome"));
			f.setEndereco(resultado.getString("endereco"));
			f.setBairro(resultado.getString("bairro"));
			f.setNumero(resultado.getLong("numero"));
			f.setEstado(resultado.getString("estado"));
			f.setTelefone(resultado.getString("telefone"));
			f.setCidade(resultado.getString("cidade"));
			lista.add(f);
		}
		
		
		return lista;
	}

}
