package com.udistrital.viajefeliz.dto;

import java.util.Date;

/**
 * Clase de tipo DTO que contiene los
 * datos asociados a una reserva 
 * 
 * @author wagutierrez
 *
 */
public class ReservaDTO {
	
	private int id;
	
	private double valorParcial;
	
	private int mascota;
	
	private Date fechaInicio;
	
	private Date fechaFin;
	
	private double valorTotal;
	
	private int numeroPersonas;
	
	private int fkVivienda;
	
	private String fkPersona;
	
	private int estado;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getValorParcial() {
		return valorParcial;
	}

	public void setValorParcial(double valorParcial) {
		this.valorParcial = valorParcial;
	}

	public int getMascota() {
		return mascota;
	}

	public void setMascota(int mascota) {
		this.mascota = mascota;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public int getNumeroPersonas() {
		return numeroPersonas;
	}

	public void setNumeroPersonas(int numeroPersonas) {
		this.numeroPersonas = numeroPersonas;
	}

	public int getFkVivienda() {
		return fkVivienda;
	}

	public void setFkVivienda(int fkVivienda) {
		this.fkVivienda = fkVivienda;
	}

	public String getFkPersona() {
		return fkPersona;
	}

	public void setFkPersona(String fkPersona) {
		this.fkPersona = fkPersona;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}
	
}
