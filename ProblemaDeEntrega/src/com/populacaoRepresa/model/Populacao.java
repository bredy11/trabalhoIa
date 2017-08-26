package com.populacaoRepresa.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class Populacao {

	private int nInt = 20000;
	// private int nCroms = 3;
	private Integer newPop[] = new Integer[nInt];
	private String populacaoEmBinario[] = new String[nInt];
	private Random rando = new Random();

	public List<String> newPop(int numeroCidades) {
		List<String> newPop = new ArrayList<>();
		for (int i = 0; i < nInt; i++) {

			String caminho = "";
			for (int j = 0; j < numeroCidades; j++) {
				caminho += rando.nextInt(numeroCidades) + 1;
			}

			newPop.add(caminho);
		}
		return newPop;
	}

	public String[] cod() {
		int cont = 0;

		for (Integer pop : newPop) {
			StringBuilder zeros = new StringBuilder();
			String binario = Integer.toBinaryString(pop);
			if (binario.length() != 8) {
				int zerosFaltando = 8 - binario.length();
				for (int i = 0; i < zerosFaltando; i++) {
					zeros.append("0");
				}
			}
			populacaoEmBinario[cont] = zeros.toString() + binario;
			cont++;
		}

		return populacaoEmBinario;
	}

	public Integer[] decodificador() {
		Integer popDecod[] = new Integer[nInt];
		int cont = 0;
		for (String popBin : populacaoEmBinario) {
			Integer decod = Integer.parseInt(popBin, 2);
			popDecod[cont] = decod;
			cont++;
		}
		return popDecod;
	}

	public List<String> validarPopulacao(String cidadeInicial, String cidadeFinal, List<String> populacao,
			Map<String, Cidade> cidades) {

		for (int i = populacao.size(); 0 < i; i--) {
		
			if (!populacao.get(i - 1).contains(cidadeInicial)) {
				populacao.remove(i - 1);
				continue;
			}
			// se no caminho passa pela a cidade final em algum momento
			if (!populacao.get(i - 1).contains(cidadeFinal)) {
				populacao.remove(i - 1);
				continue;
			}

			char cidadeChar[] = populacao.get(i - 1).toCharArray();
			for (int j = 1; j < cidades.size(); j++) {

				Cidade cidade = cidades.get(String.valueOf(cidadeChar[j - 1]));
				Cidade cidade2 = cidades.get(String.valueOf(cidadeChar[j]));
				if (cidade.equals(cidade2)) {
					continue;
				}

				if (!cidade.getLigaçoes().contains(cidade2)) {
					populacao.remove(i - 1);

					break;
				}

			}

		}

		return populacao;

	}

	public List<String> cross(List<String> pais, Map<String, Cidade> cidades, String cidadeIncial, String cidadeFinal) {
		Random posicaoDeTroca = new Random();
		List<String> filhos = new ArrayList<>();
	
		for (int cont = 0; cont < 2000; cont++)
			for (int i = 0; i < pais.size() - 1; i++) {
				String pai = pais.get(i);
				String mae = pais.get(i + 1);

				String cromoFilho = "";
				// 50% de cromossomos de 4 ou de 2
				if (posicaoDeTroca.nextInt(2) == 1) {
					String cromoPai[] = fazerVector(pai, 4, 2);
					String cromoMae[] = fazerVector(mae, 4, 2);
					// 50 % de chance se o pai o a mae tem o promo incial
					cromoFilho += posicaoDeTroca.nextInt(2) == 1 ? cromoPai[posicaoDeTroca.nextInt(4)]
							: cromoMae[posicaoDeTroca.nextInt(4)];
					cromoFilho += posicaoDeTroca.nextInt(2) == 1 ? cromoPai[posicaoDeTroca.nextInt(4)]
							: cromoMae[posicaoDeTroca.nextInt(4)];
					cromoFilho += posicaoDeTroca.nextInt(2) == 1 ? cromoPai[posicaoDeTroca.nextInt(4)]
							: cromoMae[posicaoDeTroca.nextInt(4)];
					cromoFilho += posicaoDeTroca.nextInt(2) == 1 ? cromoPai[posicaoDeTroca.nextInt(4)]
							: cromoMae[posicaoDeTroca.nextInt(4)];

					if (posicaoDeTroca.nextInt(200) == 1) {
						String filhoVec[] = fazerVector(cromoFilho, 2, 4);
						cromoFilho = "";

						cromoFilho += filhoVec[posicaoDeTroca.nextInt(2)];
						cromoFilho += filhoVec[posicaoDeTroca.nextInt(2)];
						
					}

					filhos.add(cromoFilho);
				} else {
					String cromoPai[] = fazerVector(pai, 2, 4);
					String cromoMae[] = fazerVector(pai, 2, 4);
					cromoFilho += posicaoDeTroca.nextInt(2) == 1 ? cromoPai[posicaoDeTroca.nextInt(2)]
							: cromoMae[posicaoDeTroca.nextInt(2)];
					cromoFilho += posicaoDeTroca.nextInt(2) == 1 ? cromoPai[posicaoDeTroca.nextInt(2)]
							: cromoMae[posicaoDeTroca.nextInt(2)];

					// mutacao
					if (posicaoDeTroca.nextInt(200) == 1) {
						String filhoVec[] = fazerVector(cromoFilho, 4, 2);
						cromoFilho = "";
						cromoFilho += filhoVec[posicaoDeTroca.nextInt(4)];
						cromoFilho += filhoVec[posicaoDeTroca.nextInt(4)];
						cromoFilho += filhoVec[posicaoDeTroca.nextInt(4)];
						cromoFilho += filhoVec[posicaoDeTroca.nextInt(4)];
					
					}

					filhos.add(cromoFilho);
				}

			}

		filhos = validarPopulacaoFilho(cidadeIncial, cidadeFinal, filhos, cidades);

		return filhos;
	}

	private String[] fazerVector(String cromo, int tamanho, int quebrarEm) {

		int index1 = 0;
		int index2 = quebrarEm;

		String texto[] = new String[tamanho];
		int i = 0;
		while (i < tamanho) {

			texto[i] = cromo.substring(index1, index2);

			index1 += 2;
			index2 += 2;
			i++;
		}

		return texto;
	}

	public void printarVector(Integer vecto[]) {

		for (Integer integer : vecto) {
			System.out.println(integer);
		}

	}

	public List<String> validarPopulacaoFilho(String cidadeInicial, String cidadeFinal, List<String> populacao,
			Map<String, Cidade> cidades) {

		for (int i = populacao.size(); 0 < i; i--) {
			// valida se a cidade pai ta na primeira posicao
			if (!populacao.get(i - 1).substring(0, 1).equals(cidadeInicial)) {
				populacao.remove(i - 1);
				continue;
			}
			// se a cidade final e o ultimo ponto do cromo
			if (!populacao.get(i - 1).substring(7, 8).equals(cidadeFinal)) {
				populacao.remove(i - 1);
				continue;
			}
			// validar se os caminhos sao validos
			char cidadeChar[] = populacao.get(i - 1).toCharArray();
			for (int j = 1; j < cidades.size(); j++) {

				Cidade cidade = cidades.get(String.valueOf(cidadeChar[j - 1]));
				Cidade cidade2 = cidades.get(String.valueOf(cidadeChar[j]));

				if (cidade.equals(cidade2)) {
					continue;
				}

				if (!cidade.getLigaçoes().contains(cidade2)) {
					populacao.remove(i - 1);

					break;
				}

			}
		}

		return populacao;

	}

	public String melhorCaminho(List<String> populacao, Grafo grafo) {
		String cromoComMenorPeso = "";
		int menorPeso = 1000;
		Set<String> listaDeCromoComPesoIgual = new HashSet<>();
		for (int i = 0; i < populacao.size(); i++) {
			String cromoEmAnalise = populacao.get(i);
			int peso = grafo.avaliarPesoCromo(cromoEmAnalise);

			if (peso < menorPeso) {

				cromoComMenorPeso = populacao.get(i);
				menorPeso = peso;
				// listaDeCromoComPesoIgual.clear();
			} else if (peso == menorPeso) {

				if (!cromoComMenorPeso.equals(cromoEmAnalise)) {
					cromoComMenorPeso = populacao.get(i);
					menorPeso = peso;
					listaDeCromoComPesoIgual.add(populacao.get(i));
				}
			}

		}
		return cromoComMenorPeso;
	}

	public void printarVector(String vecto[]) {

		for (String integer : vecto) {
			System.out.println(integer);
		}
	}
}
