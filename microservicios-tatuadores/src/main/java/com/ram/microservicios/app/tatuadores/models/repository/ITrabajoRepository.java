package com.ram.microservicios.app.tatuadores.models.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ram.microservicios.commons.tatuadores.models.entity.Trabajo;

public interface ITrabajoRepository extends PagingAndSortingRepository<Trabajo, Long> {
	
	@Query("select t from Trabajo t where t.titulo like %?1%")
	public List<Trabajo> findByName(String term);
	
	
	@Query("select t from Trabajo t where t.estilo.nombre like %?1%")
	public List<Trabajo> findByStyle(String term);
}
