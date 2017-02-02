package br.com.redeteste.service;

import java.util.ArrayList;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import br.com.redeteste.domain.Dados;

public class BuscaService {
	private Dados dados;

	private ArrayList<Dados> completo = new ArrayList<Dados>();

	public Dados getDados() {
		return dados;
	}

	public void setDados(Dados dados) {
		this.dados = dados;
	}

	public ArrayList<Dados> getCompleto() {
		return completo;
	}

	public void setCompleto(ArrayList<Dados> completo) {
		this.completo = completo;
	}

	public ArrayList<Dados> listar() {
		Client cliente = ClientBuilder.newClient();
		WebTarget caminho = cliente
				.target("http://187.84.56.122:81/api/departamentos?fields=DEP_CODIGO,DEP_DESCRI");
		String json = caminho.request().get(String.class);
		System.out.println(json);
		try {
			JSONObject jObj = new JSONObject(json);
			JSONArray jArray = jObj.getJSONArray("data");
			for (int i = 0; i < jArray.length(); i++) {
				JSONObject jo = jArray.getJSONObject(i);
				if (jo.has("DEP_CODIGO")) {
					dados = new Dados();
					// System.out.println(jo.getString("DEP_CODIGO"));
					// System.out.println(jo.getString("DEP_DESCRI"));
					dados.setDEPCODIGO(jo.getString("DEP_CODIGO").toString());
					dados.setDEPDESCRI(jo.getString("DEP_DESCRI").toString());
					// System.out.println(dados.getDEPCODIGO());
					completo.add(dados);
				}
			}

			// System.out.println("AQUI");
			JSONObject jObj1 = new JSONObject(json);
			JSONObject jo = jObj1.getJSONObject("pagination");

			// System.out.println(jo.getString("links"));
			// System.out.println(jo.getString("next_page_url"));

			dados = new Dados();
			dados.setNextpageurl(jo.getBoolean("next_page_url"));
			dados.setLinks(jo.getString("links"));

			completo.add(dados);

		} catch (JSONException e) {
			e.printStackTrace();
		}

		return completo;
	}

}
