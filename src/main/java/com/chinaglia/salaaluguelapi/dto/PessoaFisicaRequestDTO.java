package com.chinaglia.salaaluguelapi.dto;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record PessoaFisicaRequestDTO
			(
				@NotBlank(message="Campo nome é obrigatorio")
				@Size(min=3, max=30, message="Campo nome deve ter no minimo 3 caracteres e no maximo 30")
				String nome,
				@NotBlank(message="Campo CPF é obrigatorio")
				@CPF(message="CPF informado é invalido")
				String cpf,
				@Pattern(
				        regexp = "\\d{2}\\.\\d{3}\\.\\d{3}-[0-9Xx]",
				        message = "RG inválido"
				    )
				String rg
			) {
	
}
