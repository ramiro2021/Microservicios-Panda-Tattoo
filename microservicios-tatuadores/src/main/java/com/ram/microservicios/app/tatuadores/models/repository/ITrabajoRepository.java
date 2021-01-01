package com.ram.microservicios.app.tatuadores.models.repository;


import org.springframework.data.repository.PagingAndSortingRepository;

import com.ram.microservicios.app.tatuadores.models.entity.Trabajo;

public interface ITrabajoRepository extends PagingAndSortingRepository<Trabajo, Long> {

}
