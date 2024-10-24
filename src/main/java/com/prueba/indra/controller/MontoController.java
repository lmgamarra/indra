package com.prueba.indra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.indra.dto.request.MontoDtoRequest;
import com.prueba.indra.dto.response.MontoDtoResponse;
import com.prueba.indra.service.MontoService;

@RestController
public class MontoController {

	@Autowired 
	private MontoService montoService;
	
	@PostMapping("/montos")
    public MontoDtoResponse guardar(@RequestBody MontoDtoRequest monto)
    {
        return montoService.guardar(monto);
    }
		
}
