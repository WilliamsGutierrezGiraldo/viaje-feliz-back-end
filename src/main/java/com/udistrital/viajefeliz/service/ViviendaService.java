package com.udistrital.viajefeliz.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udistrital.viajefeliz.client.ProductServiceRestClient;
import com.udistrital.viajefeliz.dao.ViviendaDAO;
import com.udistrital.viajefeliz.dto.ViviendaDTO;

/**
 * Clase de tipo service para gestionar las operaciones
 * de lógica de negocio del aplicativo
 * 
 * @author wagutierrez
 *
 */
@Service
public class ViviendaService {
	
	@Autowired
	private ViviendaDAO viviendaDao;
	
	@Autowired
	private ProductServiceRestClient client;
	
	
	public ViviendaDTO consultarViviendaPorId(Long id) {
		return viviendaDao.consultarViviendaPorId(id);
	}
	
	public List<ViviendaDTO> consultarViviendas() {
		client.invokeProductProperties(3777L);
		return  viviendaDao.consultarViviendas();
	}

}
