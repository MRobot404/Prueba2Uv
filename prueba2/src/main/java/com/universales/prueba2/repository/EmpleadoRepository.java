package com.universales.prueba2.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.universales.prueba2.entity.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Serializable>{

}
