package br.com.drogaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import java.util.ArrayList;

import br.com.drogaria.dominio.Fabricante;
import br.com.drogaria.factory.ConexaoFactory;

public class FabricanteDAO {
	
	public void salvar(Fabricante f) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO fabricante ");
		sql.append("(descricao, endereco, numero, cidade, estado, telefone) ");
		sql.append("VALUES (?, ?, ?, ?, ?, ?)");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, f.getDescricao());
		comando.setString(2, f.getEndereco());
		comando.setLong(3, f.getNumero());
		comando.setString(4, f.getCidade());
		comando.setString(5, f.getEstado());
		comando.setString(6, f.getTelefone());
		
		comando.executeUpdate();
		
	}
	
	public void excluir(Fabricante f) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM fabricante ");
		sql.append("WHERE codigo = ? ");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setLong(1, f.getCodigo());
		
		comando.executeUpdate();
	}
	
	public void editar(Fabricante f) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE fabricante ");
		sql.append("SET descricao = ?, endereco = ?, numero = ?, cidade = ?, estado = ?, telefone = ? ");
		sql.append("WHERE codigo = ? ");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, f.getDescricao());
		comando.setString(2, f.getEndereco());
		comando.setLong(3, f.getNumero());
		comando.setString(4, f.getCidade());
		comando.setString(5, f.getEstado());
		comando.setString(6, f.getTelefone());
		comando.setLong(7, f.getCodigo());
		
		comando.executeUpdate();
	}
	
	public Fabricante buscarPorCodigo(Fabricante f) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT codigo, descricao, endereco, numero, cidade, estado, telefone ");
		sql.append("FROM fabricante ");
		sql.append("WHERE codigo = ? ");
		
		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setLong(1, f.getCodigo());
		
		ResultSet resultado = comando.executeQuery();
		
		Fabricante retorno = null;
		
		if(resultado.next()){
			retorno = new Fabricante();
			retorno.setCodigo(resultado.getLong("codigo"));
			retorno.setDescricao(resultado.getString("descricao"));
			retorno.setEndereco(resultado.getString("endereco"));
			retorno.setNumero(resultado.getLong("numero"));
			retorno.setCidade(resultado.getString("cidade"));
			retorno.setEstado(resultado.getString("estado"));
			retorno.setTelefone(resultado.getString("telefone"));
			
		}
		
		return retorno;
		
	}

	public ArrayList<Fabricante> listar() throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT codigo, descricao, endereco, numero, cidade, estado, telefone ");
		sql.append("FROM fabricante ");
		sql.append("ORDER BY descricao ASC ");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		
		ResultSet resultado = comando.executeQuery();
		
		ArrayList<Fabricante> lista = new ArrayList<Fabricante>();
		
		while(resultado.next()){
			Fabricante f = new Fabricante();
			f.setCodigo(resultado.getLong("codigo"));
			f.setDescricao(resultado.getString("descricao"));
			f.setEndereco(resultado.getString("endereco"));
			f.setNumero(resultado.getLong("numero"));
			f.setCidade(resultado.getString("cidade"));
			f.setEstado(resultado.getString("estado"));
			f.setTelefone(resultado.getString("telefone"));
			
			
			lista.add(f);
		}
		
		
		return lista;
	}
	
	public ArrayList<Fabricante> buscarPorDescricao(Fabricante f) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT codigo, descricao, endereco, numero, cidade, estado, telefone ");
		sql.append("FROM fabricante ");
		sql.append("WHERE descricao LIKE ? ");
		sql.append("ORDER BY descricao ASC ");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1,"%" + f.getDescricao() + "%");
		
		ResultSet resultado = comando.executeQuery();
		
		ArrayList<Fabricante> lista = new ArrayList<Fabricante>();
		
		while(resultado.next()){
			Fabricante item = new Fabricante();
			item.setCodigo(resultado.getLong("codigo"));
			item.setDescricao(resultado.getString("descricao"));
			item.setEndereco(resultado.getString("endereco"));
			item.setNumero(resultado.getLong("numero"));
			item.setCidade(resultado.getString("cidade"));
			item.setEstado(resultado.getString("estado"));
			item.setTelefone(resultado.getString("telefone"));
			
			lista.add(item);
		}
		
		
		return lista;
		
	}
	public static void main(String[] args) {
		/*
		//salvar 
		Fabricante f1 = new Fabricante();
		f1.setDescricao("descricao 1");
		Fabricante f2 = new Fabricante();
		f2.setDescricao("descricao 2");
		
		FabricanteDAO fdao = new FabricanteDAO();
		try {
			fdao.salvar(f1);
			fdao.salvar(f2);
			System.out.println("Fabricantes foram salvos com sucesso!");
		} catch (SQLException e) {
			System.out.println("Fabricantes não foram salvos com sucesso!");
			e.printStackTrace();
		}
		
		//excluir
		Fabricante f1 = new Fabricante();
		f1.setCodigo(1L);
		
		Fabricante f2 = new Fabricante();
		f2.setCodigo(2L);
		
		FabricanteDAO fdao = new FabricanteDAO();
	    try {
	    	fdao.excluir(f1);
			fdao.excluir(f2);
			System.out.println("Removido");
		} catch (SQLException e) {
			System.out.println("Não Removido");
			e.printStackTrace();
		}
		
		
	    //editar
		Fabricante f1 = new Fabricante();
		f1.setCodigo(3L);
		f1.setDescricao("DESCRICAO 3");
		
		FabricanteDAO fdao = new FabricanteDAO();
		
		try {
			fdao.editar(f1);
			System.out.println("Editou");
		} catch (SQLException e) {
			System.out.println("Não editou");
			e.printStackTrace();
		}
		
		
		Fabricante f1 = new Fabricante();
		f1.setCodigo(3L);
		
		Fabricante f2 = new Fabricante();
		f2.setCodigo(5L);
		
		FabricanteDAO fdao = new FabricanteDAO();
		
		try {
			Fabricante f3 = fdao.buscarPorCodigo(f1);
			Fabricante f4 = fdao.buscarPorCodigo(f2);
			System.out.println("Resultado 1: " + f3);
			System.out.println("Resultado 2: " + f4);
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
		
		FabricanteDAO fdao = new FabricanteDAO();
		try {
			ArrayList<Fabricante> lista = fdao.listar();
			
			for(Fabricante f : lista){
				System.out.println("Resultado : " + f);
				
			}
		} catch (SQLException e) {
			System.out.println("ERRO!");
			e.printStackTrace();
		}
		
		
		Fabricante f1 = new Fabricante();
		f1.setDescricao("2");
		
		FabricanteDAO fdao = new FabricanteDAO();
		
		try {
			ArrayList<Fabricante> lista = fdao.buscarPorDescricao(f1);
			
			for(Fabricante f : lista){
				System.out.println("Resultado : " + f);
				
			}
		} catch (SQLException e) {
			System.out.println("ERRO!");
			e.printStackTrace();
		}*/
		
	}

}
