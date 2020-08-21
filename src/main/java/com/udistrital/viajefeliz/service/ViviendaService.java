package com.udistrital.viajefeliz.service;


import java.util.List;
import java.util.Map;

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
		
		String appId = "";
		String apiSecret = "";
		String channelId = "";
		String namespace = "";
		
		List<Map<String, Object>> productProperties = client.invokeProductProperties(3777L);
		
		if(!productProperties.isEmpty()) {
			for (Map<String, Object> map : productProperties) {
				
				if(map.containsValue("app_id")) {
					appId = (String) map.get("value");
				}
				
				if(map.containsValue("api_secret")) {
					apiSecret = (String) map.get("value");
				}
				
				if(map.containsValue("channel_id")) {
					channelId = (String) map.get("value");
				}
				
				if(map.containsValue("namespace")) {
					namespace = (String) map.get("value");
				}
				
			}
		}
		
		if(!appId.isEmpty() || !apiSecret.isEmpty() || 
				!channelId.isEmpty() || !namespace.isEmpty()) {
			System.out.println("¡Todas las variables son válidas!");
		}
		
//		System.out.println(appId);
//		System.out.println(apiSecret);
//		System.out.println(channelId);
//		System.out.println(namespace);
		
		return  viviendaDao.consultarViviendas();
	}

}
