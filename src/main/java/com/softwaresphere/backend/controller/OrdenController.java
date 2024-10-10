package com.softwaresphere.backend.controller;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.softwaresphere.backend.model.Orden;
import com.softwaresphere.backend.model.Servicio;
import com.softwaresphere.backend.model.Usuario;
import com.softwaresphere.backend.service.OrdenService;
import com.softwaresphere.backend.service.UsuarioService;

@RestController
@RequestMapping(path="/api/ordenes/") //http://localhost:8080/api/ordenes/
public class OrdenController {
		private final OrdenService ordenService;
		
		@Autowired
		public OrdenController(OrdenService ordenService) {		
		this.ordenService = ordenService;
		}//constructor
		
		@GetMapping
		public List<Orden> listaOrdenes() {
		return ordenService.listarOrdenes(); }
		
		@GetMapping(path="{ordenId}")
		public Orden obtenerOrdenPorId(@PathVariable Long id) {
		return ordenService.obtenerOrdenPorId(id); }
		
		@PostMapping
		public Orden guardarOrden(@RequestBody Orden orden) {
		return ordenService.guardarOrden(orden); } 
		
		@DeleteMapping(path="{ordenId}") public Orden eliminarOrden(@PathVariable ("ordenId") Long id) {
		return OrdenService.eliminarOrden(id); }
		
		@PutMapping(path="{ordenId}") // http://localhost:8080/api/productos/1
		 public Orden updateOrden (@PathVariable ("ordenId") Long ordenId,
		         @RequestParam(required=false) String fecha,
		         @RequestParam(required=false) String descripcion) {
		  return ordenService.updateOrden(ordenId, fecha, descripcion);
		 }// updateProducto


}//class UsuarioController

