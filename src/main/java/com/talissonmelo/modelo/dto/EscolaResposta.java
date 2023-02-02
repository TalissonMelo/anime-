package com.talissonmelo.modelo.dto;

import org.springframework.hateoas.RepresentationModel;

import com.talissonmelo.modelo.Escola;

public class EscolaResposta extends RepresentationModel<EscolaResposta> {

	private Long id;
	private String nome;
	private String uuid;

	public EscolaResposta() {
	}

	public EscolaResposta(Long id, String nome, String uuid) {
		this.id = id;
		this.nome = nome;
		this.uuid = uuid;
	}



	public static EscolaResposta criar(Escola escola) {
		EscolaResposta escolaResposta = new EscolaResposta(escola.getId(), escola.getNome(), escola.getUuid());
		return escolaResposta;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
}
