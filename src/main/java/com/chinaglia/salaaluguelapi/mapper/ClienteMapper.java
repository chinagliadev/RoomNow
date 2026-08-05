package com.chinaglia.salaaluguelapi.mapper;

import com.chinaglia.salaaluguelapi.dto.ClienteRequestDTO;
import com.chinaglia.salaaluguelapi.dto.ClienteResponseDTO;
import com.chinaglia.salaaluguelapi.entity.Cliente;

public class ClienteMapper implements BaseMapper<ClienteRequestDTO, ClienteResponseDTO, Cliente>{

	    private final PessoaFisicaMapper pessoaFisicaMapper = new PessoaFisicaMapper();
	    private final PessoaJuridicaMapper pessoaJuridicaMapper = new PessoaJuridicaMapper();

	    @Override
	    public ClienteResponseDTO toDto(Cliente entity) {

	        return new ClienteResponseDTO(
	        		entity.getId(),
	                entity.getTelefone(),
	                entity.getPessoaFisica() != null
	                        ? pessoaFisicaMapper.toDto(entity.getPessoaFisica())
	                        : null,
	                entity.getPessoaJuridica() != null
	                        ? pessoaJuridicaMapper.toDto(entity.getPessoaJuridica())
	                        : null
	        );
	    }

	    @Override
	    public Cliente toEntity(ClienteRequestDTO dto) {

	        Cliente cliente = new Cliente();

	        cliente.setTelefone(dto.telefone());

	        if (dto.pessoaFisicaRequestDTO() != null) {
	            cliente.setPessoaFisica(
	                    pessoaFisicaMapper.toEntity(dto.pessoaFisicaRequestDTO())
	            );
	        }

	        if (dto.pessoaJuridicaRequestDTO() != null) {
	            cliente.setPessoaJuridica(
	                    pessoaJuridicaMapper.toEntity(dto.pessoaJuridicaRequestDTO())
	            );
	        }

	        return cliente;
	    }
	}
	
