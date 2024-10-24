package com.prueba.indra.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prueba.indra.entity.Monto;

@Repository
public interface MontoRepository 
	extends CrudRepository<Monto, Long> {

	
	
}
