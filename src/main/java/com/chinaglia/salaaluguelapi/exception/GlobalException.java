package com.chinaglia.salaaluguelapi.exception;

import java.time.Instant;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


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
	
	@ExceptionHandler(RecursoNaoExisteException.class)
	public ResponseEntity<List<ExceptionMessage>> hadleValidacaoRecurso(RecursoNaoExisteException exception)
	{
		String mensagem = exception.getMessage();
	    ExceptionMessage exceptionMessage = new ExceptionMessage(Instant.now(), HttpStatus.BAD_REQUEST.value(), mensagem);
	    return ResponseEntity.badRequest().body(List.of(exceptionMessage));
	}
	
	@ExceptionHandler(SalaNaoExisteException.class)
	public ResponseEntity<List<ExceptionMessage>> hadleValidacaoSala(SalaNaoExisteException exception)
	{
		String mensagem = exception.getMessage();
	    ExceptionMessage exceptionMessage = new ExceptionMessage(Instant.now(), HttpStatus.BAD_REQUEST.value(), mensagem);
	    return ResponseEntity.badRequest().body(List.of(exceptionMessage));
	}
	
	@ExceptionHandler(UsuarioNaoExisteCadastro.class)
	public ResponseEntity<List<ExceptionMessage>> hadleValidacaoUsuario(UsuarioNaoExisteCadastro exception)
	{
		String mensagem = exception.getMessage();
	    ExceptionMessage exceptionMessage = new ExceptionMessage(Instant.now(), HttpStatus.BAD_REQUEST.value(), mensagem);
	      return ResponseEntity.badRequest().body(List.of(exceptionMessage));
	}
	
}
