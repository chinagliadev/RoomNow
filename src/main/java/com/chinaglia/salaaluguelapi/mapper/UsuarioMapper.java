package com.chinaglia.salaaluguelapi.mapper;

import org.springframework.stereotype.Component;

import com.chinaglia.salaaluguelapi.dto.UsuarioDTO;
import com.chinaglia.salaaluguelapi.entity.Usuario;
import com.chinaglia.salaaluguelapi.enums.UserRole;

@Component
public class UsuarioMapper implements BaseMapper<UsuarioDTO, Usuario>{

	/**
	 * Metodo utilitario para mapear as entity para DTO
	 * @return UsuarioDTO
	 */
	@Override
	public UsuarioDTO toDto(Usuario entity) 
	{
		return new UsuarioDTO(entity.getId(), entity.getNome(), entity.getEmail(), entity.getSenha(), entity.getCpf(), entity.getUserRole());
	}

	/**
	 * Metodo utilitario para mappear os DTO para entity
	 *  @return Usuario (Entity)
	 */
	@Override
	public Usuario toEntity(UsuarioDTO dto) {
	    return new Usuario(dto.nome(), dto.email(), dto.senha(), dto.cpf(), dto.userRole());
	}

}
