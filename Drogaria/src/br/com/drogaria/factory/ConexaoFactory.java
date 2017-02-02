package br.com.drogaria.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class ConexaoFactory {
	private static final String USUARIO = "root";
	private static final String SENHA = "1234";
	private static final String URL = "jdbc:mysql://localhost:3306/drogaria_teste";

	public static Connection conectar() throws SQLException {
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
		return conexao;

	}

	public static void main(String[] args) {
		try {
			Connection conexao = ConexaoFactory.conectar();
			System.out.println("Conexao Realizada com Sucesso!");
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("N�o foi possivel realizar a conex�o!");

		}
	}
}
