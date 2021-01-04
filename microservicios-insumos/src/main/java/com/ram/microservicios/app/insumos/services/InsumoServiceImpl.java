package com.ram.microservicios.app.insumos.services;


import org.springframework.stereotype.Service;

import com.ram.microservicios.app.insumos.models.entity.Insumo;
import com.ram.microservicios.app.insumos.models.repository.IInsumoRepository;
import com.ram.microservicios.commons.services.CommonServiceImpl;

@Service
public class InsumoServiceImpl extends CommonServiceImpl<Insumo, IInsumoRepository> implements IInsumoService {


}
