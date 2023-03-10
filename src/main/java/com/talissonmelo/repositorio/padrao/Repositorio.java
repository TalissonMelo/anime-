package com.talissonmelo.repositorio.padrao;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.talissonmelo.modelo.padrao.Padrao;

@NoRepositoryBean
public interface Repositorio<T extends Padrao, ID extends Serializable> extends JpaRepository<T, ID> {

	Optional<T> findByUuid(String uuid);
}