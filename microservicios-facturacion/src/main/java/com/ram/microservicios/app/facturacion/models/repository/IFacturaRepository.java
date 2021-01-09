package com.ram.microservicios.app.facturacion.models.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.ram.microservicios.app.facturacion.models.entity.Factura;

public interface IFacturaRepository extends PagingAndSortingRepository<Factura, Long> {

}
