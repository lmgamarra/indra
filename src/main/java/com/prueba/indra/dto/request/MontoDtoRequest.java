package com.prueba.indra.dto.request;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class MontoDtoRequest {

	private BigDecimal monto;
	private String monedaOrigen;
	private String monedaDestino;
	
}
