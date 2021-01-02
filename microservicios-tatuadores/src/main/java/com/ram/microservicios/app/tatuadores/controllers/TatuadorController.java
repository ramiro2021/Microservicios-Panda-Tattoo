package com.ram.microservicios.app.tatuadores.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
		
		if (tatuador.getTrabajos().size() > 0) {
			tatuadorDB.getTrabajos().forEach(tdb ->{
				if (!tatuador.getTrabajos().contains(tdb)) {
					eliminados.add(tdb);
				}
			});
			
			eliminados.forEach(t ->{
				tatuadorDB.removeTrabajos(t);
			});
			tatuadorDB.setTrabajos(tatuador.getTrabajos());
		}

		
		
		
		
		
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(tatuadorDB));
	}
	
	
	@PostMapping("/crear-tatuador-con-foto")
	public ResponseEntity<?> crearConFoto(@Valid Tatuador tatuador, BindingResult result,
			@RequestParam MultipartFile archivo) throws IOException {
		if (!archivo.isEmpty()) {
			tatuador.setFoto(archivo.getBytes());
		}
		return super.crear(tatuador, result);
	}
	
	
	@PutMapping("/editar-tatuador-con-foto/{id}")
	public ResponseEntity<?> editarConFoto(@Valid Tatuador tatuador, BindingResult result, @PathVariable Long id,
			@RequestParam MultipartFile archivo) throws IOException {

		if (result.hasErrors()) {
			return this.validar(result);
		}

		Optional<Tatuador> tatuadorOptional = service.findOne(id);
		if (tatuadorOptional.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		Tatuador tatuadorDB = tatuadorOptional.get();

		tatuadorDB.setNombre(tatuador.getNombre());
		tatuadorDB.setEdad(tatuador.getEdad());
		
			
		List<Trabajo> eliminados = new ArrayList<>();
		
		if (tatuador.getTrabajos().size() > 0) {
			tatuadorDB.getTrabajos().forEach(tdb ->{
				if (!tatuador.getTrabajos().contains(tdb)) {
					eliminados.add(tdb);
				}
			});
			
			eliminados.forEach(t ->{
				tatuadorDB.removeTrabajos(t);
			});
		
			tatuadorDB.setTrabajos(tatuador.getTrabajos());
		}
		
		
		
		if (!archivo.isEmpty()) {
			tatuadorDB.setFoto(archivo.getBytes());
		}

		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(tatuadorDB));

	}
	
	
		//recuperar imagen de la bd
		@GetMapping("/uploads/tatuador-img/{id}")
		public ResponseEntity<?> verFoto(@PathVariable Long id){
			Optional<Tatuador> tatuadorOptional = service.findOne(id);
			
			if (tatuadorOptional.isEmpty() || tatuadorOptional.get().getFoto() == null) {
				return ResponseEntity.notFound().build();
			}
			
			Resource imagen = new ByteArrayResource(tatuadorOptional.get().getFoto());
			
			return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imagen);
		}
	
}
