package com.ram.microservicios.app.tatuadores.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.ram.microservicios.app.tatuadores.models.entity.Tatuador;
import com.ram.microservicios.app.tatuadores.services.ITatuadorService;
import com.ram.microservicios.commons.controllers.CommonController;

@RestController
public class TatuadorController extends CommonController<Tatuador, ITatuadorService> {

}
