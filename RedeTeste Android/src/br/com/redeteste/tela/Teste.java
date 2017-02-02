package br.com.redeteste.tela;


import java.util.List;

import br.com.redeteste.domain.Dados;
import br.com.redeteste.service.BuscaService;

public class Teste {
	public static void main(String[] args) {
		BuscaService buscSer = new BuscaService();
		List<Dados> lista = buscSer.listar();
		System.out.println(lista);
	}
}
