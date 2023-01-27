package com.universales.prueba2.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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
	public Object telefonoRepository;
	
	public List<Map<String, Object>> guardar2(Telefono telefono){
		String query="insert into telefono (telefono,extension,id_usuario) values  (:telefono,:extension,:id_usuario)";
		Integer tel=0,ext=0,idU=0;
		SqlParameterSource sps= new MapSqlParameterSource()
				.addValue("telefono", tel)
				.addValue("extension", ext)
				.addValue("id_usuario", idU);
		return npjt.queryForList(query, sps);
	}

}

