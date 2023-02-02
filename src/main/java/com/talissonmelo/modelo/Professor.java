package com.talissonmelo.modelo;

import com.talissonmelo.modelo.padrao.Padrao;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Table(name = "professor")
@Entity
public class Professor extends Padrao {
	private static final long serialVersionUID = 1L;

	private Integer numero;
	private String nome;
	private String individualidade;
	private String nomeHeroi;

	@ManyToOne
	@JoinColumn(name = "id_escola")
	private Escola escola;

	public Professor() {
	}

	public Professor(Integer numero, String nome, String individualidade, String nomeHeroi) {
		this.numero = numero;
		this.nome = nome;
		this.individualidade = individualidade;
		this.nomeHeroi = nomeHeroi;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIndividualidade() {
		return individualidade;
	}

	public void setIndividualidade(String individualidade) {
		this.individualidade = individualidade;
	}

	public String getNomeHeroi() {
		return nomeHeroi;
	}

	public void setNomeHeroi(String nomeHeroi) {
		this.nomeHeroi = nomeHeroi;
	}

	public Escola getEscola() {
		return escola;
	}

	public void setEscola(Escola escola) {
		this.escola = escola;
	}
}
