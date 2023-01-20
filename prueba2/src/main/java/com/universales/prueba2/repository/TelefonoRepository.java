package com.universales.prueba2.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.universales.prueba2.entity.Telefono;

@Repository("telefonoRepository")
public interface TelefonoRepository extends JpaRepository<Telefono, Serializable> {

}
