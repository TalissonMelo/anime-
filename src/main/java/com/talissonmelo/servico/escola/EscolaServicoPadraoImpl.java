package com.talissonmelo.servico.escola;

import org.springframework.stereotype.Service;

import com.talissonmelo.modelo.Escola;
import com.talissonmelo.repositorio.padrao.Repositorio;
import com.talissonmelo.repositorio.padrao.RepositorioImpl;

@Service
public class EscolaServicoPadraoImpl extends RepositorioImpl<Escola, Long> implements EscolaServicoPadrao {

	public EscolaServicoPadraoImpl(Repositorio<Escola, Long> repositorio) {
		super(repositorio);
	}
}
