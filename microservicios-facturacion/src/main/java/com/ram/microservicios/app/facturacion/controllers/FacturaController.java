package com.ram.microservicios.app.facturacion.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.ram.microservicios.app.facturacion.models.entity.Factura;
import com.ram.microservicios.app.facturacion.services.IFacturaService;
import com.ram.microservicios.commons.controllers.CommonController;

@RestController
public class FacturaController extends CommonController<Factura, IFacturaService> {

}
