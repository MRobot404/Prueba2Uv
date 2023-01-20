package com.universales.prueba2.ws;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.universales.prueba2.entity.Correo;
import com.universales.prueba2.repository.CorreoRepository;
import com.universales.prueba2.wsint.CorreoInt;

@Component
public class CorreoImpl implements CorreoInt {

	@Autowired
	CorreoRepository correoRepository;
	
	@Override
	public List<Correo>buscarCorreo(){
		return correoRepository.findAll();
	}
	
	@Override
	public Correo guardar(Correo correo) {
		return correoRepository.save(correo);
	}
	
	@Override
	public void eliminar(Integer id_correo) {
		Optional <Correo> correos =  correoRepository.findById(id_correo);
		if(correos.isPresent()) {
			correoRepository.delete(correos.get());
		}
		
	}

}
