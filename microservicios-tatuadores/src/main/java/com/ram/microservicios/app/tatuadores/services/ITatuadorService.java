package com.ram.microservicios.app.tatuadores.services;

import java.util.List;

import com.ram.microservicios.app.tatuadores.models.entity.Tatuador;
import com.ram.microservicios.commons.services.ICommonService;

public interface ITatuadorService extends ICommonService<Tatuador> {
	
	public List<Tatuador> findByName(String term);
}
