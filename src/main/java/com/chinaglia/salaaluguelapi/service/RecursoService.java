package com.chinaglia.salaaluguelapi.service;

import org.springframework.stereotype.Service;

import com.chinaglia.salaaluguelapi.dto.RecursoRequestDTO;
import com.chinaglia.salaaluguelapi.dto.RecursoResponseDTO;
import com.chinaglia.salaaluguelapi.entity.Recurso;
import com.chinaglia.salaaluguelapi.mapper.RecursoMapper;
import com.chinaglia.salaaluguelapi.repository.RecursoRepository;

@Service
public class RecursoService {
	
	private final RecursoRepository recursoRepository;

	public RecursoService(RecursoRepository recursoRepository) {
		this.recursoRepository = recursoRepository;
	}
	
	public RecursoResponseDTO save(RecursoRequestDTO recursoRequestDTO)
	{
	    RecursoMapper recursoMapper = new RecursoMapper();
	    Recurso recurso = recursoMapper.toEntity(recursoRequestDTO);
	    Recurso salvo = recursoRepository.save(recurso);
	    return recursoMapper.toDto(salvo);
	}
}
