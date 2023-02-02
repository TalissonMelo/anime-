package com.talissonmelo.modelo.conversao;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.talissonmelo.modelo.Escola;
import com.talissonmelo.modelo.dto.EscolaDto;

@Component
public class EscolaModel {

	@Autowired
	private ModelMapper mapper;

	public Escola paraEscola(EscolaDto dto) {
		return mapper.map(dto, Escola.class);
	}
}
