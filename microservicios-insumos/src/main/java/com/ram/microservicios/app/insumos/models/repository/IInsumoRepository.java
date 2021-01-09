package com.ram.microservicios.app.insumos.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ram.microservicios.commons.insumos.models.entity.Insumo;

public interface IInsumoRepository extends PagingAndSortingRepository<Insumo, Long> {
	
	@Query("select i from Insumo i where i.nombre like %?1%")
	public List<Insumo> findByNameInsumo(String term);
	
	@Query("select i from Insumo i where i.categoria.nombreCategoria like %?1%")
	public List<Insumo> findByNameCategory(String term);
	
	
}
