package com.ram.microservicios.app.insumos.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.ram.microservicios.app.insumos.models.entity.Insumo;
import com.ram.microservicios.app.insumos.services.IInsumoService;
import com.ram.microservicios.commons.controllers.CommonController;

@RestController
public class InsumoController extends CommonController<Insumo, IInsumoService> {

}
