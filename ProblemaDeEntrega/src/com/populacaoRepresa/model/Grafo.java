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
