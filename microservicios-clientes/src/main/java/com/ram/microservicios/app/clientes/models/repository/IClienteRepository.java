package com.ram.microservicios.app.clientes.models.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.ram.microservicios.app.clientes.models.entity.Cliente;

public interface IClienteRepository extends PagingAndSortingRepository<Cliente, Long> {

}
