package com.populacaoRepresa.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.populacaoRepresa.model.Cidade;
import com.populacaoRepresa.model.Grafo;
import com.populacaoRepresa.model.Populacao;
import com.populacaoRepresa.model.UtilIniciador;

public class MainController {

	public static void main(String[] args) {
		
		Map<String, Cidade> cidades = UtilIniciador.criarMapa();
		Grafo grafo = UtilIniciador.inicializarGrafo();
		
		
		List<String> populacoes = new ArrayList<>();
		
		Populacao populacao = new Populacao();
		
		populacoes = populacao.newPop(cidades.size());
		
		
		
		String cidadeInicial ="2";
		String cidadeFinal = "8";
		
		populacoes = populacao.validarPopulacao(cidadeInicial, cidadeFinal, populacoes, cidades);
		
		populacao.cross(populacoes, cidades,cidadeInicial, cidadeFinal,grafo);
	}

}
