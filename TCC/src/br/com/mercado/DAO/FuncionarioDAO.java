package br.com.mercado.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.mercado.factory.Conexao;
import br.com.mercado.model.Funcionario;

public class FuncionarioDAO {
	
	public void salvar(Funcionario f) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO funcionario ");
		sql.append("(nome, senha, cpf, rg, rua, numero, bairro, cidade, estado, telefone, celular, email, salario) ");
		sql.append("VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ");
		
		Connection conexao = Conexao.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, f.getNome());
		comando.setString(2, f.getSenha());
		comando.setString(3, f.getCpf());
		comando.setString(4, f.getRg());
		comando.setString(5, f.getRua());
		comando.setLong(6, f.getNumero());
		comando.setString(7, f.getBairro());
		comando.setString(8, f.getCidade());
		comando.setString(9, f.getEstado());
		comando.setString(10, f.getTelefone());
		comando.setString(11, f.getCelular());
		comando.setString(12, f.getEmail());
		comando.setFloat(13, f.getSalario());
	
		comando.executeUpdate();
		
	}
	
	public void excluir(Funcionario f) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM funcionario ");
		sql.append("WHERE idfuncionario = ? ");
		
		Connection conexao = Conexao.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setLong(1, f.getIdfuncionario());

		
		comando.executeUpdate();
	}
	
	public void editar(Funcionario f) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE funcionario ");
		sql.append("SET nome = ?, cpf = ?, rg = ?, rua = ?, numero = ?, bairro = ?, cidade = ?, estado = ?, telefone = ?, celular = ?, email = ?, salario = ? ");
		sql.append("WHERE idfuncionario = ? ");
		
		Connection conexao = Conexao.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, f.getNome());
		comando.setString(2, f.getCpf());
		comando.setString(3, f.getRg());
		comando.setString(4, f.getRua());
		comando.setLong(5, f.getNumero());
		comando.setString(6, f.getBairro());
		comando.setString(7, f.getCidade());
		comando.setString(8, f.getEstado());
		comando.setString(9, f.getTelefone());
		comando.setString(10, f.getCelular());
		comando.setString(11, f.getEmail());
		comando.setFloat(12, f.getSalario());
		comando.setLong(13, f.getIdfuncionario());
		
		
		comando.executeUpdate();
	}

	public ArrayList<Funcionario> listar() throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT idfuncionario, nome, cpf, rg, rua, numero, bairro, cidade, estado, telefone, celular, email, salario ");
		sql.append("FROM funcionario ");
		sql.append("ORDER BY nome ASC ");
		
		Connection conexao = Conexao.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		
		ResultSet resultado = comando.executeQuery();
		
		ArrayList<Funcionario> lista = new ArrayList<Funcionario>();
		
		while(resultado.next()){
			Funcionario f = new Funcionario();
			f.setIdfuncionario(resultado.getLong("idfuncionario"));
			f.setNome(resultado.getString("nome"));
			f.setCpf(resultado.getString("cpf"));
			f.setRg(resultado.getString("rg"));
			f.setRua(resultado.getString("rua"));
			f.setNumero(resultado.getLong("numero"));
			f.setBairro(resultado.getString("bairro"));
			f.setCidade(resultado.getString("cidade"));
			f.setEstado(resultado.getString("estado"));
			f.setTelefone(resultado.getString("telefone"));
			f.setCelular(resultado.getString("celular"));
			f.setEmail(resultado.getString("email"));
		    f.setSalario(resultado.getFloat("salario"));
			lista.add(f);
		}
		
		return lista;
	}
}
