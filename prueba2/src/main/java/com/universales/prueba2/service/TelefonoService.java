package com.universales.prueba2.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import org.springframework.stereotype.Service;

import com.universales.prueba2.entity.Telefono;


@Service
public  class TelefonoService {
	
	@Autowired
	NamedParameterJdbcTemplate npjt;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
  
	public void insertTelefono(Telefono telefono) {
	    jdbcTemplate.update("{call ps_telefono_insertar(?,?,?)}", telefono.getTelefono(), telefono.getExtension(), telefono.getIdUsuario());
	}


}

