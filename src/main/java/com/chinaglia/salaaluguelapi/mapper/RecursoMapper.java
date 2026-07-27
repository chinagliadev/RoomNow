package com.chinaglia.salaaluguelapi.mapper;

import com.chinaglia.salaaluguelapi.dto.RecursoRequestDTO;
import com.chinaglia.salaaluguelapi.dto.RecursoResponseDTO;
import com.chinaglia.salaaluguelapi.entity.Recurso;

public class RecursoMapper implements BaseMapper<RecursoRequestDTO, RecursoResponseDTO, Recurso> {

	@Override
	public RecursoResponseDTO toDto(Recurso entity) {
		return new RecursoResponseDTO(entity.getId(), entity.getNome(), entity.getDescricao());
	}

	@Override
	public Recurso toEntity(RecursoRequestDTO dto) {
		return new Recurso(null, dto.nome(), dto.descricao());
	}

}
