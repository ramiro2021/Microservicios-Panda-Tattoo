package com.ram.microservicios.app.facturacion.services;


import org.springframework.stereotype.Service;

import com.ram.microservicios.app.facturacion.models.entity.Factura;
import com.ram.microservicios.app.facturacion.models.repository.IFacturaRepository;
import com.ram.microservicios.commons.services.CommonServiceImpl;

@Service
public class FacturaServiceImpl extends CommonServiceImpl<Factura, IFacturaRepository> implements IFacturaService {


}
