package com.chinaglia.salaaluguelapi.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;

public record AluguelSalaRequestDTO(
		
		@NotNull(message = "O cliente é obrigatório")
	    Long clienteId,

	    @NotNull(message = "O usuário é obrigatório")
	    Long usuarioId,

	    @NotNull(message = "A sala é obrigatória")
	    Long salaId,

	    @NotNull(message = "A data/hora de início é obrigatória")
	    LocalDateTime dataHoraInicio,

	    @NotNull(message = "A data/hora de fim é obrigatória")
	    LocalDateTime dataHoraFim
		
		) {

}
