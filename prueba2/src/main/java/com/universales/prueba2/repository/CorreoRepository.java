package com.universales.prueba2.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.universales.prueba2.entity.Correo;
@Repository("correoRepository")
public interface CorreoRepository extends JpaRepository<Correo, Serializable>{

}
