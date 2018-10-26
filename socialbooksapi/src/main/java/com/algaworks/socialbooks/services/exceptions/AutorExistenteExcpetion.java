package com.algaworks.socialbooks.services.exceptions;

public class AutorExistenteExcpetion extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8502504663097776703L;

	public AutorExistenteExcpetion(String mensagem) {
		super(mensagem);
	}

	public AutorExistenteExcpetion(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}
