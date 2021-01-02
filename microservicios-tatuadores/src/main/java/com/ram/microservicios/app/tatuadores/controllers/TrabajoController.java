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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ram.microservicios.app.tatuadores.models.entity.Tatuador;
import com.ram.microservicios.app.tatuadores.models.entity.Trabajo;
import com.ram.microservicios.app.tatuadores.services.ITrabajoService;
import com.ram.microservicios.commons.controllers.CommonController;

@RestController
@RequestMapping(path = "/trabajos")
public class TrabajoController extends CommonController<Trabajo, ITrabajoService> {
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody Trabajo trabajo, @PathVariable Long id) {

		Optional<Trabajo> trabajoOptional = service.findOne(id);
		if (!trabajoOptional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		Trabajo trabajoDB = trabajoOptional.get();
		trabajoDB.setTitulo(trabajo.getTitulo());
		trabajoDB.setDescripcion(trabajo.getTitulo());
		trabajoDB.setEstilo(trabajo.getEstilo());
		trabajoDB.setTatuador(trabajo.getTatuador());

			
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(trabajoDB));
	}
	
	
	@PostMapping("/crear-trabajo-con-foto")
	public ResponseEntity<?> crearConFoto(@Valid Trabajo trabajo, BindingResult result,
			@RequestParam MultipartFile archivo) throws IOException {
		if (!archivo.isEmpty()) {
			trabajo.setFoto(archivo.getBytes());
		}
		return super.crear(trabajo, result);
	}
	
	
	@PutMapping("/editar-trabajo-con-foto/{id}")
	public ResponseEntity<?> editarConFoto(@Valid Trabajo trabajo, BindingResult result, @PathVariable Long id,
			@RequestParam MultipartFile archivo) throws IOException {

		if (result.hasErrors()) {
			return this.validar(result);
		}

		Optional<Trabajo> trabajoOptional = service.findOne(id);
		if (!trabajoOptional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		Trabajo trabajoDB = trabajoOptional.get();
		trabajoDB.setTitulo(trabajo.getTitulo());
		trabajoDB.setDescripcion(trabajo.getTitulo());
		if (trabajo.getEstilo() != null && trabajo.getEstilo() != trabajoDB.getEstilo()) {
			
			trabajoDB.setEstilo(trabajo.getEstilo());
		}
		
		if (trabajo.getTatuador() != null && trabajo.getTatuador() != trabajoDB.getTatuador()) {
			
			trabajoDB.setTatuador(trabajo.getTatuador());
		}
			
		
		if (!archivo.isEmpty()) {
			trabajoDB.setFoto(archivo.getBytes());
		}

		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(trabajoDB));

	}
	
	
	@GetMapping("/uploads/trabajo-img/{id}")
	public ResponseEntity<?> verFoto(@PathVariable Long id){
		Optional<Trabajo> trabajoOptional = service.findOne(id);
		
		if (trabajoOptional.isEmpty() || trabajoOptional.get().getFoto() == null) {
			return ResponseEntity.notFound().build();
		}
		
		Resource imagen = new ByteArrayResource(trabajoOptional.get().getFoto());
		
		return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imagen);
	}
}
