package com.ram.microservicios.app.tatuadores.services;

import java.util.List;

import com.ram.microservicios.commons.services.ICommonService;
import com.ram.microservicios.commons.tatuadores.models.entity.Tatuador;

public interface ITatuadorService extends ICommonService<Tatuador> {
	
	public List<Tatuador> findByName(String term);
}
