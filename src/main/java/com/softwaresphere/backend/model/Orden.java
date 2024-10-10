package com.softwaresphere.backend.model;



public class Orden {
	private Long id;
	private String fecha;
	private String descripcion;
	private static Long total = Long.valueOf(0);
	
	public Orden(String fecha, String descripcion) {
		this.fecha = fecha;
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

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Orden [id=" + id + ", fecha=" + fecha + ", descripcion=" + descripcion + "]";
	}//toString
	
	
	
	

}//class Orden
