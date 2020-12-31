package com.ram.microservicios.app.tatuadores.models.repository;


import org.springframework.data.repository.PagingAndSortingRepository;

import com.ram.microservicios.app.tatuadores.models.entity.Tatuador;

public interface ITatuadorRepository extends PagingAndSortingRepository<Tatuador, Long> {

}
