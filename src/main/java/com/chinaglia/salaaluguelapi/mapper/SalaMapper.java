package com.chinaglia.salaaluguelapi.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.chinaglia.salaaluguelapi.dto.SalaRecursoResponseDTO;
import com.chinaglia.salaaluguelapi.dto.SalaRequestDTO;
import com.chinaglia.salaaluguelapi.dto.SalaResponseDTO;
import com.chinaglia.salaaluguelapi.entity.Sala;

public class SalaMapper implements BaseMapper<SalaRequestDTO, SalaResponseDTO, Sala> {

	@Override
	public SalaResponseDTO toDto(Sala entity) {
	    List<SalaRecursoResponseDTO> recursos = entity.getRecursos().stream()
	            .map(sr -> new SalaRecursoResponseDTO(sr))
	            .collect(Collectors.toList());

	    return new SalaResponseDTO(
	            entity.getId(),
	            entity.getNumero(),
	            entity.getNome(),
	            entity.getCapacidade(),
	            entity.getValor_hora(),
	            entity.isStatus(),
	            recursos);
	}

	@Override
	public Sala toEntity(SalaRequestDTO dto) {
		return new Sala(null, dto.numero(), dto.nome(), dto.capacidade(), dto.valor(), true);
	}
}