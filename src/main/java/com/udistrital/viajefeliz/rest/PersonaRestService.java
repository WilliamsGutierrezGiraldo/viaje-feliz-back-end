package com.udistrital.viajefeliz.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.udistrital.viajefeliz.dto.PersonaDTO;
import com.udistrital.viajefeliz.service.PersonaService;

@RestController
@RequestMapping(value = "/personas")
@CrossOrigin(origins = "http://localhost:3000", methods = {RequestMethod.GET, RequestMethod.POST})
public class PersonaRestService {
	
	@Autowired
	private PersonaService personaService;
	
	@GetMapping(value = "/personaPorId{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
	public PersonaDTO consultarPersonaPorId (@RequestParam String id) {
		return this.personaService.consultarPersonaPorId(id);
	}
	
	@PostMapping(value = "/guardarPersona")
	public int guardarPersona (@RequestBody PersonaDTO persona) {
		return personaService.guardarPersona(persona);
	}

}
