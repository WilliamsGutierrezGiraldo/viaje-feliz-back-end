package com.udistrital.viajefeliz.client;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Cliente de prueba para conectar con API's externas
 * 
 * @author wagutierrez
 *
 */
@Service
public class ProductServiceRestClient {
	
	private RestTemplate restTemplate;
	
	private String url = "http://192.168.90.33:6005/productProperties";
	
	public ProductServiceRestClient() {
		this.restTemplate = new RestTemplateBuilder()
				.setConnectTimeout(Duration.ofSeconds(30))
				.setReadTimeout(Duration.ofSeconds(30))
				.build();
	}
	
	public List<Map<String, Object>> invokeProductProperties(Long userId) {
		
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(this.url);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(new MediaType[] {MediaType.APPLICATION_JSON}));
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		Map<String, Object> body = new HashMap<>();
		body.put("userId", userId);
		body.put("productId", 10);
		
		HttpEntity<Map<String, Object>> entity = new HttpEntity<Map<String, Object>>(body, headers);
		
		ParameterizedTypeReference<List<Map<String, Object>>> typeRef = 
				new ParameterizedTypeReference<List<Map<String,Object>>>() {};
		
		ResponseEntity<List<Map<String, Object>>> response = 
				this.restTemplate.exchange(uriBuilder.build().toString(), HttpMethod.POST, entity, typeRef);
		
		System.out.println(response.getBody().toString());
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusCodeValue());
		
		return response.getBody();
		
	}

}
