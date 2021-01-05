package com.ram.microservicios.app.insumos.services;

import java.util.List;

import com.ram.microservicios.app.insumos.models.entity.Insumo;
import com.ram.microservicios.commons.services.ICommonService;

public interface IInsumoService extends ICommonService<Insumo> {
	
	public List<Insumo> findByNameInsumo(String term);
	public List<Insumo> findByNameCategory(String term);
}
