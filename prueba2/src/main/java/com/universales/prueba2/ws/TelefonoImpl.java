package com.universales.prueba2.ws;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.universales.prueba2.entity.Telefono;
import com.universales.prueba2.entity.Usuario;
import com.universales.prueba2.repository.TelefonoRepository;
import com.universales.prueba2.wsint.TelefonoInt;

@Component
public class TelefonoImpl implements TelefonoInt {
	@Autowired
	TelefonoRepository telefonoRepository;
	
	@Override
	public List<Telefono>buscarTelefono(){
		return telefonoRepository.findAll();
	}
	
	@Override
	public Telefono guardar(Telefono telefono) {
		return telefonoRepository.save(telefono);
	}
	
	@Override
	public void eliminar(Integer id_telefono) {
		Optional <Telefono> telefonos =  telefonoRepository.findById(id_telefono);
		if(telefonos.isPresent()) {
			telefonoRepository.delete(telefonos.get());
		}
		
	}
	
	@Override
	public List<Telefono>buscarPorIdTelefono(Integer idTelefono){
		return telefonoRepository.findByidTelefono(idTelefono);
	}
}
