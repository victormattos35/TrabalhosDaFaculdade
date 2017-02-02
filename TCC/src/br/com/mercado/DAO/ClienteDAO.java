package br.com.mercado.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.mercado.factory.Conexao;
import br.com.mercado.model.Cliente;

public class ClienteDAO {
	public void salvar(Cliente c) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO cliente ");
		sql.append("(nome, cpf, senha, telefone, celular, email, cep, rua, numero, complemento, bairro, cidade, estado) ");
		sql.append("VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ");
		
		Connection conexao = Conexao.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, c.getNome());
		comando.setString(2, c.getCpf());
		comando.setString(3, c.getSenha());
		comando.setString(4, c.getTelefone());
		comando.setString(5, c.getCelular());
		comando.setString(6, c.getEmail());
		comando.setString(7, c.getCep());
		comando.setString(8, c.getRua());
		comando.setLong(9, c.getNumero());
		comando.setString(10, c.getComplemento());
		comando.setString(11, c.getBairro());
		comando.setString(12, c.getCidade());
		comando.setString(13, c.getEstado());
		
	
		comando.executeUpdate();
		
	}
	
	public void excluir(Cliente c) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM cliente ");
		sql.append("WHERE idcliente = ? ");
		
		Connection conexao = Conexao.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setLong(1, c.getIdcliente());

		
		comando.executeUpdate();
	}
	
	public void editar(Cliente c) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE cliente ");
		sql.append("SET nome = ?, cpf = ?, telefone = ?, celular = ?, email = ?, cep = ?, rua = ?, numero = ?, complemento = ?, bairro = ?, cidade = ?, estado = ?");
		sql.append("WHERE idcliente = ? ");
		
		Connection conexao = Conexao.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, c.getNome());
		comando.setString(2, c.getCpf());
		comando.setString(3, c.getTelefone());
		comando.setString(4, c.getCelular());
		comando.setString(5, c.getEmail());
		comando.setString(6, c.getCep());
		comando.setString(7, c.getRua());
		comando.setLong(8, c.getNumero());
		comando.setString(9, c.getComplemento());
		comando.setString(10, c.getBairro());
		comando.setString(11, c.getCidade());
		comando.setString(12, c.getEstado());
		comando.setLong(13, c.getIdcliente());
		
		
		comando.executeUpdate();
	}

	public ArrayList<Cliente> listar() throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT idcliente, nome, cpf, senha, telefone, celular, email, cep, rua, numero, complemento, bairro, cidade, estado ");
		sql.append("FROM cliente ");
		sql.append("ORDER BY nome ASC ");
		
		Connection conexao = Conexao.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		
		ResultSet resultado = comando.executeQuery();
		
		ArrayList<Cliente> lista = new ArrayList<Cliente>();
		
		while(resultado.next()){
			Cliente c = new Cliente();
			c.setIdcliente(resultado.getLong("idcliente"));
			c.setNome(resultado.getString("nome"));
			c.setCpf(resultado.getString("cpf"));
			c.setTelefone(resultado.getString("telefone"));
			c.setCelular(resultado.getString("celular"));
			c.setEmail(resultado.getString("email"));
			c.setCep(resultado.getString("cep"));
			c.setRua(resultado.getString("rua"));
			c.setNumero(resultado.getLong("numero"));
			c.setComplemento(resultado.getString("complemento"));
			c.setBairro(resultado.getString("bairro"));
			c.setCidade(resultado.getString("cidade"));
			c.setEstado(resultado.getString("estado"));
			lista.add(c);
		}
		
		return lista;
	}

}
