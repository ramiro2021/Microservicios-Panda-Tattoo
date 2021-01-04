package com.ram.microservicios.app.insumos.models.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.ram.microservicios.app.insumos.models.entity.Insumo;

public interface IInsumoRepository extends PagingAndSortingRepository<Insumo, Long> {

}
