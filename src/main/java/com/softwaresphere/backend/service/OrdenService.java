package com.softwaresphere.backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.softwaresphere.backend.model.Orden;
import com.softwaresphere.backend.model.Servicio;

@Service
public class OrdenService {
	private static final ArrayList<Orden> lista = new ArrayList<Orden> ();
	 
	public OrdenService() {
	  lista.add(new Orden ("2024-10-09", "referencia a la orden de portafolio web"));
	  }// constructor
	
	public List<Orden> listarOrdenes() {
		return lista;
	}

	public Orden obtenerOrdenPorId(Long ordId) {
		Orden ord = null;
		for (Orden orden : lista) {
			if(orden.getId()==ordId) {
				ord=orden;
				break;
			}//if
		}//foreach
		return ord;
	}//obtenerOrdenPorId

	public Orden guardarOrden(Orden orden) {
		lista.add(orden);
		return orden;
	}
	
	public static Orden eliminarOrden(Long ordId) {
		Orden ord = null;
		  for (Orden orden : lista) {
		   if (orden.getId()==ordId) {
		    ord = lista.remove(lista.indexOf(orden));
		    break;
		   }// if
		  }// foreach
		  return ord;
	}

	public Orden updateOrden(Long ordenId, String fecha, String descripcion) {
		Orden ord=null;
			for (Orden orden : lista) {
				if(orden.getId()==ordenId) {
					if (fecha != null) orden.setFecha(fecha);
					if (descripcion != null) orden.setDescripcion(descripcion); 
					ord=orden;
					break;
				}//if
			}//foreach
			return ord;
		}//updateOrden
	
	
	
	
	
	

	

}
