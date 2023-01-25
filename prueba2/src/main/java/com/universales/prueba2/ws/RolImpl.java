package com.universales.prueba2.ws;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.universales.prueba2.entity.Correo;
import com.universales.prueba2.entity.Rol;
import com.universales.prueba2.repository.RolRepository;
import com.universales.prueba2.wsint.RolInt;

@Component
public class RolImpl implements RolInt {
	@Autowired
	RolRepository rolRepository;
	
	
	@Override
	public List<Rol>buscarRol(){
		return rolRepository.findAll();
	}
	
	@Override
	public Rol guardar(Rol Rol) {
		return rolRepository.save(Rol);
	}
	
	@Override
	public void eliminar(Integer id_Rol) {
		Optional <Rol> Rols =  rolRepository.findById(id_Rol);
		if(Rols.isPresent()) {
			rolRepository.delete(Rols.get());
		}
		
	}
	
	@Override
	public List<Rol>buscarPorIdRol(Integer idRol){
		return rolRepository.findByIdRol(idRol);
	}
}
