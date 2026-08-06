package com.chinaglia.salaaluguelapi.exception;

public class ClienteNaoExisteException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ClienteNaoExisteException(String mensagem) 
	{
		super(mensagem);
	}
	
}

