package com.chinaglia.salaaluguelapi.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record AluguelSalaResponseDTO(

	    Long id,
	    String nomeSala,
	    BigDecimal valorTotal,
	    LocalDateTime dataHoraInicio,
	    LocalDateTime dataHoraFim,
	    boolean status

	) {}