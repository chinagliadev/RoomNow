package com.chinaglia.salaaluguelapi.dto;

import com.chinaglia.salaaluguelapi.entity.SalaRecurso;

public record SalaRecursoResponseDTO(RecursoResponseDTO recurso, Integer quantidade) {

    public SalaRecursoResponseDTO(SalaRecurso salaRecurso) {
        this(new RecursoResponseDTO(salaRecurso.getRecurso()), salaRecurso.getQuantidade());
    }
}
