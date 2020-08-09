package com.udistrital.viajefeliz.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.udistrital.viajefeliz.dto.PersonaDTO;

/**
 * Clase de acceso a datos que interactúa con la
 * base de datos y la tabla TBL_PERSONA
 * 
 * @author wagutierrez
 *
 */
@Repository
public class PersonaDAO {
	
	private static String FIND_BY_ID = "SELECT P.DOCUMENTO_IDENTIFICACION AS documentoIdentificacion, "
			+ "P.NACIONALIDAD AS nacionalidad, P.NOMBRES AS nombres, "
			+ "P.APELLIDOS AS apellidos, P.DIRECCION AS direccion, P.TELEFONOS AS telefonos "
			+ "FROM TBL_PERSONA P "
			+ "WHERE DOCUMENTO_IDENTIFICACION = ?";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	public PersonaDTO consultarPersonaPorId (String id) {
		try {
			return jdbcTemplate.queryForObject(FIND_BY_ID, new Object[] {id}, 
					new BeanPropertyRowMapper<>(PersonaDTO.class));
			
		} catch (DataAccessException e) {
			return null;
		}
	}

}
