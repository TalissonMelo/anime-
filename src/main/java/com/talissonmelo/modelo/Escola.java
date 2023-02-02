package com.talissonmelo.modelo;

import com.talissonmelo.modelo.padrao.Padrao;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Table(name = "escola")
@Entity
public class Escola extends Padrao {
	private static final long serialVersionUID = 1L;

	private String nome;

	public Escola() {
		super();
	}

	public Escola(String nome) {
		super();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
