package com.ram.microservicios.app.tatuadores.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ram.microservicios.app.tatuadores.models.entity.Trabajo;
import com.ram.microservicios.app.tatuadores.services.ITrabajoService;
import com.ram.microservicios.commons.controllers.CommonController;

@RestController
@RequestMapping(path = "/trabajos")
public class TrabajoController extends CommonController<Trabajo, ITrabajoService> {

}
