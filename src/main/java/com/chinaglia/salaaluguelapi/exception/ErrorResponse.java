package com.chinaglia.salaaluguelapi.exception;

import java.util.ArrayList;
import java.util.List;

public class ErrorResponse {
	
	private List<ExceptionMessage> exceptionMessages;
	
	public ErrorResponse() 
	{
		this.exceptionMessages = new ArrayList<>();
	}
	
	public List<ExceptionMessage> getExceptionMessages() {
		return exceptionMessages;
	}
	
	public void addError(ExceptionMessage exceptionMessage) 
	{
		this.exceptionMessages.add(exceptionMessage);
	}

}
