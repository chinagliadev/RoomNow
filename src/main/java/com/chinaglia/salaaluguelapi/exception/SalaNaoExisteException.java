package com.chinaglia.salaaluguelapi.exception;

public class SalaNaoExisteException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public SalaNaoExisteException(String mensagem) 
	{
		super(mensagem);
	}
	
}
