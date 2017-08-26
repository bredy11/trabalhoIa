package com.populacaoRepresa.model;

import java.util.ArrayList;

public class Cidade {
	private int numero;
	private String nome;
	private ArrayList<Cidade> liga�oes = new ArrayList<>();
	
	public Cidade(String nome) {
		this.nome= nome;
		
	}
	
	public void inserirCidade(String nome) {
		liga�oes.add(new Cidade(nome));
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Cidade> getLiga�oes() {
		return liga�oes;
	}

	public void setLiga�oes(ArrayList<Cidade> liga�oes) {
		this.liga�oes = liga�oes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((liga�oes == null) ? 0 : liga�oes.hashCode());
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
		for(Cidade cidade : liga�oes) {
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
