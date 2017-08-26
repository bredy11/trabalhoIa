package com.populacaoRepresa.model;

import java.util.HashMap;
import java.util.Map;

public class UtilIniciador {

	public static Map<String, Cidade> criarMapa() {

		Map<String, Cidade> cidades = new HashMap<>();
		// 1
		Cidade cidade = new Cidade("1");
		cidade.inserirCidade("3");
		cidade.inserirCidade("5");
		cidade.inserirCidade("2");

		cidades.put(cidade.getNome(), cidade);
		// 2
		cidade = new Cidade("2");
		cidade.inserirCidade("3");
		cidade.inserirCidade("7");
		cidade.inserirCidade("1");
		

		cidades.put(cidade.getNome(), cidade);
		// 3
		cidade = new Cidade("3");
		cidade.inserirCidade("1");
		cidade.inserirCidade("2");
		cidade.inserirCidade("4");
		cidade.inserirCidade("7");

		cidades.put(cidade.getNome(), cidade);
		// 4

		cidade = new Cidade("4");
		cidade.inserirCidade("3");
		cidade.inserirCidade("6");
		cidade.inserirCidade("7");
		cidade.inserirCidade("5");

		cidades.put(cidade.getNome(), cidade);
		// 5
		cidade = new Cidade("5");
		cidade.inserirCidade("1");
		cidade.inserirCidade("8");
		cidade.inserirCidade("4");

		cidades.put(cidade.getNome(), cidade);
		
		// 6
		cidade = new Cidade("6");
		cidade.inserirCidade("4");
		cidade.inserirCidade("7");
		cidade.inserirCidade("8");
		
		cidades.put(cidade.getNome(), cidade);
		// 7
		cidade = new Cidade("7");
		cidade.inserirCidade("6");
		cidade.inserirCidade("2");
		cidade.inserirCidade("3");
		cidade.inserirCidade("4");

		
		cidades.put(cidade.getNome(), cidade);
		// 8
		cidade = new Cidade("8");
		cidade.inserirCidade("6");
		cidade.inserirCidade("5");
		cidade.inserirCidade("4");


		cidades.put(cidade.getNome(), cidade);
		return cidades;
	}

}
