package com.talissonmelo.servico;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Service;

import com.talissonmelo.controlador.EscolaControlador;
import com.talissonmelo.modelo.Escola;
import com.talissonmelo.modelo.conversao.EscolaModel;
import com.talissonmelo.modelo.conversao.EscolaRespostaModel;
import com.talissonmelo.modelo.dto.EscolaDto;
import com.talissonmelo.modelo.dto.EscolaResposta;
import com.talissonmelo.modelo.exception.ConflitoEmDelecao;
import com.talissonmelo.modelo.exception.EntidadeNaoEncontrada;
import com.talissonmelo.repositorio.EscolaRepositorio;

import jakarta.validation.Valid;

@Service
public class EscolaServico {

	@Autowired
	private EscolaRepositorio repositorio;
	
	@Autowired
	private EscolaModel escolaModel;
	
	@Autowired
	private EscolaRespostaModel escolaRespostaModel;

	public EscolaResposta salvar(EscolaDto escolaDto) {
		Escola escola = this.escolaModel.paraEscola(escolaDto);
		return this.escolaRespostaModel.paraEscolaResposta(repositorio.save(escola));
	}

	public List<EscolaResposta> listar() {
		return this.escolaRespostaModel.paraEscolaRespostas(repositorio.listarEscolas());
	}

	public List<EscolaResposta> listar(String nome) {
		Escola escola = new Escola();
		escola.setNome(nome);
		Example<Escola> example = Example.of(escola,ExampleMatcher.matching().withIgnoreCase().withStringMatcher(StringMatcher.CONTAINING));
		return this.escolaRespostaModel.paraEscolaRespostas(repositorio.findAll(example));
	}

	public Escola listarPorId(Long id) {
		return  repositorio.buscarPorId(id).orElseThrow(() -> new EntidadeNaoEncontrada(id));
	}

	public void deletar(Long id) {
		try {
			repositorio.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontrada(id);
		} catch (DataIntegrityViolationException e) {
			throw new ConflitoEmDelecao();
		}
	}

	public EscolaResposta atualizar(Long id, @Valid EscolaDto escolaDto) {
		Escola escola = repositorio.buscarPorId(id).orElseThrow(() -> new EntidadeNaoEncontrada(id));
		BeanUtils.copyProperties(escolaDto, escola, "id");
		return this.escolaRespostaModel.paraEscolaResposta(repositorio.save(escola));
	}

	public void addLink(List<EscolaResposta> escolaRespostas) {
		escolaRespostas.forEach(resposta -> {
			resposta.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EscolaControlador.class).listarPorId(resposta.getId())).withSelfRel());
			resposta.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EscolaControlador.class).listar()).withRel("escolas"));
		});
	}
}
