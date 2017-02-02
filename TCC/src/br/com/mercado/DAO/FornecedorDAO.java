package br.com.mercado.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.mercado.factory.Conexao;
import br.com.mercado.model.Fornecedor;

public class FornecedorDAO {
	public void salvar(Fornecedor f) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO fornecedor ");
		sql.append("(nome, cnpj, rua, numero, bairro, cidade, estado, telefone, fax, email) ");
		sql.append("VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ");
		
		Connection conexao = Conexao.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, f.getNome());
		comando.setString(2, f.getCnpj());
		comando.setString(3, f.getRua());
		comando.setLong(4, f.getNumero());
		comando.setString(5, f.getBairro());
		comando.setString(6, f.getCidade());
		comando.setString(7, f.getEstado());
		comando.setString(8, f.getTelefone());
		comando.setString(9, f.getFax());
		comando.setString(10, f.getEmail());

		comando.executeUpdate();
		
	}
	
	public void excluir(Fornecedor f) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM fornecedor ");
		sql.append("WHERE idfornecedor = ? ");
		
		Connection conexao = Conexao.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setLong(1, f.getIdfornecedor());

		
		comando.executeUpdate();
	}
	
	public void editar(Fornecedor f) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE fornecedor ");
		sql.append("SET nome = ?, cnpj = ?, rua = ?, numero = ?, bairro = ?, cidade = ?, estado = ?, telefone = ?, fax = ?, email = ? ");
		sql.append("WHERE idfornecedor = ? ");
		
		Connection conexao = Conexao.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, f.getNome());
		comando.setString(2, f.getCnpj());
		comando.setString(3, f.getRua());
		comando.setLong(4, f.getNumero());
		comando.setString(5, f.getBairro());
		comando.setString(6, f.getCidade());
		comando.setString(7, f.getEstado());
		comando.setString(8, f.getTelefone());
		comando.setString(9, f.getFax());
		comando.setString(10, f.getEmail());
		comando.setLong(11, f.getIdfornecedor());
		
		
		comando.executeUpdate();
	}

	public ArrayList<Fornecedor> listar() throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT idfornecedor, nome, cnpj, rua, numero, bairro, cidade, estado, telefone, fax, email ");
		sql.append("FROM fornecedor ");
		sql.append("ORDER BY nome ASC ");
		
		Connection conexao = Conexao.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		
		ResultSet resultado = comando.executeQuery();
		
		ArrayList<Fornecedor> lista = new ArrayList<Fornecedor>();
		
		while(resultado.next()){
			Fornecedor f = new Fornecedor();
			f.setIdfornecedor(resultado.getLong("idfornecedor"));
			f.setNome(resultado.getString("nome"));
			f.setCnpj(resultado.getString("cnpj"));
			f.setRua(resultado.getString("rua"));
			f.setNumero(resultado.getLong("numero"));
			f.setCidade(resultado.getString("cidade"));
			f.setBairro(resultado.getString("bairro"));
			f.setEstado(resultado.getString("estado"));
			f.setTelefone(resultado.getString("telefone"));
			f.setFax(resultado.getString("fax"));
			f.setEmail(resultado.getString("email"));
			lista.add(f);
		}
		
		return lista;
	}
}
