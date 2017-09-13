package com.populacaoRepresa.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.populacaoRepresa.model.Cidade;
import com.populacaoRepresa.model.Grafo;
import com.populacaoRepresa.model.Populacao;
import com.populacaoRepresa.model.UtilIniciador;

public class MainController {

	public static void main(String[] args) {
		int sairMenu = 1;
		Scanner sc = new Scanner(System.in);
		do {
			try {
				
				System.out.println("Digite o ponto de partida: ");
				String cidadeInicial = sc.next();

				System.out.println("Digite o ponto final: ");
				String cidadeFinal = sc.next();

				controllador(cidadeInicial, cidadeFinal);

				System.out.println("Digite 1 para sair:");
				sairMenu = sc.nextInt();
			} catch (Exception e) {
				
				System.err.println("Verifique a entrada ocorreu um erro, os numeros digitados deve ser de 1 a 9");
				System.out.println("Digite 1 para sair:");
				sairMenu = sc.nextInt();
			}

		} while (sairMenu != 1);
	}

	public static void controllador(String cidadeInicial, String cidadeFinal) {
		Map<String, Cidade> cidades = UtilIniciador.criarMapa();
		Grafo grafo = UtilIniciador.inicializarGrafo();

		List<String> populacoes = new ArrayList<>();

		Populacao populacao = new Populacao();

		populacoes = populacao.newPop(cidades.size());

		populacoes = populacao.validarPopulacao(cidadeInicial, cidadeFinal, populacoes, cidades);

		populacoes = populacao.cross(populacoes, cidades, cidadeInicial, cidadeFinal);

		String melhorCromo = populacao.melhorCaminho(populacoes, grafo);
		int peso = grafo.avaliarPesoCromo(melhorCromo);
		System.out.println(String.format("Cromo: %s  peso: %d", melhorCromo, peso));

	}
}
