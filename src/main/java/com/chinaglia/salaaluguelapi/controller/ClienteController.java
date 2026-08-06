package com.chinaglia.salaaluguelapi.controller;

import com.chinaglia.salaaluguelapi.dto.ClienteResponseDTO;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.chinaglia.salaaluguelapi.dto.ClienteRequestDTO;
import com.chinaglia.salaaluguelapi.service.ClienteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value="/clientes")
public class ClienteController {
	
	private final ClienteService clienteService;
	
	public ClienteController(ClienteService clienteService) 
	{
		this.clienteService = clienteService;
	}
	
	@GetMapping
	public ResponseEntity<List<ClienteResponseDTO>> findAll()
	{
		return ResponseEntity.ok(clienteService.findAll());
	}
	
	@PostMapping
	public ResponseEntity<ClienteResponseDTO> save(@RequestBody @Valid ClienteRequestDTO clienteRequestDTO)
	{
		ClienteResponseDTO clienteResponseDTO = clienteService.save(clienteRequestDTO);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(clienteResponseDTO.id()).toUri();
		
		return ResponseEntity.created(location).body(clienteResponseDTO);
	}
	
}
