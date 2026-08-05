package com.chinaglia.salaaluguelapi.validation;

import com.chinaglia.salaaluguelapi.dto.ClienteRequestDTO;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ClienteTipoValidator implements ConstraintValidator<ClienteTipoValido, ClienteRequestDTO> {

	@Override
	public boolean isValid(ClienteRequestDTO cliente, ConstraintValidatorContext context) {

	    if (cliente == null) {
	        return true;
	    }

	    boolean temPessoaFisica = cliente.pessoaFisicaRequestDTO() != null;
	    boolean temPessoaJuridica = cliente.pessoaJuridicaRequestDTO() != null;

	    if (temPessoaFisica && temPessoaJuridica) {
	        return false;
	    }

	    if (!temPessoaFisica && !temPessoaJuridica) {
	        return false;
	    }

	    return true;
	}
}