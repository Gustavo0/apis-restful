package com.algaworks.socialbooks.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.algaworks.socialbooks.domain.DetalhesErro;
import com.algaworks.socialbooks.services.exceptions.AutorExistenteExcpetion;
import com.algaworks.socialbooks.services.exceptions.AutorNaoEncontratoExcpetion;
import com.algaworks.socialbooks.services.exceptions.LivroNaoEncontradoException;

@ControllerAdvice //É uma anotação auxiliadora, que permite verificar coisas automáticas para a classe RestController
public class ResourceExceptionHandler {

	/*
	 * Sempre que for levantado uma exceção desse tipo, quem vai tratar é essa classe e não mais a classe RestController
	 */
	@ExceptionHandler(LivroNaoEncontradoException.class)
	public ResponseEntity<DetalhesErro> handleLivroNaoEncontradoException(LivroNaoEncontradoException e, HttpServletRequest request){
		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(404L);
		erro.setTitulo("O livro não pode ser encontrado");
		erro.setMensagemDesenvolvedor("http:/erros.socialbooks.com/404");//boa pratica ter uma página que explique os erros
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	
	@ExceptionHandler(AutorExistenteExcpetion.class)
	public ResponseEntity<DetalhesErro> handleAutorExistenteException(AutorExistenteExcpetion e, HttpServletRequest request){
		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(409L);
		erro.setTitulo("O autor já existe.");
		erro.setMensagemDesenvolvedor("http:/erros.socialbooks.com/409");//boa pratica ter uma página que explique os erros
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
	}
	
	@ExceptionHandler(AutorNaoEncontratoExcpetion.class)
	public ResponseEntity<DetalhesErro> handleAutorNaoEncontratoExcpetion(AutorNaoEncontratoExcpetion e, HttpServletRequest request){
		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(404L);
		erro.setTitulo("O autor não pôde ser encontrato.");
		erro.setMensagemDesenvolvedor("http:/erros.socialbooks.com/404");//boa pratica ter uma página que explique os erros
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<DetalhesErro> handleDataIntegrityViolationException(DataIntegrityViolationException e, HttpServletRequest request){
		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(400L);
		erro.setTitulo("Requisição inválida.");
		erro.setMensagemDesenvolvedor("http:/erros.socialbooks.com/400");//boa pratica ter uma página que explique os erros
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}
	
}
