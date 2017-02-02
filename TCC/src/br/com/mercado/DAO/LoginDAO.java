package br.com.mercado.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import br.com.mercado.factory.Conexao;

public class LoginDAO {
	public static boolean validate(Long idfuncionario, String senha) {
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("Select idfuncionario, senha from funcionario where idfuncionario = ? and senha = ?");

			Connection conexao = (Connection) Conexao.conectar();
			PreparedStatement comando = (PreparedStatement) conexao
					.prepareStatement(sql.toString());

			comando.setLong(1, idfuncionario);
			comando.setString(2, senha);

			ResultSet rs = comando.executeQuery();

			if (rs.next()) {
				// result found, means valid inputs
				return true;
			}
		} catch (SQLException ex) {
			System.out.println("Login error -->" + ex.getMessage());
			return false;
		}
		return false;
	}
}
