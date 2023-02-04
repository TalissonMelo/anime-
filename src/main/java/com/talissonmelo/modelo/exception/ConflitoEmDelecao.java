package com.talissonmelo.modelo.exception;

public class ConflitoEmDelecao extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ConflitoEmDelecao() {
		super("Registro possui persistencia em outra tabela.");
	}
}
