package com.chinaglia.salaaluguelapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/sala")
public class SalaController {

	@GetMapping
	public String getSala() 
	{
		return "Rota acessada com sucesso";
	}
	
}
