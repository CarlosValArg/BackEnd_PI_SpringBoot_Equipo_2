package com.softwaresphere.backend.model;

public class Servicio {
	private Long id;
	private String nombre;
	private String descripcion;
	private String imagen;
	private Double cotizacion;
	private static Long total = Long.valueOf(0);
	
	public Servicio(String nombre, String descripcion, String imagen, Double cotizacion) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.cotizacion = cotizacion;
		Servicio.total++;
		this.id = Servicio.total;
	}//constructor
	
	public Servicio() {
		Servicio.total++;
		id = Servicio.total;
	}//constructor

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public Double getCotizacion() {
		return cotizacion;
	}

	public void setCotizacion(Double cotizacion) {
		this.cotizacion = cotizacion;
	}

	@Override
	public String toString() {
		return "Servicio [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", imagen=" + imagen
				+ ", cotizacion=" + cotizacion + "]";
	}//toString
	
	

}// class Servicio
