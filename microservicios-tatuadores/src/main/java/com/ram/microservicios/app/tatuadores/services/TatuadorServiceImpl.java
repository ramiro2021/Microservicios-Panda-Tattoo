package com.ram.microservicios.app.tatuadores.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ram.microservicios.app.tatuadores.models.entity.Tatuador;
import com.ram.microservicios.app.tatuadores.models.repository.ITatuadorRepository;
import com.ram.microservicios.commons.services.CommonServiceImpl;

@Service
public class TatuadorServiceImpl extends CommonServiceImpl<Tatuador, ITatuadorRepository> implements ITatuadorService {

	

}
