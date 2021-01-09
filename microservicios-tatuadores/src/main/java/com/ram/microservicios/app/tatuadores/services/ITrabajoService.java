package com.ram.microservicios.app.tatuadores.services;

import java.util.List;

import com.ram.microservicios.commons.services.ICommonService;
import com.ram.microservicios.commons.tatuadores.models.entity.Trabajo;

public interface ITrabajoService extends ICommonService<Trabajo> {
	
	public List<Trabajo> findByName(String term);
	
	
	public List<Trabajo> findByStyle(String term);
}
