package com.udistrital.viajefeliz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udistrital.viajefeliz.dao.PersonaDAO;
import com.udistrital.viajefeliz.dto.PersonaDTO;

/**
 * Clase de tipo service para gestionar las operaciones
 * de lógica de negocio del aplicativo
 * 
 * @author wagutierrez
 *
 */
@Service
public class PersonaService {
	
	@Autowired
	private PersonaDAO personaDao;
	
	public PersonaDTO consultarPersonaPorId(String id) {
		return this.personaDao.consultarPersonaPorId(id);
	}
	
	public int guardarPersona(PersonaDTO persona) {
		return this.personaDao.guardarPersona(persona);
	}
	

}
