package com.chinaglia.salaaluguelapi.dto;

import java.math.BigDecimal;
import java.util.List;

public record SalaResponseDTO(
        Long id,
        String numero,
        String nome,
        Integer capacidade,
        BigDecimal valor,
        boolean status,
        List<SalaRecursoResponseDTO> recursos) {
}
