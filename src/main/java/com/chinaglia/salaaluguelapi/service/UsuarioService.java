package com.chinaglia.salaaluguelapi.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.chinaglia.salaaluguelapi.dto.UsuarioDTO;
import com.chinaglia.salaaluguelapi.entity.Usuario;
import com.chinaglia.salaaluguelapi.exception.CpfJaExisteException;
import com.chinaglia.salaaluguelapi.exception.EmailJaPossuiCadastroException;
import com.chinaglia.salaaluguelapi.mapper.UsuarioMapper;
import com.chinaglia.salaaluguelapi.repository.UsuarioRepository;

@Service
public class UsuarioService {

	private final UsuarioRepository usuarioRepository;
	private final UsuarioMapper usuarioMapper;
	
	public UsuarioService(UsuarioRepository usuarioRepository, UsuarioMapper usuarioMapper) 
	{
		this.usuarioRepository = usuarioRepository;
		this.usuarioMapper = usuarioMapper;
	}
	
	public UsuarioDTO save(UsuarioDTO usuarioDTO) 
	{
		
		if (findByEmail(usuarioDTO.email()) != null) 
		{
			throw new EmailJaPossuiCadastroException("O e-mail inserido já possui cadastro.");
		}
		
		if(usuarioRepository.existsByCpf(usuarioDTO.cpf())) 
		{
			throw new CpfJaExisteException("CPF cadastrado já possui cadastro");
		}
	
		Usuario usuario = usuarioMapper.toEntity(usuarioDTO);
		usuario = usuarioRepository.save(usuario);
		return usuarioMapper.toDto(usuario);
	}
	
	public UserDetails findByEmail(String email) 
	{
		return usuarioRepository.findByEmail(email);
	}
	
	
	
}
