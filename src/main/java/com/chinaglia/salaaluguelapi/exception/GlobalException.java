package com.chinaglia.salaaluguelapi.exception;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;


@ControllerAdvice
public class GlobalException{
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleValidacao(MethodArgumentNotValidException exception)
	{
	    ErrorResponse errorResponse = new ErrorResponse();

	    exception.getBindingResult().getAllErrors().forEach((error) -> {
	        String errorMessage = error.getDefaultMessage();
	        HttpStatus status = HttpStatus.BAD_REQUEST;

	        errorResponse.addError(new ExceptionMessage(Instant.now(), status.value(), errorMessage));
	    });

	    return ResponseEntity.badRequest().body(errorResponse.getExceptionMessages());
	}
	
	@ExceptionHandler(EmailJaPossuiCadastroException.class)
	public ResponseEntity<List<ExceptionMessage>> handleValidacaoEmail(EmailJaPossuiCadastroException exception)
	{
		String mensagem = exception.getMessage();
		HttpStatus status = HttpStatus.CONFLICT;
		ExceptionMessage exceptionMessage = new ExceptionMessage(Instant.now(), status.value() ,mensagem);
		return ResponseEntity.badRequest().body(List.of(exceptionMessage));
	}
	
	@ExceptionHandler(CpfJaExisteException.class)
	public ResponseEntity<List<ExceptionMessage>> handleValidacaoCPF(CpfJaExisteException exception)
	{
	    String mensagem = exception.getMessage();
	    ExceptionMessage exceptionMessage = new ExceptionMessage(Instant.now(), HttpStatus.BAD_REQUEST.value(), mensagem);
	    return ResponseEntity.badRequest().body(List.of(exceptionMessage));
	}
	
}
