package com.ram.microservicios.app.clientes.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.ram.microservicios.app.clientes.models.entity.Cliente;
import com.ram.microservicios.app.clientes.services.IClienteService;
import com.ram.microservicios.commons.controllers.CommonController;

@RestController
public class ClienteController extends CommonController<Cliente, IClienteService> {

}
