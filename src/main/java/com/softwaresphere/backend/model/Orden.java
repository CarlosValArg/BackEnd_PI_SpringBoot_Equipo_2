package com.softwaresphere.backend.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Orden {
	private Long id;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	private LocalDate fechaCreacion;
	private String descripcion;
	private static Long total = Long.valueOf(0);
	
	public Orden(String string, String descripcion) {
		this.fechaCreacion = LocalDate.now();
		this.descripcion = descripcion;
		Orden.total++;
		this.id = Orden.total;
	}//constructor
	
	public Orden() {
		Orden.total++;
		id = Orden.total;
	}//constructor

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Orden [id=" + id + ", fechaCreacion=" + fechaCreacion + ", descripcion=" + descripcion + "]";
	}//toString
	
	
	
	

}//class Orden
