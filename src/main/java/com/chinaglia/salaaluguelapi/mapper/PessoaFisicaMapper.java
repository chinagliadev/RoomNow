package com.chinaglia.salaaluguelapi.mapper;

import com.chinaglia.salaaluguelapi.dto.PessoaFisicaRequestDTO;
import com.chinaglia.salaaluguelapi.dto.PessoaFisicaResponseDTO;
import com.chinaglia.salaaluguelapi.entity.PessoaFisica;

public class PessoaFisicaMapper implements BaseMapper<PessoaFisicaRequestDTO, PessoaFisicaResponseDTO, PessoaFisica> {

    @Override
    public PessoaFisicaResponseDTO toDto(PessoaFisica entity) {
        return new PessoaFisicaResponseDTO(
                entity.getCpf(),
                entity.getNome(),
                entity.getRg()
        );
    }

    @Override
    public PessoaFisica toEntity(PessoaFisicaRequestDTO dto) {
        PessoaFisica pessoaFisica = new PessoaFisica();

        pessoaFisica.setCpf(dto.cpf());
        pessoaFisica.setNome(dto.nome());
        pessoaFisica.setRg(dto.rg());

        return pessoaFisica;
    }
}