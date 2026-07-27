package com.chinaglia.salaaluguelapi.exception;

public class RecursoNaoExisteException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public RecursoNaoExisteException(String mensagem) 
	{
		super(mensagem);
	}
	
}
