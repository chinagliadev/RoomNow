package com.chinaglia.salaaluguelapi.dto;

import java.math.BigDecimal;
import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record SalaRequestDTO(
		@NotBlank(message="Informe o numero da sala")
		String numero, 
		@NotBlank(message="Informe o nome da sala")
		String nome, 
		@Positive(message = "Capacidade deve ser maior que zero")
		Integer capacidade, 
		@NotNull(message = "Informe o valor da hora")
		@Positive(message = "Valor da hora deve ser maior que zero")
		BigDecimal valor, 
		@NotEmpty(message = "Informe ao menos um recurso")
		@Valid
        List<SalaRecursoRequestDTO> recursos) 
{

}
