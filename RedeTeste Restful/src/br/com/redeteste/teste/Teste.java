package br.com.redeteste.teste;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import br.com.redeteste.dao.RedeDAO;
import br.com.redeteste.domain.Rede;

public class Teste {
	/*
	 * public static void main(String[] args) throws SQLException { Rede rede =
	 * new Rede(); rede.setNome("Arroz"); rede.setIdade(1L); Date dia = new
	 * Date(12-01-2015); dia = teste(dia); rede.setDataInsercao(dia); RedeDAO
	 * dao = new RedeDAO(); dao.salvar(rede);
	 * 
	 * }
	 * 
	 * public static Date teste(Date date) { SimpleDateFormat dateFormat = new
	 * SimpleDateFormat("dd/MM/yyyy"); dateFormat.format(date); return date; }
	 */

	public static void main(String[] args) throws SQLException {
		//RedeDAO dao = new RedeDAO();
		//List<Rede> redes = dao.listar();
		//for (Rede rede : redes) {
			//System.out.println(rede.getCodigo() + " - " + rede.getNome() + " - " + rede.getIdade() + " - "
				//	+ rede.getDataInsercao() + "-----------------");
		RedeDAO dao = new RedeDAO();
		Rede rede1 = new Rede();
		rede1 = dao.buscar(2L);
		System.out.println(rede1.getCodigo() + " - " + rede1.getNome() + " - " + rede1.getIdade() + " - "
					+ rede1.getDataInsercao() + "-----------------");
		}

	public void listar() throws SQLException {

	}
}
