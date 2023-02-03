package com.talissonmelo.servico.padrao;

import java.io.Serializable;

import com.talissonmelo.modelo.padrao.Padrao;

public interface Servico<T extends Padrao, ID extends Serializable> {
	abstract T buscar(ID id);
	abstract T buscar(String uuid);
	abstract T editar(T entity, ID id);   
	abstract T salvar(T objeto);
    abstract void deletar(ID id);
}
