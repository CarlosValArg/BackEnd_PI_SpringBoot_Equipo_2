package com.softwaresphere.backend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.softwaresphere.backend.dto.ChangePassword;
import com.softwaresphere.backend.model.Usuario;
import com.softwaresphere.backend.repository.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	private PasswordEncoder encoder;
  public final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}//constructor
	
	 public List<Usuario> listarUsuarios() {
		return usuarioRepository.findAll();
	}//listarUsuarios


	public Usuario obtenerUsuarioPorId(Long userId) {
		return usuarioRepository.findById(userId).orElseThrow(
				()-> new IllegalArgumentException("El usuario con el id [" + userId + "] no existe")
				);
	}//obtenerUsuario

	public Usuario guardarUsuario(Usuario usuario) {
		Optional<Usuario> user = usuarioRepository.findByCorreo(usuario.getCorreo());
		  if(user.isEmpty()) { // No existe el email
		   usuario.setContrasena(encoder.encode(usuario.getContrasena()) ); 
		   return usuarioRepository.save(usuario);
		  } else {
		   System.out.println("El usuario [" + usuario.getCorreo()
		     + "] ya se encuentra registrado");
		   return null;
		  } // if isEmpty
		 }// guardarUsuario
	
		public Usuario eliminarUsuario(Long userId) {
			Usuario user=null;
			if(usuarioRepository.existsById(userId)) {	
				user=usuarioRepository.findById(userId).get();
				usuarioRepository.deleteById(userId);
			}//if exists
			return user;
		}//eliminarUsuario
		
		public Usuario updateUsuario(Long userId, ChangePassword changePassword) {
			Usuario user = null;
			if(usuarioRepository.existsById(userId)) {
				Usuario usuario = usuarioRepository.findById(userId).get();
//					if (usuario.getPassword().equals(changePassword.getPassword())) {
					if(encoder.matches(changePassword.getPassword(), usuario.getContrasena())){
					    usuario.setContrasena(encoder.encode(changePassword.getNewpassword()));
//					    usuario.setContrasena(changePassword.getNewpassword());
					    usuarioRepository.save(usuario);
						user=usuario; 
					    }// if
		    	}//if
			return user;
		}//updateUsuario
	
}//class UsuarioService


