package com.softwaresphere.backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.softwaresphere.backend.model.Servicio;
import com.softwaresphere.backend.model.Usuario;
@Service
public class ServicioService {
	private static final ArrayList<Servicio> lista = new ArrayList<Servicio> ();
	 
	public ServicioService() {
	  lista.add(new Servicio ("Apps Smart Watch",
			  "Los desarrolladores de Software Sphere tenemos amplia experiencia en el desarrollo de aplicaciones smartwatch que combinan funcionalidad avanzada con una experiencia de usuario intuitiva, cotiza una aquí", "https://m.media-amazon.com/images/I/61gpLj2KvTL._AC_SL1500_.jpg", 
			  600.00));
	  }// constructor
	
	public List<Servicio> listarServicios() {
		// TODO Auto-generated method stub
		return lista;
	}



	public Servicio obtenerServicioPorId(Long servId) {
		Servicio serv = null;
		for (Servicio servicio : lista) {
			if(servicio.getId()==servId) {
				serv=servicio;
				break;
			}//if
		}//foreach
		return serv;
	}//obtenerServicioPorId

	public Servicio eliminarServicio(Long servId) {
		Servicio serv = null;
		  for (Servicio servicio : lista) {
		   if (servicio.getId()==servId) {
		    serv = lista.remove(lista.indexOf(servicio));
		    break;
		   }// if
		  }// foreach
		  return serv;
}//eliminarServicio

	public Servicio guardarServicio(Servicio servicio) {
		Servicio serv = null;
		boolean flag = false;
		for(Servicio s : lista) {
			if (s.getNombre().equals(servicio.getNombre())) {
				flag = true;
				break;
			}//if
		}//foreach
		if(! flag) {
			lista.add(servicio);
			serv=servicio;
		}//!flag
		return serv;
	}//guardarServicio

	public Servicio updateServicio(Long servicioId, String nombre, String descripcion, String imagen,
			Double cotizacion) {
		Servicio serv=null;
		for (Servicio servicio : lista) {
			if(servicio.getId()==servicioId) {
				if (nombre != null) servicio.setNombre(nombre);
				if (descripcion != null) servicio.setDescripcion(descripcion); 
				if (imagen != null) servicio.setImagen(imagen);
				if (cotizacion != null) servicio.setCotizacion(cotizacion.doubleValue()); 
				serv=servicio;
				break;
			}//if
		}//foreach
		return serv;
	}//updateServicio




}//class ServicioService
