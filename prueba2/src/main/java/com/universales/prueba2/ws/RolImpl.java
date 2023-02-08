package com.universales.prueba2.ws;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.universales.prueba2.entity.Rol;
import com.universales.prueba2.repository.RolRepository;
import com.universales.prueba2.wsint.RolInt;

@Component
public class RolImpl implements RolInt {

	/** Repositorio para acceder a la base de datos de los roles */
	@Autowired
	RolRepository rolRepository;
	
	/**
	
	Método para buscar todos los roles de los empleados.
	@return Lista de objetos Rol.
	*/
	
	@Override
	public List<Rol>buscarRol(){
	return rolRepository.findAll();
	}
	
	/**
	
	Método para guardar un rol de empleado en la base de datos.
	@param Rol objeto Rol a guardar.
	@return objeto Rol guardado.
	*/
	
	@Override
	public Rol guardar(Rol Rol) {
	return rolRepository.save(Rol);
	}
	
	/**
	
	Método para eliminar un rol de empleado de la base de datos.
	@param id_Rol identificador del rol a eliminar.
	*/
	
	@Override
	public void eliminar(Integer id_Rol) {
	Optional <Rol> Rols = rolRepository.findById(id_Rol);
	if(Rols.isPresent()) {
	rolRepository.delete(Rols.get());
	}
	}
	
	/**

	Método para buscar un rol de empleado en la base de datos por su identificador.
	@param idRol identificador del rol a buscar.
	@return Lista de objetos Rol.
	*/
	
	@Override
	public List<Rol>buscarPorIdRol(Integer idRol){
		return rolRepository.findByIdRol(idRol);
	}
	
	/**

	Método para paginar la información de los roles de los empleados.
	@param page número de página a mostrar.
	@param size tamaño de la página.
	@return Lista de objetos Rol.
	*/
	
	@Override
	public List<Rol>getRol(int page,int size){
		Pageable pageable = PageRequest.of(page, size);
		Page<Rol> roles=rolRepository.findAll(pageable);
		return roles.stream().map(rol -> {
			Rol dto=new Rol();
			dto.setIdRol(rol.getIdRol());
			dto.setArea(rol.getArea());
			dto.setRol(rol.getRol());
		return dto;
		}).collect(Collectors.toList());
		
	}
}
