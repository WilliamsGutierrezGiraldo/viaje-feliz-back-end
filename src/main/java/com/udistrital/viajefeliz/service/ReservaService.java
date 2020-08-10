package com.udistrital.viajefeliz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udistrital.viajefeliz.dao.ReservaDAO;
import com.udistrital.viajefeliz.dto.ReservaDTO;

@Service
public class ReservaService {
	
	@Autowired
	private ReservaDAO reservaDao;
	
	public List<ReservaDTO> consultarReservasPorPersonaId (String personaId) {
		return this.reservaDao.consultarReservasPorPersonaId(personaId);
	}
	
	public int guardarReserva (ReservaDTO reserva) {
		return this.reservaDao.guardarReserva(reserva);
	}
	
	public List<ReservaDTO> consultarReservasPorViviendaYFecha (int idVivienda, String fecha) {
		return this.reservaDao.consultarReservaPorIdViviendaYFechas(idVivienda, fecha);
	}

}
