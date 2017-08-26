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
		
		cidades.put(cidade.getNome(), cidade);
		return cidades;
	}

	public static Grafo inicializarGrafo() {
		Grafo grafo = new Grafo(9);
		// cidada 1
		grafo.addAresta(new Cidade(1), new Cidade(2), 5);
		grafo.addAresta(new Cidade(1), new Cidade(3), 3);
		grafo.addAresta(new Cidade(1), new Cidade(5), 8);

		// cidada 2
		grafo.addAresta(new Cidade(2), new Cidade(1), 5);
		grafo.addAresta(new Cidade(2), new Cidade(7), 5);
		grafo.addAresta(new Cidade(2), new Cidade(3), 4);

		// cidada 3
		grafo.addAresta(new Cidade(3), new Cidade(1), 3);
		grafo.addAresta(new Cidade(3), new Cidade(2), 4);
		grafo.addAresta(new Cidade(3), new Cidade(7), 7);
		grafo.addAresta(new Cidade(3), new Cidade(4), 3);
		// cidade 4
		grafo.addAresta(new Cidade(4), new Cidade(3), 3);
		grafo.addAresta(new Cidade(4), new Cidade(7), 6);
		grafo.addAresta(new Cidade(4), new Cidade(6), 1);
		grafo.addAresta(new Cidade(4), new Cidade(5), 2);

		// cidade 5
		grafo.addAresta(new Cidade(5), new Cidade(8), 4);
		grafo.addAresta(new Cidade(5), new Cidade(4), 2);
		grafo.addAresta(new Cidade(5), new Cidade(1), 8);
		// cidade 6
		grafo.addAresta(new Cidade(6), new Cidade(4), 1);
		grafo.addAresta(new Cidade(6), new Cidade(7), 9);
		grafo.addAresta(new Cidade(6), new Cidade(8), 4);
		// cidade 7
		grafo.addAresta(new Cidade(7), new Cidade(6), 9);
		grafo.addAresta(new Cidade(7), new Cidade(2), 5);
		grafo.addAresta(new Cidade(7), new Cidade(3), 7);
		grafo.addAresta(new Cidade(7), new Cidade(4), 6);
		// cidade 8
		grafo.addAresta(new Cidade(8), new Cidade(6), 4);
		grafo.addAresta(new Cidade(8), new Cidade(5), 4);

		return grafo;
	}

}
