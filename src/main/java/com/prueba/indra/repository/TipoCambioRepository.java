package com.prueba.indra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.prueba.indra.entity.TipoCambio;

@Repository
public interface TipoCambioRepository extends CrudRepository<TipoCambio, Long> {

	@Query("select tc from TipoCambio tc" + " where tc.moneda.id = :id")
	List<TipoCambio> buscar(@Param("id") Long id);

}
