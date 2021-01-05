package com.ram.microservicios.app.clientes.services;


import org.springframework.stereotype.Service;

import com.ram.microservicios.app.clientes.models.entity.Cliente;
import com.ram.microservicios.app.clientes.models.repository.IClienteRepository;
import com.ram.microservicios.commons.services.CommonServiceImpl;

@Service
public class ClienteServiceImpl extends CommonServiceImpl<Cliente, IClienteRepository> implements IClienteService {


}
