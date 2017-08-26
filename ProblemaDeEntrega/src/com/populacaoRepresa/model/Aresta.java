package com.populacaoRepresa.model;

public class Aresta {

	private Cidade cidade;
	private int peso;
	

	public Aresta(Cidade cidade, int peso) {
		super();
		this.cidade = cidade;
		this.peso = peso;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

}
