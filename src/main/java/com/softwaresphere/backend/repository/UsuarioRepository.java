package com.softwaresphere.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softwaresphere.backend.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	   Optional<Usuario> findByCorreo(String correo);

}// interface UsuarioRepository
