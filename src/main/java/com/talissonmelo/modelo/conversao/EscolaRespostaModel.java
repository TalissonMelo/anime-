package com.talissonmelo.modelo.conversao;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.talissonmelo.modelo.Escola;
import com.talissonmelo.modelo.dto.EscolaResposta;

@Component
public class EscolaRespostaModel {

	@Autowired
	private ModelMapper mapper;

	public EscolaResposta paraEscolaResposta(Escola escola) {
		return mapper.map(escola, EscolaResposta.class);
	}
	
	public List<EscolaResposta> paraEscolaRespostas(List<Escola> escolas) {
		return escolas.stream().map((escola) -> this.paraEscolaResposta(escola)).collect(Collectors.toList());
	}
}
