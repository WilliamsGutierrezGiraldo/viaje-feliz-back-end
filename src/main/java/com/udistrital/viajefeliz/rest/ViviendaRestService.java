package com.udistrital.viajefeliz.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.udistrital.viajefeliz.dto.ViviendaDTO;
import com.udistrital.viajefeliz.service.ViviendaService;

@RestController
@RequestMapping(value = "/viviendas")
@CrossOrigin(origins = "http://localhost:3000", methods = RequestMethod.GET)
public class ViviendaRestService {
	
	@Autowired
	private ViviendaService viviendaService;
	
	@GetMapping(value = "/todas", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ViviendaDTO> consultarViviendas() {
		return viviendaService.consultarViviendas();
	}
	
	@GetMapping(value = "/viviendaPorId{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ViviendaDTO consultarViviendaPorId(@RequestParam Long id) {
		return viviendaService.consultarViviendaPorId(id);
	}
	
}
