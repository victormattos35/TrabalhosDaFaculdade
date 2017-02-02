package br.com.redeteste.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.redeteste.conexao.Conexao;
import br.com.redeteste.domain.Rede;

public class RedeDAO {
	public void salvar(Rede r) {

		try {
			StringBuilder sql = new StringBuilder();

			sql.append("INSERT INTO rede ");
			sql.append("(nome, idade, datainsercao) ");
			sql.append("VALUES (?, ?, ?) ");

			Connection conexao = Conexao.conectar();

			PreparedStatement comando = conexao.prepareStatement(sql.toString());

			comando.setString(1, r.getNome());
			comando.setLong(2, r.getIdade());
			comando.setString(3, r.getDataInsercao());

			comando.executeUpdate();
			conexao.close();
			comando.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Rede> listar() {
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT codigo, nome, idade, datainsercao ");
			sql.append("FROM rede");

			Connection conexao = Conexao.conectar();

			PreparedStatement comando = conexao.prepareStatement(sql.toString());

			ResultSet resultado = comando.executeQuery();

			List<Rede> itens = new ArrayList<Rede>();
			while (resultado.next()) {
				Rede r = new Rede();
				r.setCodigo(resultado.getLong("codigo"));
				r.setNome(resultado.getString("nome"));
				r.setIdade(resultado.getLong("idade"));
				r.setDataInsercao(resultado.getString("datainsercao"));

				itens.add(r);
			}
			conexao.close();
			comando.close();
			return itens;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Rede buscar(Long codigo) {
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT codigo, nome, idade, datainsercao ");
			sql.append("FROM rede ");
			sql.append("WHERE codigo = ? ");
			Connection conexao = Conexao.conectar();

			PreparedStatement comando = conexao.prepareStatement(sql.toString());

			comando.setLong(1, codigo);

			ResultSet resultado = comando.executeQuery();
			Rede rede = null;
			if (resultado.next()) {
				rede = new Rede();
				rede.setCodigo(resultado.getLong("codigo"));
				rede.setNome(resultado.getString("nome"));
				rede.setIdade(resultado.getLong("idade"));
				rede.setDataInsercao(resultado.getString("datainsercao"));

			}
			return rede;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	public void excluir(Rede r) {
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("DELETE FROM rede ");
			sql.append("WHERE codigo = ? ");

			Connection conexao = Conexao.conectar();

			PreparedStatement comando = conexao.prepareStatement(sql.toString());

			comando.setLong(1, r.getCodigo());

			comando.executeUpdate();
			conexao.close();
			comando.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void editar(Rede r) {
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE rede ");
			sql.append("SET nome = ?, idade = ?, datainsercao = ? ");
			sql.append("WHERE codigo = ? ");

			Connection conexao = Conexao.conectar();

			PreparedStatement comando = conexao.prepareStatement(sql.toString());

			comando.setString(1, r.getNome());
			comando.setLong(2, r.getIdade());
			comando.setString(3, r.getDataInsercao());
			comando.setLong(4, r.getCodigo());

			comando.executeUpdate();
			conexao.close();
			comando.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
