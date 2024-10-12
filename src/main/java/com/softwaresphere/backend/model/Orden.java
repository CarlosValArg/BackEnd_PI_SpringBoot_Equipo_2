package com.softwaresphere.backend.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="orden")
public class Orden {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ordenid", unique=true, nullable=false)	
	private Long ordenid;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	private LocalDate fecha;
	private String descripcion;
	private Long usuarioid;
	
	
	
	public Orden(LocalDate fecha, String descripcion, Long usuarioid) {
		this.fecha = fecha;
		this.descripcion = descripcion;
		this.usuarioid = usuarioid;
	}

	public Orden() {
	}//constructor

	public Long getOrdenid() {
		return ordenid;
	}

	public void setOrdenid(Long ordenid) {
		this.ordenid = ordenid;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Long getUsuarioid() {
		return usuarioid;
	}

	public void setUsuarioid(Long usuarioid) {
		this.usuarioid = usuarioid;
	}

	@Override
	public String toString() {
		return "Orden [ordenid=" + ordenid + ", fecha=" + fecha + ", descripcion=" + descripcion + ", usuarioid="
				+ usuarioid + "]";
	}

	
	
	
	

}//class Orden
