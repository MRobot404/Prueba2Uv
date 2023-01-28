package com.universales.prueba2.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoService {

	
	@Autowired
	NamedParameterJdbcTemplate npjt;
	
	public List<Map<String,Object >>buscarporNombre(Integer idRol){
	String query="SELECT c.nombre,c.apellido,a.area,a.rol from rol a join empleado b on a.id_rol = b.id_rol Join usuario c on c.id_usuario = b.id_usuario where a.id_rol= :idRol";
		SqlParameterSource sps= new MapSqlParameterSource()
				.addValue("idRol",idRol );
		return npjt.queryForList(query, sps);
	}
}
