package com.chinaglia.salaaluguelapi.exception;

public class CpfJaExisteException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public CpfJaExisteException(String mensagem) {
		super(mensagem);
	}
}
