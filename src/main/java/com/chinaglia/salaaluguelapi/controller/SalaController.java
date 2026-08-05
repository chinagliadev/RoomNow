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

import com.chinaglia.salaaluguelapi.dto.SalaRequestDTO;
import com.chinaglia.salaaluguelapi.dto.SalaResponseDTO;
import com.chinaglia.salaaluguelapi.service.SalaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value="/sala")
public class SalaController {

	private final SalaService salaService;
	
	public SalaController(SalaService salaService) 
	{
		this.salaService = salaService;
	}
	
    @GetMapping 
    public ResponseEntity<List<SalaResponseDTO>> findAll() 
    {
    	return ResponseEntity.ok(salaService.findAll());
    }
	
	@PostMapping
	public ResponseEntity<SalaResponseDTO> salvar(@RequestBody @Valid SalaRequestDTO salaRequestDTO)
	{
		SalaResponseDTO salaResponseDTO = salaService.salvar(salaRequestDTO);
		URI localtion = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(salaResponseDTO.id()).toUri();
		return ResponseEntity.created(localtion).body(salaResponseDTO);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<SalaResponseDTO> update(@RequestBody @Valid SalaRequestDTO salaRequestDTO, @PathVariable Long id)
	{
		return ResponseEntity.ok(salaService.update(id, salaRequestDTO));
	}
	
	@GetMapping("/{id}") 
	public ResponseEntity<SalaResponseDTO> findById(@PathVariable Long id)
	{
		return ResponseEntity.ok(salaService.findById(id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
	    salaService.delete(id);
	    return ResponseEntity.noContent().build();
	}
	
}
