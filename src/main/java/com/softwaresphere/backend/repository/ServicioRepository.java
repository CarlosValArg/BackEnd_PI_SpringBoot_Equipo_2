package com.softwaresphere.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softwaresphere.backend.model.Servicio;

@Repository
public interface ServicioRepository extends JpaRepository<Servicio, Long>{
	   Optional<Servicio> findByNombre(String nombre);

}// interface ServicioRepository


