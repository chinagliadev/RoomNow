package com.chinaglia.salaaluguelapi.service;

import org.springframework.stereotype.Service;

import com.chinaglia.salaaluguelapi.dto.ClienteRequestDTO;
import com.chinaglia.salaaluguelapi.dto.ClienteResponseDTO;
import com.chinaglia.salaaluguelapi.entity.Cliente;
import com.chinaglia.salaaluguelapi.entity.PessoaFisica;
import com.chinaglia.salaaluguelapi.entity.PessoaJuridica;
import com.chinaglia.salaaluguelapi.exception.CpfJaExisteException;
import com.chinaglia.salaaluguelapi.mapper.ClienteMapper;
import com.chinaglia.salaaluguelapi.mapper.PessoaFisicaMapper;
import com.chinaglia.salaaluguelapi.mapper.PessoaJuridicaMapper;
import com.chinaglia.salaaluguelapi.repository.ClienteRepository;
import com.chinaglia.salaaluguelapi.repository.PessoaFisicaRepository;

@Service
public class ClienteService {
	
	private final ClienteRepository clienteRepository;
	private final PessoaFisicaRepository pessoaFisicaRepository;
	
	public ClienteService(ClienteRepository clienteRepository, PessoaFisicaRepository pessoaFisicaRepository) 
	{
		this.clienteRepository = clienteRepository;
		this.pessoaFisicaRepository = pessoaFisicaRepository;
	}
	
	public ClienteResponseDTO save(ClienteRequestDTO clienteRequestDTO) {

	    ClienteMapper clienteMapper = new ClienteMapper();
	    Cliente cliente = clienteMapper.toEntity(clienteRequestDTO);

	    if (clienteRequestDTO.pessoaFisicaRequestDTO() != null) {

	        PessoaFisicaMapper pessoaFisicaMapper = new PessoaFisicaMapper();
	        PessoaFisica pessoaFisica = pessoaFisicaMapper.toEntity(clienteRequestDTO.pessoaFisicaRequestDTO());

	        if(isCPFExiste(pessoaFisica.getCpf()))
	        {
	        	throw new CpfJaExisteException("CPF informado já possui cadastro no sistema.");
	        }
	        
	        pessoaFisica.setCliente(cliente);
	        cliente.setPessoaFisica(pessoaFisica); 
	    }
	    else 
	    {
	    	PessoaJuridicaMapper pessoaJuridicaMapper = new PessoaJuridicaMapper();
	    	PessoaJuridica pessoaJuridica = pessoaJuridicaMapper.toEntity(clienteRequestDTO.pessoaJuridicaRequestDTO());
	    	
	    	pessoaJuridica.setCliente(cliente);
	    	cliente.setPessoaJuridica(pessoaJuridica);
	    }

	    clienteRepository.save(cliente);
	    return clienteMapper.toDto(cliente);
	}
	
	
	  public boolean isCPFExiste(String cpf) 
	  { 
		  if(cpf != null) 
		  {
			  return pessoaFisicaRepository.existsByCpf(cpf);
		  } 
		  
		  return false;
	  }
	 
	
}
