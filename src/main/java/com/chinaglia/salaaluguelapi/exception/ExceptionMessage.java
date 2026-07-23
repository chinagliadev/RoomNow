package com.chinaglia.salaaluguelapi.exception;

import java.io.Serializable;
import java.time.Instant;

public class ExceptionMessage implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Instant timestamp;
	private Integer status;
	private String mensagem;
	
	public ExceptionMessage() {}

	public ExceptionMessage(Instant timestamp, Integer status, String mensagem) {
		this.timestamp = timestamp;
		this.status = status;
		this.mensagem = mensagem;
	}

	public Instant getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Instant timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	
	
}
