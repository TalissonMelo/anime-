package com.talissonmelo.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;

import com.talissonmelo.modelo.Escola;
import com.talissonmelo.repositorio.padrao.Repositorio;

public interface EscolaRepositorio extends Repositorio<Escola, Long> {

	@Query(nativeQuery = true, value = "select * from escola")
	List<Escola> listarEscolas();

	@Query( nativeQuery = true, value = "select esc.* from escola esc where esc.id = :idEscola")
	Optional<Escola> buscarPorId(Long idEscola);
}
