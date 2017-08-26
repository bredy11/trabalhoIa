package com.populacaoRepresa.model;

import java.util.ArrayList;
import java.util.List;

public class Grafo {

	private List<List<Aresta>> adjacencias = new ArrayList<>();
	private int numeroDeVertice;

	public Grafo(int numeroDeVertice) {

		this.setNumeroDeVertice(numeroDeVertice);
		for (int i = 0; i < numeroDeVertice; i++) {
			adjacencias.add(new ArrayList<>());
		}
	}

	public void addAresta(Cidade cidade1, Cidade cidade2, int peso) {

		adjacencias.get(cidade1.getNumero()).add(new Aresta(cidade2, peso));

	}

	public int avaliarPesoCromo(String cromo) {

		int peso = 0;
		for (int i = 0; i < cromo.length() - 1; i++) {
			int cidade1 = Integer.valueOf(cromo.substring(i, i + 1));
			int cidade2 = Integer.valueOf(cromo.substring(i + 1, i + 2));
			if (cidade1 == cidade2) {
				peso += 0;
			} else {
				for (Aresta aresta : adjacencias.get(cidade1)) {
					if (aresta.getCidade().getNumero() == cidade2) {
						peso += aresta.getPeso();
						break;
					}
				}
			}
		}
		return peso;
	}

	public List<List<Aresta>> getAdjacencias() {
		return adjacencias;
	}

	public int getNumeroDeVertice() {
		return numeroDeVertice;
	}

	public void setNumeroDeVertice(int numeroDeVertice) {
		this.numeroDeVertice = numeroDeVertice;
	}

}
