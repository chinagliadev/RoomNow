package com.chinaglia.salaaluguelapi.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.chinaglia.salaaluguelapi.dto.AuthenticationDTO;
import com.chinaglia.salaaluguelapi.dto.LoginResponseDTO;
import com.chinaglia.salaaluguelapi.dto.UsuarioDTO;
import com.chinaglia.salaaluguelapi.entity.Usuario;
import com.chinaglia.salaaluguelapi.enums.UserRole;
import com.chinaglia.salaaluguelapi.infra.security.TokenService;
import com.chinaglia.salaaluguelapi.repository.UsuarioRepository;
import com.chinaglia.salaaluguelapi.service.UsuarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AutheticationController {

	private final AuthenticationManager authenticationManager;
	
	private final UsuarioService usuarioService;
	
	private final TokenService tokenService;
	
	public AutheticationController(AuthenticationManager authenticationManager, TokenService tokenService, UsuarioService usuarioService)
	{
		this.authenticationManager = authenticationManager;
		this.tokenService = tokenService;
		this.usuarioService = usuarioService;
	}
	
	@PostMapping("/login")
	public ResponseEntity login(@RequestBody @Valid AuthenticationDTO authenticationDTO) 
	{
		UsernamePasswordAuthenticationToken userNamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(authenticationDTO.email(), authenticationDTO.senha());
		var auth = authenticationManager.authenticate(userNamePasswordAuthenticationToken);
		
		var token = tokenService.generatedToken((Usuario) auth.getPrincipal());
		
		return ResponseEntity.ok(new LoginResponseDTO(token));
	}
	
	@PostMapping("/registrar")
	public ResponseEntity registrar(@RequestBody @Valid UsuarioDTO usuarioDTO) 
	{
		
		String encryptPassword = new BCryptPasswordEncoder().encode(usuarioDTO.senha());
		UsuarioDTO usuario = new UsuarioDTO(null,usuarioDTO.nome(), usuarioDTO.email(), encryptPassword, usuarioDTO.cpf(), usuarioDTO.userRole());
		
		UsuarioDTO usuarioDTOCriado = usuarioService.save(usuario);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(usuarioDTOCriado.id()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
}
