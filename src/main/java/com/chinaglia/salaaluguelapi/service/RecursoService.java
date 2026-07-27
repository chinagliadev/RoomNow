package com.chinaglia.salaaluguelapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.chinaglia.salaaluguelapi.dto.RecursoRequestDTO;
import com.chinaglia.salaaluguelapi.dto.RecursoResponseDTO;
import com.chinaglia.salaaluguelapi.entity.Recurso;
import com.chinaglia.salaaluguelapi.exception.RecursoNaoExisteException;
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
	
	public RecursoResponseDTO update(Long id, RecursoRequestDTO recusroRequestDTO) 
	{
		if(!isExisteRecurso(id)) 
		{
			throw new RecursoNaoExisteException("Recurso com o ID informado não existe");
		}
		
		RecursoMapper recursoMapper = new RecursoMapper();
		Recurso recurso =recursoMapper.toEntity(recusroRequestDTO);
		recurso.setId(id);
		Recurso salvo = recursoRepository.save(recurso); 
		return recursoMapper.toDto(salvo);   
	}
	
	public List<RecursoResponseDTO> findAll()
	{
		RecursoMapper recursoMapper = new RecursoMapper();
		return recursoRepository.findAll().
					stream()
					.map(recurso -> recursoMapper.toDto(recurso)).toList();
	};
	
	public List<RecursoResponseDTO> delete(Long id)
	{
		if(!isExisteRecurso(id)) 
		{
			throw new RecursoNaoExisteException("Recurso com o ID informado não existe");
		}
		
		recursoRepository.deleteById(id);
		return findAll();
	}
	
	public boolean isExisteRecurso(Long id)
	{
	    return recursoRepository.existsById(id);
	}
}
