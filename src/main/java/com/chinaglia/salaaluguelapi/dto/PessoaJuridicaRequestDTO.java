package com.chinaglia.salaaluguelapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record PessoaJuridicaRequestDTO(

    @NotBlank(message = "O CNPJ é obrigatório")
    String cnpj,

    @NotBlank(message = "A razão social é obrigatória")
    @Size(max = 255, message = "A razão social deve ter no máximo 255 caracteres")
    String razaoSocial,

    @NotBlank(message = "O nome fantasia é obrigatório")
    @Size(max = 255, message = "O nome fantasia deve ter no máximo 255 caracteres")
    String nomeFantasia,

    @NotBlank(message = "A inscrição social é obrigatória")
    String inscricaoSocial

) {}
