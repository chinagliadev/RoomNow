package com.chinaglia.salaaluguelapi.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.chinaglia.salaaluguelapi.dto.SalaRecursoRequestDTO;
import com.chinaglia.salaaluguelapi.dto.SalaRequestDTO;
import com.chinaglia.salaaluguelapi.dto.SalaResponseDTO;
import com.chinaglia.salaaluguelapi.entity.Recurso;
import com.chinaglia.salaaluguelapi.entity.Sala;
import com.chinaglia.salaaluguelapi.entity.SalaRecurso;
import com.chinaglia.salaaluguelapi.exception.RecursoNaoExisteException;
import com.chinaglia.salaaluguelapi.exception.SalaNaoExisteException;
import com.chinaglia.salaaluguelapi.mapper.SalaMapper;
import com.chinaglia.salaaluguelapi.repository.RecursoRepository;
import com.chinaglia.salaaluguelapi.repository.SalaRepository;

import jakarta.transaction.Transactional;

@Service
public class SalaService {

	private final SalaRepository salaRepository;
	private final RecursoRepository recursoRepository ;
	
	public SalaService(SalaRepository salaRepository, RecursoRepository recursoRepository) 
	{
		this.salaRepository = salaRepository;
		this.recursoRepository = recursoRepository;
	}
	
	@Transactional
	public SalaResponseDTO salvar(SalaRequestDTO salaRequestDTO) 
	{
		SalaMapper salaMapper = new SalaMapper();
		Sala sala = salaMapper.toEntity(salaRequestDTO);
		
		Set<SalaRecurso> recursos = new HashSet<>();

		for (SalaRecursoRequestDTO salaRecursoRequestDTO : salaRequestDTO.recursos()) {
		    Recurso recurso = recursoRepository.findById(salaRecursoRequestDTO.recursoId()).orElseThrow(() -> new RecursoNaoExisteException("Recurso não encontrado: " + salaRecursoRequestDTO.recursoId()));
		    SalaRecurso salaRecurso = new SalaRecurso(null, sala, recurso, salaRecursoRequestDTO.quantidade());
		    recursos.add(salaRecurso);
		}
		
		sala.atualizarRecursos(recursos);
		
		Sala salaSalva = salaRepository.save(sala);
		
		return salaMapper.toDto(salaSalva);
	}
	
	
	public List<SalaResponseDTO> findAll() {
	    SalaMapper salaMapper = new SalaMapper();
	    
	    List<Sala> salas = salaRepository.findAll();
	    
	    List<SalaResponseDTO> salasResponseDTO = new ArrayList<>();
	    
	    for(Sala sala : salas) 
	    {
	    	SalaResponseDTO salaResponseDTO = salaMapper.toDto(sala);
	    	salasResponseDTO.add(salaResponseDTO);
	    }
	    
	    return salasResponseDTO;
	}
	
	@Transactional
	public SalaResponseDTO update(Long id, SalaRequestDTO salaRequestDTO) 
	{
		 Sala sala = salaRepository.findById(id)
		            .orElseThrow(() -> new SalaNaoExisteException("Sala com o id informado não existe"));
		
		 SalaMapper salaMapper = new SalaMapper();
	
		 sala.setNome(salaRequestDTO.nome());
		 sala.setNumero(salaRequestDTO.numero());
		 sala.setCapacidade(salaRequestDTO.capacidade());
		 sala.setValor_hora(salaRequestDTO.valor());
		 
		 Set<SalaRecurso> SalaRecurso = new HashSet<>();
		 
		 for(SalaRecursoRequestDTO salaRecursoRequest : salaRequestDTO.recursos()) 
		 {
			 Recurso recurso = recursoRepository.findById(salaRecursoRequest.recursoId()).orElseThrow(() -> new RecursoNaoExisteException("Recursos não encontrado"));
			 SalaRecurso salaRecurso = new SalaRecurso(null, sala, recurso, salaRecursoRequest.quantidade());
			 SalaRecurso.add(salaRecurso);
		 }
		 
		 sala.atualizarRecursos(SalaRecurso);
		
		 salaRepository.save(sala);
		 
		 return salaMapper.toDto(sala);
	}
	
	public SalaResponseDTO findById(Long id) 
	{
		Sala sala = salaRepository.findById(id)
	            .orElseThrow(() -> new SalaNaoExisteException("Sala com o id informado não existe"));
		
		SalaMapper salaMapper = new SalaMapper();
		
		return salaMapper.toDto(sala);
	}
	
	public void delete(Long id) {

	    Sala sala = salaRepository.findById(id)
	        .orElseThrow(() ->
	            new SalaNaoExisteException("Sala com id informado não existe"));

	    salaRepository.delete(sala);
	}
	
	public boolean isExistSala(Long id) 
	{
		if(id == null) {return false;}
		
		return salaRepository.existsById(id);
	}
	
}
