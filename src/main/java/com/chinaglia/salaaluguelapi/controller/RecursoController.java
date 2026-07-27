package com.chinaglia.salaaluguelapi.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.chinaglia.salaaluguelapi.dto.RecursoRequestDTO;
import com.chinaglia.salaaluguelapi.dto.RecursoResponseDTO;
import com.chinaglia.salaaluguelapi.service.RecursoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value="/recursos") 
public class RecursoController 
{
	private final RecursoService recursoService;
	
	public RecursoController(RecursoService recursoService) {
		this.recursoService = recursoService;
	}

	@GetMapping
	public ResponseEntity<List<RecursoResponseDTO>> findAll() 
	{
		return ResponseEntity.ok(recursoService.findAll());
	}
	
	@PostMapping 
	public ResponseEntity<RecursoResponseDTO> insert(@RequestBody @Valid RecursoRequestDTO recursoRequestDTO)
	{
		RecursoResponseDTO recursoResponseDTO = recursoService.save(recursoRequestDTO);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(recursoResponseDTO.id()).toUri();
		
		return ResponseEntity.created(location).body(recursoResponseDTO);
	}
	
	@PutMapping("/{id}") 
	public ResponseEntity<RecursoResponseDTO> update(@PathVariable Long id, @RequestBody @Valid RecursoRequestDTO recursoRequestDTO)
	{
		RecursoResponseDTO recursoResponseDTO = recursoService.update(id, recursoRequestDTO);
		return ResponseEntity.ok(recursoResponseDTO);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<List<RecursoResponseDTO>> delete(@PathVariable Long id)
	{
		List<RecursoResponseDTO> recursosResponseDTO = recursoService.delete(id);
		return ResponseEntity.ok().body(recursosResponseDTO);
	}
	
}