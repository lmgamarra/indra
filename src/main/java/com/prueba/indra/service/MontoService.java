package com.prueba.indra.service;

import com.prueba.indra.dto.request.MontoDtoRequest;
import com.prueba.indra.dto.response.MontoDtoResponse;

public interface MontoService {
	
	MontoDtoResponse guardar(MontoDtoRequest monto);

}
