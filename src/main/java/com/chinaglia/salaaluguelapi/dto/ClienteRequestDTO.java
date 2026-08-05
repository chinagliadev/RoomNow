package com.chinaglia.salaaluguelapi.dto;

import com.chinaglia.salaaluguelapi.validation.ClienteTipoValido;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;

@ClienteTipoValido
public record ClienteRequestDTO(
		
		@Pattern(
		    regexp = "^\\d{11}$",
		    message = "Telefone deve conter 11 dígitos (DDD + número)"
		)
		String telefone,
		@Valid
		PessoaFisicaRequestDTO pessoaFisicaRequestDTO,
		@Valid
		PessoaJuridicaRequestDTO pessoaJuridicaRequestDTO) {

}
