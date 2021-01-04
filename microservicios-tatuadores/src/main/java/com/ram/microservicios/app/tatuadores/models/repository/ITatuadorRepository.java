package com.ram.microservicios.app.tatuadores.models.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ram.microservicios.app.tatuadores.models.entity.Tatuador;

public interface ITatuadorRepository extends PagingAndSortingRepository<Tatuador, Long> {
	
	@Query("select t from Tatuador t where t.nombre like %?1%")
	public List<Tatuador> findByName(String term);
}
