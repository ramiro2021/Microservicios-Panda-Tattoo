package com.ram.microservicios.app.tatuadores.services;



import org.springframework.stereotype.Service;

import com.ram.microservicios.app.tatuadores.models.entity.Trabajo;
import com.ram.microservicios.app.tatuadores.models.repository.ITrabajoRepository;
import com.ram.microservicios.commons.services.CommonServiceImpl;

@Service
public class TrabajoServiceImpl extends CommonServiceImpl<Trabajo, ITrabajoRepository> implements ITrabajoService {



}
