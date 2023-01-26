package com.universales.prueba2.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
	
	@Autowired
	NamedParameterJdbcTemplate npjt;
	
	public List<Map<String,Object >>buscarporNombre(String nombre){
		String query="select * from usuario where nombre = :nom";
		SqlParameterSource sps= new MapSqlParameterSource()
				.addValue("nom", nombre);
		return npjt.queryForList(query, sps);
	}

}
