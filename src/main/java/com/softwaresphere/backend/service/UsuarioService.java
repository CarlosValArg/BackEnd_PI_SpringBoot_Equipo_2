package com.softwaresphere.backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.softwaresphere.backend.dto.ChangePassword;
import com.softwaresphere.backend.model.Usuario;

@Service
public class UsuarioService {
	private static final ArrayList<Usuario> lista = new ArrayList<Usuario> ();
	 
	public UsuarioService() {
	  lista.add(new Usuario ("Carlos Mauricio", "Valencia Coronado", "5509752874", "rdiazcastro@me.com", "Pa$$w0rd"));
	  lista.add(new Usuario ("Ulises Miguel", "López Díaz", "5569371043", "Ulimigue@me.com", "Pa$$31454"));
	  }// constructor
	
	 public List<Usuario> listarUsuarios() {
		return lista;
	}//listarUsuarios

	public Usuario obtenerUsuarioPorId(Long userId) {
		Usuario user = null;
		for (Usuario usuario : lista) {
		if (usuario.getId()==userId) {
		user=usuario;
		break;
		}//if
		}//foreach
		return user;
	}//obtenerUsuario

	public Usuario guardarUsuario(Usuario usuario) {
		Usuario user = null;
		boolean flag = false;
		for(Usuario u : lista) {
			if (u.getCorreo().equals(usuario.getCorreo())) {
				flag = true;
				break;
			}//if
		}//foreach
		if(! flag) {
			lista.add(usuario);
			user=usuario;
		}//!flag
		return user;
	}//guardarUsuario
	
		public Usuario eliminarUsuario(Long userId) {
			Usuario user = null;
			  for (Usuario usuario : lista) {
			   if (usuario.getId()==userId) {
			    user = lista.remove(lista.indexOf(usuario));
			    break;
			   }// if
			  }// foreach
			  return user;
	}//eliminarUsuario
		
		public Usuario updateUsuario(Long Id, ChangePassword changePassword) {
			Usuario user = null;
			for (Usuario usuario : lista) {
				if (usuario.getId()==Id) {
					if(usuario.getContrasena().equals(changePassword.getPassword() ) ) {
					    usuario.setContrasena(changePassword.getNewpassword());
						 user=usuario; 
					    }// if
					break;
		    	}//if
			}//foreach
			return user;
		}//updateUsuario
	
	
}//class UsuarioService


