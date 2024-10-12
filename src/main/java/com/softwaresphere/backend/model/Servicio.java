package com.softwaresphere.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="servicios")
public class Servicio {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="serviciosid", unique=true, nullable=false)	
	private Long serviciosid;
	@Column (nullable=false)
	private String nombre;
	private String descripcion;
	private String imagen;
	private Double cotizacion;
	
	public Servicio(String nombre, String descripcion, String imagen, Double cotizacion) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.cotizacion = cotizacion;
	}//constructor
	
	public Servicio() {
	}//constructor

	public Long getServiciosid() {
		return serviciosid;
	}

	public void setServiciosid(Long serviciosid) {
		this.serviciosid = serviciosid;
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
		return "Servicio [serviciosid=" + serviciosid + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", imagen=" + imagen + ", cotizacion=" + cotizacion + "]";
	}//toString
	
	
	

}// class Servicio
