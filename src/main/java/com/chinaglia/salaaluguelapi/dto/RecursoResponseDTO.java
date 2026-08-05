package com.chinaglia.salaaluguelapi.dto;

import com.chinaglia.salaaluguelapi.entity.Recurso;

public record RecursoResponseDTO(Long id, String nome, String descricao) {
	
	 public RecursoResponseDTO(Recurso recurso) {
        this(recurso.getId(), recurso.getNome(), recurso.getDescricao());
    }
	
}
