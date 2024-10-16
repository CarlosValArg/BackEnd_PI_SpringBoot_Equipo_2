//package com.softwaresphere.backend.model;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//
//@Entity
//@Table(name="servicios_has_orden")
//public class FkOrdenUsuario {
//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@Column(name="usuarioid", unique=true, nullable=false)
//	private Long usuarioid;
//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name = "Orden_usuarioid", referencedColumnName = "usuarioid")
//	List<Usuario> usuarios = new ArrayList<Usuario>();
//	
//	public FkOrdenUsuario(Long usuarioid) {
//		this.usuarioid = usuarioid;
//	}//constructor
//	
//	public FkOrdenUsuario() {}
//
//	public Long getUsuarioid() {
//		return usuarioid;
//	}
//
//	public void setUsuarioid(Long usuarioid) {
//		this.usuarioid = usuarioid;
//	}
//	
//
//	public List<Usuario> getUsuarios() {
//		return usuarios;
//	}
//
//	@Override
//	public String toString() {
//		return "FkOrdenUsuario [usuarioid=" + usuarioid + "]";
//	}
//	
//}//class FkOrdenUsuario
