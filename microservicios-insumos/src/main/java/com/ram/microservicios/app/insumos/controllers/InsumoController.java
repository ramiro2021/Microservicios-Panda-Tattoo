package com.ram.microservicios.app.insumos.controllers;

import java.io.IOException;
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

import com.ram.microservicios.app.insumos.models.entity.Insumo;
import com.ram.microservicios.app.insumos.services.IInsumoService;
import com.ram.microservicios.commons.controllers.CommonController;

@RestController
public class InsumoController extends CommonController<Insumo, IInsumoService> {

	@PostMapping("/crear-insumo-con-imagen")
	public ResponseEntity<?> crearInsumoConImg(@Valid Insumo insumo, BindingResult result,
			@RequestParam MultipartFile archivo) throws IOException {
		if (!archivo.isEmpty()) {
			insumo.setFoto(archivo.getBytes());
		}
		return super.crear(insumo, result);
	}

	// actualizar insumo y si tiene una imagen, actualizarla
	@PutMapping("/{id}")
	public ResponseEntity<?> editarInsumo(@Valid Insumo insumo, BindingResult result, @PathVariable Long id,
			@RequestParam MultipartFile archivo) throws IOException {

		if (result.hasErrors()) {
			return this.validar(result);
		}

		Optional<Insumo> insumoOptional = service.findOne(id);

		if (!insumoOptional.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		Insumo insumoDB = insumoOptional.get();

		insumoDB.setNombre(insumo.getNombre());
		insumoDB.setCantidad(insumo.getCantidad());
		insumoDB.setCantidadMinima(insumo.getCantidadMinima());
		insumoDB.setPrecioVenta(insumo.getPrecioVenta());
		insumoDB.setCategoria(insumo.getCategoria());

		if (!archivo.isEmpty()) {
			insumoDB.setFoto(archivo.getBytes());
		}

		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(insumoDB));

	}
	
	// recuperar imagen de insumo de la base de datos
	@GetMapping("/uploads/insumo-img/{id}")
	public ResponseEntity<?> verImgInsumo(@PathVariable Long id){
		Optional<Insumo> insumoOptional = service.findOne(id);
		
		if (insumoOptional.isEmpty() || insumoOptional.get().getFoto() == null) {
			return ResponseEntity.notFound().build();
		}
		
		Resource imagen = new ByteArrayResource(insumoOptional.get().getFoto());
		
		return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imagen);
	}
	

}
