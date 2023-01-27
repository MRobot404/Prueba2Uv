package com.universales.prueba2.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

import com.universales.prueba2.entity.Telefono;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

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

