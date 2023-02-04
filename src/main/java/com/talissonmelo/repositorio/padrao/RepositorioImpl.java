package com.talissonmelo.repositorio.padrao;

import java.io.Serializable;

import org.springframework.beans.BeanUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;

import com.talissonmelo.modelo.exception.ConflitoEmDelecao;
import com.talissonmelo.modelo.exception.EntidadeNaoEncontrada;
import com.talissonmelo.modelo.padrao.Padrao;
import com.talissonmelo.servico.padrao.Servico;

public abstract class RepositorioImpl<T extends Padrao, ID extends Serializable> implements Servico<T, ID> {

	private Repositorio<T, ID> repositorio;
	
	public RepositorioImpl(Repositorio<T, ID> repositorio) {
		this.repositorio = repositorio;
	}
	
	@Override
	public T buscar(ID id) {
		return repositorio.findById(id).orElseThrow(() -> new EntidadeNaoEncontrada((Long) id));
	}
	
	@Override
	public T buscar(String uuid) {
		return repositorio.findByUuid(uuid).orElseThrow(() -> new EntidadeNaoEncontrada(uuid));
	}

	@Override
	public T editar(T objeto, ID id) {
		T objetoAtualizacao = buscar(id);
		BeanUtils.copyProperties(objeto, objetoAtualizacao, "id", "uuid");
		return salvar(objetoAtualizacao);
	}

	@Override
	public void deletar(ID id) {
		try {
			repositorio.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontrada((Long) id);
		} catch (DataIntegrityViolationException e) {
			throw new ConflitoEmDelecao();
		}
	}

	public T salvar(T objeto) {
		return repositorio.save(objeto);
	}
}
