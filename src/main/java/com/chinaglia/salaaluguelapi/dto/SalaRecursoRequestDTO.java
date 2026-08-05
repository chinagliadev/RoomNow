package com.chinaglia.salaaluguelapi.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record SalaRecursoRequestDTO(
        @NotNull(message = "Informe o recurso")
        Long recursoId,
        @NotNull(message = "Informe a quantidade")
        @Positive(message = "Quantidade deve ser maior que zero")
        Integer quantidade) {
}
