package com.ram.microservicios.app.tatuadores.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ram.microservicios.app.tatuadores.models.entity.Tatuador;
import com.ram.microservicios.app.tatuadores.models.entity.Trabajo;
import com.ram.microservicios.app.tatuadores.services.ITatuadorService;
import com.ram.microservicios.commons.controllers.CommonController;

@RestController
public class TatuadorController extends CommonController<Tatuador, ITatuadorService> {

	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody Tatuador tatuador, @PathVariable Long id) {

		Optional<Tatuador> tatuadorOptional = service.findOne(id);
		if (!tatuadorOptional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		Tatuador tatuadorDB = tatuadorOptional.get();
		tatuadorDB.setNombre(tatuador.getNombre());
		tatuadorDB.setEdad(tatuador.getEdad());
		
		List<Trabajo> eliminados = new ArrayList<>();
		
		tatuadorDB.getTrabajos().forEach(tdb ->{
			if (!tatuador.getTrabajos().contains(tdb)) {
				eliminados.add(tdb);
			}
		});
		
		eliminados.forEach(t ->{
			tatuadorDB.removeTrabajos(t);
		});
		
		
		tatuadorDB.setTrabajos(tatuador.getTrabajos());
		
		
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(tatuadorDB));
	}
}
