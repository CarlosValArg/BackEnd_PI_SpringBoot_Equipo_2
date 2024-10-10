package com.softwaresphere.backend.model;

public class Usuario {
	private Long id;
	private String nombres;
	private String apellidos;
	private String telefono;
	private String correo;
	private String contrasena;
	private static Long total = Long.valueOf(0);
	
	
	public Usuario(String nombres, String apellidos, String telefono, String correo, String contrasena) {
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.correo = correo;
		this.contrasena = contrasena;
		Usuario.total++;
		this.id = Usuario.total;
		
	}//constructor
	
	public Usuario() {
		Usuario.total++;
		id = Usuario.total;
	}//constructor

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
		return "Usuario [id=" + id + ", nombres=" + nombres + ", apellidos=" + apellidos + ", telefono=" + telefono
				+ ", correo=" + correo + ", contrasena=" + contrasena + "]";
	}//toString
	
	
	
	

}//class Usuario
