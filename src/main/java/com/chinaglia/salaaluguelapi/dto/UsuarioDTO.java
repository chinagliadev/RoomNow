package com.chinaglia.salaaluguelapi.dto;

import org.hibernate.validator.constraints.br.CPF;

import com.chinaglia.salaaluguelapi.enums.UserRole;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record UsuarioDTO
		(
		
		Long id,
		@NotBlank(message="Campo nome é obrigatorio")
		@Size(min=3, max=30, message="Campo nome deve ter no minimo 3 caracteres e no maximo 30")
		String nome,		
		@NotBlank(message="Campo email é obrigatório")
		@Email(message="Email no formato invalido")
		String email, 
		@NotBlank(message="Campo senha é obrigatorio")
		@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!.]).{8,}$", 
        message = "A senha deve conter pelo menos 8 caracteres, uma letra maiúscula, uma minúscula, um número e um caractere especial.")
		String senha,
		@NotBlank(message="Campo CPF é obrigatorio")
		@CPF(message="CPF informado é invalido")
		String cpf,
		@NotNull(message="O role do usuario deve ser informado")
		UserRole userRole
		
				) {

}
