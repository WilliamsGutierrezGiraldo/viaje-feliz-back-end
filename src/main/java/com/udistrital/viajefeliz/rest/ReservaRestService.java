package com.udistrital.viajefeliz.rest;

import java.util.List;

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

import com.udistrital.viajefeliz.dto.ReservaDTO;
import com.udistrital.viajefeliz.service.ReservaService;

@RestController
@RequestMapping(value = "/reservas")
@CrossOrigin(origins = "http://localhost:3000", methods = {RequestMethod.GET, RequestMethod.POST})
public class ReservaRestService {
	
	@Autowired
	private ReservaService reservaService;
	
	@GetMapping(value = "/todas{personaId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ReservaDTO> consultarReservasPorPersonaId (String personaId) {
		return this.reservaService.consultarReservasPorPersonaId(personaId);
	}
	
	@PostMapping(value = "/guardarReserva")
	public int guardarReserva (@RequestBody ReservaDTO reserva) {
		return this.reservaService.guardarReserva(reserva);
	}
	
	@GetMapping(value = "/consultarDisponibilidad{idVivienda}{fecha}")
	public List<ReservaDTO> consultarReservasPorViviendaYFecha (@RequestParam int idVivienda, @RequestParam String fecha) {
		return this.reservaService.consultarReservasPorViviendaYFecha(idVivienda, fecha);
	}

}
