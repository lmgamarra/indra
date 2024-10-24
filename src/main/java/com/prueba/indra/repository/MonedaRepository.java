package com.prueba.indra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.prueba.indra.entity.Moneda;

@Repository
public interface MonedaRepository extends CrudRepository<Moneda, Long> {

	@Query("select m from Moneda m" + " where m.descripcion = :descripcion")
	List<Moneda> buscar(@Param("descripcion") String descripcion);

}
