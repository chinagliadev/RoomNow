package com.chinaglia.salaaluguelapi.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.chinaglia.salaaluguelapi.dto.AluguelSalaRequestDTO;
import com.chinaglia.salaaluguelapi.dto.AluguelSalaResponseDTO;
import com.chinaglia.salaaluguelapi.service.AluguelService;

import jakarta.validation.Valid;


@RestController
@RequestMapping(value="/alugarSala")
public class AluguelSalaController {

	
	private final AluguelService aluguelService;
	
	public AluguelSalaController(AluguelService aluguelService) {
		this.aluguelService = aluguelService;
	}

	@PostMapping
	public ResponseEntity<AluguelSalaResponseDTO> save(@RequestBody @Valid AluguelSalaRequestDTO aluguelSalaRequestDTO) 
	{
		AluguelSalaResponseDTO aluguelSalaResponseDTO = aluguelService.save(aluguelSalaRequestDTO);
		URI location = ServletUriComponentsBuilder.fromCurrentRequestUri().path("{id}").buildAndExpand(aluguelSalaResponseDTO.id()).toUri();
		return ResponseEntity.created(location).body(aluguelSalaResponseDTO);
	}
	
	
}
