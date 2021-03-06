package com.udistrital.viajefeliz.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.udistrital.viajefeliz.dto.ReservaDTO;

/**
 * Clase de acceso a datos que interactúa con la
 * base de datos y la tabla TBL_RESERVA
 * 
 * @author wagutierrez
 *
 */
@Repository
public class ReservaDAO {
	
	private static String FIND_BY_PERSONA_ID = "SELECT R.ID AS id, R.VALOR_PARCIAL AS valorParcial, "
			+ "R.MASCOTA AS mascota, R.FECHA_INICIO AS fechaInicio, "
			+ "R.FECHA_FIN AS fechaFin, R.VALOR_TOTAL AS valorTotal, "
			+ "R.NUMERO_PERSONAS AS numeroPersonas, R.FK_VIVIENDA AS fkVivienda, "
			+ "R.FK_PERSONA AS fkPersona, R.ESTADO AS estado "
			+ "FROM TBL_RESERVA R "
			+ "WHERE FK_PERSONA = ?";
	
	private static String SAVE_RESERVA = "INSERT INTO TBL_RESERVA (VALOR_PARCIAL, MASCOTA, FECHA_INICIO, FECHA_FIN, VALOR_TOTAL, " 
			+"NUMERO_PERSONAS, FK_VIVIENDA, FK_PERSONA, ESTADO) VALUES (?,?,?,?,?,?,?,?,?)";
	
	private static String FIND_BY_VIVIENDA_AND_DATE = "SELECT R.* "
			+ "FROM TBL_RESERVA R "
			+ "WHERE FK_VIVIENDA = ? "
			+ "AND ? BETWEEN R.FECHA_INICIO AND R.FECHA_FIN";
	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<ReservaDTO> consultarReservasPorPersonaId (String idPersona) {
		try {
			return jdbcTemplate.query(FIND_BY_PERSONA_ID, new Object[] {idPersona}, 
					new BeanPropertyRowMapper<>(ReservaDTO.class));
			
		} catch (DataAccessException e) {
			return null;
		}
	}
	
	public int guardarReserva (ReservaDTO reserva) {
		try {
			return this.jdbcTemplate.update(SAVE_RESERVA, 
					reserva.getValorParcial(),
					reserva.getMascota(),
					reserva.getFechaInicio(),
					reserva.getFechaFin(),
					reserva.getValorTotal(),
					reserva.getNumeroPersonas(),
					reserva.getFkVivienda(),
					reserva.getFkPersona(),
					reserva.getEstado());
			
		} catch (DataAccessException e) {
			return -1;
		}
	}
	
	public List<ReservaDTO> consultarReservaPorIdViviendaYFechas (int idVivienda, String fecha) {
		try {
			return jdbcTemplate.query(FIND_BY_VIVIENDA_AND_DATE, new Object[] {idVivienda, fecha}, 
					new BeanPropertyRowMapper<>(ReservaDTO.class));
			
		} catch (DataAccessException e) {
			return null;
		}
	}
	

}
