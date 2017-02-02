package br.com.drogaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.drogaria.dominio.Cliente;
import br.com.drogaria.factory.ConexaoFactory;

public class ClienteDAO {

	public void salvar(Cliente c) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO cliente ");
		sql.append("(nome, telefone, celular, endereco, numero, bairro, cidade, estado) ");
		sql.append("VALUES (?, ?, ?, ?, ?, ?, ?, ?) ");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, c.getNome());
		comando.setString(2, c.getTelefone());
		comando.setString(3, c.getCelular());
		comando.setString(4, c.getEndereco());
		comando.setLong(5, c.getNumero());
		comando.setString(6, c.getBairro());
		comando.setString(7, c.getCidade());
		comando.setString(8, c.getEstado());
	
		comando.executeUpdate();
		
	}
	
	public void excluir(Cliente c) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM cliente ");
		sql.append("WHERE idcliente = ? ");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setLong(1, c.getIdcliente());

		
		comando.executeUpdate();
	}
	
	public void editar(Cliente c) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE cliente ");
		sql.append("SET nome = ?, telefone = ?, celular = ?, endereco = ?, numero = ?, bairro = ?, cidade = ?, estado = ? ");
		sql.append("WHERE idcliente = ? ");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, c.getNome());
		comando.setString(2, c.getTelefone());
		comando.setString(3, c.getCelular());
		comando.setString(4, c.getEndereco());
		comando.setLong(5, c.getNumero());
		comando.setString(6, c.getBairro());
		comando.setString(7, c.getCidade());
		comando.setString(8, c.getEstado());
		comando.setLong(9, c.getIdcliente());
		
		comando.executeUpdate();
	}

	public ArrayList<Cliente> listar() throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT idcliente, nome, telefone, celular, endereco, numero, bairro, cidade, estado ");
		sql.append("FROM cliente ");
		sql.append("ORDER BY nome ASC ");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		
		ResultSet resultado = comando.executeQuery();
		
		ArrayList<Cliente> lista = new ArrayList<Cliente>();
		
		while(resultado.next()){
			Cliente c = new Cliente();
			c.setIdcliente(resultado.getLong("idcliente"));
			c.setNome(resultado.getString("nome"));
			c.setTelefone(resultado.getString("telefone"));
			c.setCelular(resultado.getString("celular"));
			c.setEndereco(resultado.getString("endereco"));
			c.setNumero(resultado.getLong("numero"));
			c.setBairro(resultado.getString("bairro"));
			c.setCidade(resultado.getString("cidade"));
			c.setEstado(resultado.getString("estado"));
			lista.add(c);
		}
		
		return lista;
	}

}
