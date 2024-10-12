package com.softwaresphere.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuario {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="usuarioid", unique=true, nullable=false)
	private Long usuarioid;
	@Column (nullable=false)
	private String nombres;
	private String apellidos;
	@Column (nullable=false)
	private String telefono;
	@Column (nullable=false)
	private String correo;
	@Column (nullable=false)
	private String contrasena;
	
	
	public Usuario(String nombres, String apellidos, String telefono, String correo, String contrasena) {
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.correo = correo;
		this.contrasena = contrasena;
	}//constructor
	
	public Usuario() {
	}//constructor

	public Long getUsuarioid() {
		return usuarioid;
	}

	public void setUsuarioid(Long usuarioid) {
		this.usuarioid = usuarioid;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	@Override
	public String toString() {
		return "Usuario [usuarioid=" + usuarioid + ", nombres=" + nombres + ", apellidos=" + apellidos + ", telefono="
				+ telefono + ", correo=" + correo + ", contrasena=" + contrasena + "]";
	}

	


	
	
	

}//class Usuario
