package com.chinaglia.salaaluguelapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RecursoRequestDTO(

		@NotBlank(message = "Nome do recurso não pode ficar em branco")
		String nome,

		@NotBlank(message = "Descrição do recurso não pode ficar em branco")
		@Size(min = 5, max = 255, message = "Descrição do recurso deve ter no minimo 5 caracteres e no maximo 255")
		String descricao) {

}
