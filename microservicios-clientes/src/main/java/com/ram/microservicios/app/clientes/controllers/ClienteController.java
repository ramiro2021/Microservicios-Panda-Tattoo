package com.ram.microservicios.app.clientes.controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ram.microservicios.app.clientes.models.entity.Cliente;
import com.ram.microservicios.app.clientes.services.IClienteService;
import com.ram.microservicios.commons.controllers.CommonController;

@RestController
public class ClienteController extends CommonController<Cliente, IClienteService> {
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editarCliente(@RequestBody Cliente cliente, @PathVariable Long id){
		
		Optional<Cliente> clienteOptional = service.findOne(id);
		
		if (!clienteOptional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		Cliente clienteDB = clienteOptional.get();
		
		clienteDB.setNombre(cliente.getNombre());
		clienteDB.setApellido(cliente.getApellido());
		clienteDB.setDni(cliente.getDni());
		clienteDB.setActivo(cliente.isActivo());
		
		
		clienteDB.setDomicilio(cliente.getDomicilio());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(clienteDB));
	}
	
}
