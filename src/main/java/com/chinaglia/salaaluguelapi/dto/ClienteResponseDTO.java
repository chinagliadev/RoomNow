package com.chinaglia.salaaluguelapi.dto;

public record ClienteResponseDTO(
		Long id,
	    String telefone,
	    PessoaFisicaResponseDTO pessoaFisica,
	    PessoaJuridicaResponseDTO pessoaJuridica
	) {
	}
