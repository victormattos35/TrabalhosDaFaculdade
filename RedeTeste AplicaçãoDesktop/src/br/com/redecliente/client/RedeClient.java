package br.com.redecliente.client;

import java.util.Arrays;
import java.util.List;

import javax.swing.plaf.metal.MetalDesktopIconUI;
import javax.ws.rs.DELETE;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import br.com.redecliente.domain.Rede;

public class RedeClient {
	private Rede rede;

	private List<Rede> redes;

	public Rede getRede() {
		return rede;
	}

	public void setRede(Rede rede) {
		this.rede = rede;
	}

	public List<Rede> getRedes() {
		return redes;
	}

	public void setRedes(List<Rede> redes) {
		this.redes = redes;
	}

	public List<Rede> listar() {
		Client cliente = ClientBuilder.newClient();
		WebTarget caminho = cliente.target("http://127.0.0.1:8080/RedeTeste/rest/rede");
		String json = caminho.request().get(String.class);
		System.out.println(json);
		Gson gson = new Gson();
		Rede[] vetor = gson.fromJson(json, Rede[].class);

		redes = Arrays.asList(vetor);
		return redes;
	}

	public void salvar(Rede rede) {
		Client cliente = ClientBuilder.newClient();
		WebTarget caminho = cliente.target("http://127.0.0.1:8080/RedeTeste/rest/rede");
		Gson gson = new Gson();
		String json = gson.toJson(rede);
		caminho.request().post(Entity.json(json));

		rede = new Rede();

		json = caminho.request().get(String.class);
		Rede[] vetor = gson.fromJson(json, Rede[].class);

		redes = Arrays.asList(vetor);

	}
	
	public void alterar(Rede rede) {
		Client cliente = ClientBuilder.newClient();
		WebTarget caminho = cliente.target("http://127.0.0.1:8080/RedeTeste/rest/rede");
		Gson gson = new Gson();
		String json = gson.toJson(rede);
		caminho.request().put(Entity.json(json));

		rede = new Rede();

		json = caminho.request().get(String.class);
		Rede[] vetor = gson.fromJson(json, Rede[].class);

		redes = Arrays.asList(vetor);

	}

	public void deletar(Rede rede) {
		Client cliente = ClientBuilder.newClient();
		WebTarget caminho = cliente.target("http://127.0.0.1:8080/RedeTeste/rest/rede/"+rede.getCodigo());
		caminho.request().delete(String.class);

		rede = new Rede();

	}

	public static void main(String[] args) {
		Client cliente = ClientBuilder.newClient();
		WebTarget caminho = cliente.target("http://127.0.0.1:8080/RedeTeste/rest/rede");
		String json = caminho.request().get(String.class);
		Gson gson = new Gson();
		Rede[] vetor = gson.fromJson(json, Rede[].class);
		System.out.println(vetor);

	}
}
