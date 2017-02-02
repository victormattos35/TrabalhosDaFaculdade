package br.com.redeteste.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	private static final String URL = "jdbc:mysql://localhost:3306/rede";
	private static final String USUARIO = "root";
	private static final String SENHA = "1234";

	public static Connection conectar() throws SQLException {
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
		return conexao;
	}

	public static void main(String[] args) {
		try {
			Connection conectar = Conexao.conectar();
			System.out.println("Funcionou");
		} catch (Exception e) {
			System.out.println("Erro!");
			e.printStackTrace();
		}
	}
}
