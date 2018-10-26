package com.algaworks.socialbooks.services.exceptions;

public class AutorNaoEncontratoExcpetion extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7757201585932702106L;

	public AutorNaoEncontratoExcpetion(String mensagem) {
		super(mensagem);
	}

	public AutorNaoEncontratoExcpetion(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}
