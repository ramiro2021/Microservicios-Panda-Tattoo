package com.ram.microservicios.app.insumos.services;


import java.util.List;

import org.springframework.stereotype.Service;

import com.ram.microservicios.app.insumos.models.repository.IInsumoRepository;
import com.ram.microservicios.commons.insumos.models.entity.Insumo;
import com.ram.microservicios.commons.services.CommonServiceImpl;

@Service
public class InsumoServiceImpl extends CommonServiceImpl<Insumo, IInsumoRepository> implements IInsumoService {

	@Override
	public List<Insumo> findByNameInsumo(String term) {
		
		return repository.findByNameInsumo(term);
	}

	@Override
	public List<Insumo> findByNameCategory(String term) {
		
		return repository.findByNameCategory(term);
	}


}
