package com.softwaresphere.backend.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softwaresphere.backend.model.Orden;
import com.softwaresphere.backend.model.Servicio;
import com.softwaresphere.backend.repository.OrdenRepository;
import com.softwaresphere.backend.repository.ServicioRepository;

@Service
public class OrdenService {
	public final OrdenRepository ordenRepository;
    @Autowired
    public OrdenService(OrdenRepository ordenRepository) {
		this.ordenRepository = ordenRepository;
	}//constructor
	
    public List<Orden> listarOrdenes() {
		return ordenRepository.findAll();
	}//listarOrdenes

	public Orden obtenerOrdenPorId(Long ordId) {
		return ordenRepository.findById(ordId).orElseThrow(
				()-> new IllegalArgumentException("La orden con el id [" + ordId + "] no existe")
				);
	}//obtenerOrden

	public Orden guardarOrden(Orden orden) {
	    Optional<Orden> ord = ordenRepository.findByDescripcion(orden.getDescripcion());
	    if (ord.isEmpty()) { // No existe la orden
	        // Suponiendo que tienes el id del usuario en algún lado
	        Long usuarioId = orden.getUsuarioid(); // Implementa este método según tu lógica
	        orden.setUsuarioid(usuarioId);
	        return ordenRepository.save(orden);
	    } else {
	        System.out.println("La orden [" + orden.getDescripcion() + "] ya se encuentra registrada");
	        return null;
	    }
	}

	
	public Orden eliminarOrden(Long ordId) {
		Orden ord=null;
		if(ordenRepository.existsById(ordId)) {	
			ord=ordenRepository.findById(ordId).get();
			ordenRepository.deleteById(ordId);
		}//if exists
		return ord;
	}//eliminarOrden

	public Orden updateOrden(Long ordId, LocalDate fecha, String descripcion) {
		Orden ord=null;
		if(ordenRepository.existsById(ordId)) {
			Orden orden = ordenRepository.findById(ordId).get();
				if (fecha != null) orden.setFecha(fecha);
				if (descripcion != null) orden.setDescripcion(descripcion);  
				ordenRepository.save(orden);
				ord=orden;
		}//ifExists
		return ord;
	}//updateServicio
	


}//class OrdenService
