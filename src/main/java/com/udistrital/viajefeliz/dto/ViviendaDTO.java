package com.udistrital.viajefeliz.dto;

/**
 * Clase de tipo DTO que contiene los datos asociados 
 * a la tabla vivienda
 * 
 * @author wagutierrez
 *
 */
public class ViviendaDTO {
	
	private Long id;
	
	private Long permiteMascotas;
	
	private Long aireAcondicionado;
	
	private Long calefaccion;
	
	private Long numeroBanios;
	
	private Double precioMinimo;
	
	private Long numeroHabitaciones;
	
	private Long tipo;
	
	private String rutaImagen;
	
	private Long numeroPersonas;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPermiteMascotas() {
		return permiteMascotas;
	}

	public void setPermiteMascotas(Long permiteMascotas) {
		this.permiteMascotas = permiteMascotas;
	}

	public Long getAireAcondicionado() {
		return aireAcondicionado;
	}

	public void setAireAcondicionado(Long aireAcondicionado) {
		this.aireAcondicionado = aireAcondicionado;
	}

	public Long getCalefaccion() {
		return calefaccion;
	}

	public void setCalefaccion(Long calefaccion) {
		this.calefaccion = calefaccion;
	}

	public Long getNumeroBanios() {
		return numeroBanios;
	}

	public void setNumeroBanios(Long numeroBanios) {
		this.numeroBanios = numeroBanios;
	}

	public Double getPrecioMinimo() {
		return precioMinimo;
	}

	public void setPrecioMinimo(Double precioMinimo) {
		this.precioMinimo = precioMinimo;
	}

	public Long getNumeroHabitaciones() {
		return numeroHabitaciones;
	}

	public void setNumeroHabitaciones(Long numeroHabitaciones) {
		this.numeroHabitaciones = numeroHabitaciones;
	}

	public Long getTipo() {
		return tipo;
	}

	public void setTipo(Long tipo) {
		this.tipo = tipo;
	}

	public String getRutaImagen() {
		return rutaImagen;
	}

	public void setRutaImagen(String rutaImagen) {
		this.rutaImagen = rutaImagen;
	}

	public Long getNumeroPersonas() {
		return numeroPersonas;
	}

	public void setNumeroPersonas(Long numeroPersonas) {
		this.numeroPersonas = numeroPersonas;
	}
	
}
