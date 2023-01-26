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

import jakarta.transaction.Transactional;

@Service
public  class TelefonoService {
	
	@Autowired
	NamedParameterJdbcTemplate npjt;
	
	
	public List<Map<String,Object>>Guardartelefono(Integer telefono,Integer extension,Integer idUsuario){
		String query="insert telefono (telefono,extension,id_usuario) values (:telefono, :extension, :idUsuario)";
		SqlParameterSource sps= new MapSqlParameterSource()
				.addValue("telefono", telefono)
				.addValue("extension", extension)
				.addValue("idUsuario", idUsuario);
		return npjt.queryForList(query, sps);
	}
}

