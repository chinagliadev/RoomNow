package com.chinaglia.salaaluguelapi.mapper;

import com.chinaglia.salaaluguelapi.dto.PessoaJuridicaRequestDTO;
import com.chinaglia.salaaluguelapi.dto.PessoaJuridicaResponseDTO;
import com.chinaglia.salaaluguelapi.entity.PessoaJuridica;

public class PessoaJuridicaMapper implements BaseMapper<PessoaJuridicaRequestDTO, PessoaJuridicaResponseDTO, PessoaJuridica> {

    @Override
    public PessoaJuridicaResponseDTO toDto(PessoaJuridica entity) {
        return new PessoaJuridicaResponseDTO(
                entity.getCnpj(),
                entity.getRazaoSocial(),
                entity.getNomeFantasia(),
                entity.getInscricaoSocial()
        );
    }

    @Override
    public PessoaJuridica toEntity(PessoaJuridicaRequestDTO dto) {
        PessoaJuridica pessoaJuridica = new PessoaJuridica();

        pessoaJuridica.setCnpj(dto.cnpj());
        pessoaJuridica.setRazaoSocial(dto.razaoSocial());
        pessoaJuridica.setNomeFantasia(dto.nomeFantasia());
        pessoaJuridica.setInscricaoSocial(dto.inscricaoSocial());

        return pessoaJuridica;
    }
}