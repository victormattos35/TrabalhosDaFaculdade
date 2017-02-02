package br.com.drogaria.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.drogaria.dominio.Venda;
import br.com.drogaria.factory.ConexaoFactory;
import br.com.drogaria.util.Datas;

public class VendaDAO {
	private String diaatual;
	public boolean salvar(Venda v) {
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO venda ");
			sql.append("(dia, valortotal, cliente_idcliente) ");
			sql.append("VALUES (?, ?, ?) ");
			
			Connection conexao = ConexaoFactory.conectar();

			PreparedStatement comando = conexao
					.prepareStatement(sql.toString());
			
			br.com.drogaria.util.ConverteDate con = new br.com.drogaria.util.ConverteDate();
			diaatual = con.date();
			System.out.println(diaatual);
			comando.setString(1, diaatual);
			comando.setDouble(2, v.getValortotal());
			comando.setLong(3, v.getCliente().getIdcliente());
			comando.executeUpdate();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
