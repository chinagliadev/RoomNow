package com.chinaglia.salaaluguelapi.exception;

public class UsuarioNaoExisteCadastro extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public UsuarioNaoExisteCadastro(String mensagem) 
	{
		super(mensagem);
	}

}


