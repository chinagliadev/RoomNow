package com.chinaglia.salaaluguelapi.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ClienteTipoValidator.class)
public @interface ClienteTipoValido {

    String message() default "Informe pessoa física ou pessoa jurídica";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}