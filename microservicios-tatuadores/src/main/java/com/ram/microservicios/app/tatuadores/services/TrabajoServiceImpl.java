package com.ram.microservicios.app.tatuadores.services;



import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ram.microservicios.app.tatuadores.models.repository.ITrabajoRepository;
import com.ram.microservicios.commons.services.CommonServiceImpl;
import com.ram.microservicios.commons.tatuadores.models.entity.Trabajo;

@Service
public class TrabajoServiceImpl extends CommonServiceImpl<Trabajo, ITrabajoRepository> implements ITrabajoService {

	@Override
	@Transactional(readOnly = true)
	public List<Trabajo> findByName(String term) {
		return repository.findByName(term);
	}

	@Override
	public List<Trabajo> findByStyle(String term) {
		return repository.findByStyle(term);
	}



}
