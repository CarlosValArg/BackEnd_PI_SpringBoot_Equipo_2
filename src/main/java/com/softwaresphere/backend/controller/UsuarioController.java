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
import org.springframework.web.bind.annotation.RestController;

import com.softwaresphere.backend.dto.ChangePassword;
import com.softwaresphere.backend.model.Usuario;
import com.softwaresphere.backend.service.UsuarioService;

@RestController
@RequestMapping(path="/api/usuarios/") //http://localhost:8080/api/usuarios/
public class UsuarioController {
	private final UsuarioService usuarioService;
	
	@Autowired
	public UsuarioController(UsuarioService usuarioService) {		
	this.usuarioService = usuarioService;
	}//constructor
	
	@GetMapping
	public List<Usuario> listaUsuarios() {
	return usuarioService.listarUsuarios(); }
	
	@GetMapping(path="{userId}")
	public Usuario obtenerUsuarioPorId(@PathVariable Long userId) {
	return usuarioService.obtenerUsuarioPorId(userId); }
	
	@PostMapping
	public Usuario guardarUsuario(@RequestBody Usuario usuario) {
	return usuarioService.guardarUsuario(usuario); } 
	
	@DeleteMapping(path="{userId}") public Usuario eliminarUsuario(@PathVariable ("userId") Long userId) {
	return usuarioService.eliminarUsuario(userId); }
	
	@PutMapping(path="{userId}") // http://localhost:8080/api/usuarios/1
	public Usuario updateUsuario(@RequestBody ChangePassword changepassword,
	
	@PathVariable("userId") Long userId) {
	return usuarioService.updateUsuario(userId, changepassword); 
	}// updateUsuario
	
	

}//class UsuarioController
