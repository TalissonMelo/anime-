package com.talissonmelo.modelo.exception;

public class EntidadeNaoEncontrada extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public EntidadeNaoEncontrada(Long id) {
		super("Registro de ID: " + id + ", não encontrado.");
	}
	
	public EntidadeNaoEncontrada(String uuid) {
		super("Registro: " + uuid + ", não encontrado.");
	}
}
