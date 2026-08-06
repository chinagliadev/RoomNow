package com.chinaglia.salaaluguelapi.service;

import org.springframework.stereotype.Service;

import com.chinaglia.salaaluguelapi.dto.AluguelSalaRequestDTO;
import com.chinaglia.salaaluguelapi.dto.AluguelSalaResponseDTO;
import com.chinaglia.salaaluguelapi.entity.AluguelSala;
import com.chinaglia.salaaluguelapi.entity.Cliente;
import com.chinaglia.salaaluguelapi.entity.Sala;
import com.chinaglia.salaaluguelapi.entity.Usuario;
import com.chinaglia.salaaluguelapi.exception.ClienteNaoExisteException;
import com.chinaglia.salaaluguelapi.exception.SalaNaoExisteException;
import com.chinaglia.salaaluguelapi.exception.UsuarioNaoExisteCadastro;
import com.chinaglia.salaaluguelapi.mapper.AluguelSalaMapper;
import com.chinaglia.salaaluguelapi.repository.AluguelSalaRepostiory;
import com.chinaglia.salaaluguelapi.repository.ClienteRepository;
import com.chinaglia.salaaluguelapi.repository.SalaRepository;
import com.chinaglia.salaaluguelapi.repository.UsuarioRepository;

@Service
public class AluguelService {
	
	private final AluguelSalaRepostiory aluguelSalaRepostiory;
	private final ClienteRepository clienteRepository;
	private final UsuarioRepository usuarioRepository;
	private final SalaRepository salaRepository;
	
	public AluguelService(AluguelSalaRepostiory aluguelSalaRepostiory, ClienteRepository clienteRepository,
			UsuarioRepository usuarioRepository, SalaRepository salaRepository) {
		this.aluguelSalaRepostiory = aluguelSalaRepostiory;
		this.clienteRepository = clienteRepository;
		this.usuarioRepository = usuarioRepository;
		this.salaRepository = salaRepository;
	}

	public AluguelSalaResponseDTO save(AluguelSalaRequestDTO aluguelSalaRequestdto) {

	    Cliente cliente = clienteRepository.findById(aluguelSalaRequestdto.clienteId())
	            .orElseThrow(() -> new ClienteNaoExisteException("Cliente informado não existe"));

	    Usuario usuario = usuarioRepository.findById(aluguelSalaRequestdto.usuarioId())
	            .orElseThrow(() -> new UsuarioNaoExisteCadastro("Usuário informado não existe"));

	    Sala sala = salaRepository.findById(aluguelSalaRequestdto.salaId())
	            .orElseThrow(() -> new SalaNaoExisteException("Sala informada não existe"));

	    
	    AluguelSalaMapper aluguelSalaMapper = new AluguelSalaMapper();
	    
	    AluguelSala aluguelSala = aluguelSalaMapper.toEntity(aluguelSalaRequestdto);

	    aluguelSala.setCliente(cliente);
	    aluguelSala.setUsuario(usuario);
	    aluguelSala.setSala(sala);
	    aluguelSala.setStatus(true);
	    aluguelSala.setValor_total(aluguelSala.getValorTotal());

	    AluguelSala aluguelSalvo = aluguelSalaRepostiory.save(aluguelSala);

	    return aluguelSalaMapper.toDto(aluguelSalvo);
	}
	
}
