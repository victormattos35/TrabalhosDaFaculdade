package br.com.redeteste.service;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.google.gson.Gson;

import br.com.redeteste.dao.RedeDAO;
import br.com.redeteste.domain.Rede;

// http://localhost:8080/RedeService/rest/rede
@Path("rede")
public class RedeService {

	@GET
	public String listar() {

		RedeDAO redeDAO = new RedeDAO();
		List<Rede> rede = redeDAO.listar();
		Gson gson = new Gson();
		String json = gson.toJson(rede);
		return json;

	}

	@GET
	@Path("{codigo}")
	public String buscar(@PathParam("codigo") Long codigo) {
		RedeDAO redeDAO = new RedeDAO();
		Rede rede = redeDAO.buscar(codigo);

		Gson gson = new Gson();
		String json = gson.toJson(rede);
		return json;
	}

	@POST
	public String salvar(String json) {
		Gson gson = new Gson();
		Rede rede = gson.fromJson(json, Rede.class);
		RedeDAO redeDAO = new RedeDAO();
		redeDAO.salvar(rede);

		String jsonSaida = gson.toJson(rede);
		return jsonSaida;
	}

	@PUT
	public String editar(String json) {
		Gson gson = new Gson();
		Rede rede = gson.fromJson(json, Rede.class);
		RedeDAO redeDAO = new RedeDAO();
		redeDAO.editar(rede);

		String jsonSaida = gson.toJson(rede);
		return jsonSaida;
	}

	@DELETE
	@Path("{codigo}")
	public void excluir(@PathParam("codigo") Long json) {
		System.out.println(json + "VALOR");

		Rede rede = new Rede();
		RedeDAO redeDAO = new RedeDAO();
		rede = redeDAO.buscar(json);
		redeDAO.excluir(rede);
	}

	public static void main(String[] args)
			throws SQLException { /*
									 * RedeDAO redeDAO = new RedeDAO();
									 * List<Rede> rede = redeDAO.listar(); Gson
									 * gson = new Gson(); String json =
									 * gson.toJson(rede);
									 * System.out.println(json); RedeDAO redeDAO
									 * = new RedeDAO(); Rede rede =
									 * redeDAO.buscar(codigo);
									 */
		RedeDAO redeDAO = new RedeDAO();
		Rede rede = redeDAO.buscar(1L);
		Gson gson = new Gson();
		String json = gson.toJson(rede);
		System.out.println(json);
	}

}
