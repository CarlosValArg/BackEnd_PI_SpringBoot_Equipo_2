package com.softwaresphere.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.softwaresphere.backend.dto.ChangePassword;
import com.softwaresphere.backend.model.Servicio;
import com.softwaresphere.backend.model.Usuario;
import com.softwaresphere.backend.service.ServicioService;
import com.softwaresphere.backend.service.UsuarioService;

@RestController
@RequestMapping(path="api/servicios/") //http://localhost:8080/api/servicios/
public class ServicioController {
	private final ServicioService servicioService;
		
		@Autowired
		public ServicioController(ServicioService servicioService) {		
		this.servicioService = servicioService;
		}//constructor
		
		@GetMapping
		public List<Servicio> listaServicio() {
		return servicioService.listarServicios(); }
		
		@GetMapping(path="{serviciosid}")
		public Servicio obtenerServicioPorId(@PathVariable Long serviciosid) {
		return servicioService.obtenerServicioPorId(serviciosid); }
		
		@PostMapping
		public Servicio guardarServicio(@RequestBody Servicio servicio) {
		return servicioService.guardarServicio(servicio); } 
		
		@DeleteMapping(path="{serviciosid}") public Servicio eliminarServicio(@PathVariable ("serviciosid") Long serviciosid) {
		return servicioService.eliminarServicio(serviciosid); }
		
		@PutMapping(path="{serviciosid}") // http://localhost:8080/api/productos/1
		 public Servicio updateServicio (@PathVariable ("serviciosid") Long serviciosid,
		         @RequestParam(required=false) String nombre,
		         @RequestParam(required=false) String descripcion,
		         @RequestParam(required=false) String imagen,
		         @RequestParam(required=false) Double cotizacion) {
		  return servicioService.updateServicio(serviciosid, nombre, descripcion, imagen, cotizacion);
		 }// updateProducto

}
