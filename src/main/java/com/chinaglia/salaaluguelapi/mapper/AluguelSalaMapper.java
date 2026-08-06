package com.chinaglia.salaaluguelapi.mapper;

import com.chinaglia.salaaluguelapi.dto.AluguelSalaRequestDTO;
import com.chinaglia.salaaluguelapi.dto.AluguelSalaResponseDTO;
import com.chinaglia.salaaluguelapi.entity.AluguelSala;

public class AluguelSalaMapper implements BaseMapper<AluguelSalaRequestDTO, AluguelSalaResponseDTO, AluguelSala>{

	public AluguelSalaResponseDTO toDto(AluguelSala aluguel) {
	    return new AluguelSalaResponseDTO(
	        aluguel.getId(),
	        aluguel.getSala().getNome(),
	        aluguel.getValor_total(),
	        aluguel.getData_hora_inicio(),
	        aluguel.getData_hora_fim(),
	        aluguel.isStatus()
	    );
	}
	
	@Override
	public AluguelSala toEntity(AluguelSalaRequestDTO dto) {

	    AluguelSala aluguel = new AluguelSala();

	    aluguel.setData_hora_inicio(dto.dataHoraInicio());
	    aluguel.setData_hora_fim(dto.dataHoraFim());

	    return aluguel;
	}
}
