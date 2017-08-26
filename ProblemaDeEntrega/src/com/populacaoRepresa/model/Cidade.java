package com.populacaoRepresa.model;

import java.util.ArrayList;

public class Cidade {
	private int numero;
	private String nome;
	private ArrayList<Cidade> ligaçoes = new ArrayList<>();
	
	public Cidade(String nome) {
		this.nome= nome;
		
	}
	
	public void inserirCidade(String nome) {
		ligaçoes.add(new Cidade(nome));
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Cidade> getLigaçoes() {
		return ligaçoes;
	}

	public void setLigaçoes(ArrayList<Cidade> ligaçoes) {
		this.ligaçoes = ligaçoes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ligaçoes == null) ? 0 : ligaçoes.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cidade other = (Cidade) obj;
	
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		String ligado = "";
		for(Cidade cidade : ligaçoes) {
			 ligado +=cidade.getNome(); 
		}
		
		return nome+"("+(ligado)+")";
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	
	
}
