package com.softwaresphere.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softwaresphere.backend.model.Orden;

@Repository
public interface OrdenRepository extends JpaRepository<Orden, Long>{
	   Optional<Orden> findByDescripcion(String descripcion);

}// interface OrdenRepository


