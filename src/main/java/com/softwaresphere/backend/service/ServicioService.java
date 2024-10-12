package com.softwaresphere.backend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softwaresphere.backend.model.Servicio;
import com.softwaresphere.backend.model.Usuario;
import com.softwaresphere.backend.repository.ServicioRepository;
import com.softwaresphere.backend.repository.UsuarioRepository;
@Service
public class ServicioService {
	public final ServicioRepository servicioRepository;

    @Autowired
    public ServicioService(ServicioRepository servicioRepository) {
		this.servicioRepository = servicioRepository;
	}//constructor
	
    public List<Servicio> listarServicios() {
		return servicioRepository.findAll();
	}//listarServicios



    public Servicio obtenerServicioPorId(Long servId) {
		return servicioRepository.findById(servId).orElseThrow(
				()-> new IllegalArgumentException("El servicio con el id [" + servId + "] no existe")
				);
	}//obtenerServicio

	public Servicio eliminarServicio(Long servId) {
		Servicio serv=null;
		if(servicioRepository.existsById(servId)) {	
			serv=servicioRepository.findById(servId).get();
			servicioRepository.deleteById(servId);
		}//if exists
		return serv;
	}//eliminarServicio

	public Servicio guardarServicio(Servicio servicio) {
		Optional<Servicio> serv = servicioRepository.findByNombre(servicio.getNombre());
		  if(serv.isEmpty()) { // No existe la descripción
//		   usuario.setPassword(encoder.encode(usuario.getPassword()) );
		   return servicioRepository.save(servicio);
		  } else {
		   System.out.println("El servicio [" + servicio.getNombre()
		     + "] ya se encuentra registrado");
		   return null;
		  } // if isEmpty
		 }// guardarServicio
	
	public Servicio updateServicio(Long servId, String nombre, String descripcion, String imagen,
			Double cotizacion) {
		Servicio serv=null;
		if(servicioRepository.existsById(servId)) {
			Servicio servicio = servicioRepository.findById(servId).get();
				if (nombre != null) servicio.setNombre(nombre);
				if (descripcion != null) servicio.setDescripcion(descripcion); 
				if (imagen != null) servicio.setImagen(imagen);
				if (cotizacion != null) servicio.setCotizacion(cotizacion.doubleValue()); 
				servicioRepository.save(servicio);
				serv=servicio;
		}//ifExists
		return serv;
	}//updateServicio




}//class ServicioService
