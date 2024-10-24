package com.prueba.indra.dto.response;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class MontoDtoResponse {
	
	private BigDecimal monto;
	private BigDecimal montoConTipoDeCambio;
	private String monedaOrigen;
	private String monedaDestino; 
	private BigDecimal tipoDeCambio;
	
	private String estado;
	private String descripcion;

}
