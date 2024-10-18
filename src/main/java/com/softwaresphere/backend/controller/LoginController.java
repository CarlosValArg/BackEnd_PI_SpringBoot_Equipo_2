package com.softwaresphere.backend.controller;

import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softwaresphere.backend.config.JwtFilter;
import com.softwaresphere.backend.dto.Token;
import com.softwaresphere.backend.model.Usuario;
import com.softwaresphere.backend.service.UsuarioService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping(path="/api/login/")
public class LoginController {
private final UsuarioService usuarioService;
	
	@Autowired
	public LoginController(UsuarioService usuarioService) {
		super();
		this.usuarioService = usuarioService;
	}//constructor


	@PostMapping
	public Token loginUser(@RequestBody Usuario usuario) throws ServletException {
		if(usuarioService.validateUser(usuario)) { 
			System.out.println("Usuario valido" + usuario.getCorreo());
			return new Token(generateToken(usuario.getCorreo()));
		}//if
		throw new ServletException("Nombre de usuario o contraseña incorrectos [" +usuario.getCorreo() + "]");
		}//login


	private String generateToken(String correo) {
		Calendar calendar = Calendar.getInstance();//fecha y hora de hoy
		calendar.add(Calendar.HOUR, 10);//pruebas
		return Jwts.builder().setSubject(correo).claim("role", "user")
				.setIssuedAt(new Date())
				.setExpiration(calendar.getTime())
				.signWith(SignatureAlgorithm.HS256, JwtFilter.secret)//no acentos
				.compact();
	}

}//class LoginController
