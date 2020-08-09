package com.udistrital.viajefeliz.dao;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.udistrital.viajefeliz.dto.ViviendaDTO;

/**
 * Clase de acceso a datos que interactúa con la
 * base de datos y la tabla TBL_VIVIENDA
 * 
 * @author wagutierrez
 *
 */
@Repository
public class ViviendaDAO {
	
	private static String FIND_BY_ID = "SELECT V.ID AS id, V.PERMITE_MASCOTAS AS permiteMascotas, "
			+ "V.AIRE_ACONDICIONADO AS aireAcondicionado, V.CALEFACCION AS calefaccion, "
			+ "V.NUMERO_BANIOS AS numeroBanios, V.PRECIO_MINIMO AS precioMinimo, "
			+ "V.NUMERO_HABITACIONES AS numeroHabitaciones, V.TIPO AS tipo, "
			+ "V.RUTA_IMAGEN AS rutaImagen, V.NUMERO_PERSONAS AS numeroPersonas "
			+ "FROM TBL_VIVIENDA V "
			+ "WHERE ID = ?";
	
	private static String FIND_ALL = "SELECT V.ID AS id, V.PERMITE_MASCOTAS AS permiteMascotas, "
			+ "V.AIRE_ACONDICIONADO AS aireAcondicionado, V.CALEFACCION AS calefaccion, "
			+ "V.NUMERO_BANIOS AS numeroBanios, V.PRECIO_MINIMO AS precioMinimo, "
			+ "V.NUMERO_HABITACIONES AS numeroHabitaciones, V.TIPO AS tipo, "
			+ "V.RUTA_IMAGEN AS rutaImagen, V.NUMERO_PERSONAS AS numeroPersonas "
			+ "FROM TBL_VIVIENDA V ";
	
	@Autowired
	private JdbcTemplate jdbcTemplate; // SELECT * FROM TBL_VIVIENDA WHERE TBL_VIVIENDA.ID = ?1;
	
//	@Autowired
//	private NamedParameterJdbcTemplate namedParameterJdbcTemplate; // SELECT * FROM TBL_VIVIENDA WHERE TBL_VIVIENDA.ID = :ID;
	
	/**
	 * Método que consulta la tabla TBL_VIVIENDA
	 * para extraer una vivienda por su PK 
	 * 
	 * @param id
	 * @return ViviendaDTO
	 */
	public ViviendaDTO consultarViviendaPorId(Long id) {
		try {
			return jdbcTemplate.queryForObject(FIND_BY_ID, new Object[] {id}, 
					new BeanPropertyRowMapper<>(ViviendaDTO.class));
			
		} catch (DataAccessException e) {
			return null;
		}
		
	}
	
	/**
	 * Método que extrae todos los registros 
	 * de la tabla TBL_VIVIENDA
	 * 
	 * @return List<ViviendaDTO>
	 */
	public List<ViviendaDTO> consultarViviendas() {
		try {
			return jdbcTemplate.query(FIND_ALL,
					new BeanPropertyRowMapper<ViviendaDTO>(ViviendaDTO.class));
			
		} catch (DataAccessException e) {
			return null;
		}
		
	}

}
