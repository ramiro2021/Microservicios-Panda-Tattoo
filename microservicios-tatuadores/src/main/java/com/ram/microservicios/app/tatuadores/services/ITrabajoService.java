package com.ram.microservicios.app.tatuadores.services;

import java.util.List;


import com.ram.microservicios.app.tatuadores.models.entity.Trabajo;
import com.ram.microservicios.commons.services.ICommonService;

public interface ITrabajoService extends ICommonService<Trabajo> {
	
	public List<Trabajo> findByName(String term);
	
	
	public List<Trabajo> findByStyle(String term);
}
