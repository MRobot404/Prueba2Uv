package com.universales.prueba2.ws;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;


import com.universales.prueba2.entity.Correo;
import com.universales.prueba2.repository.CorreoRepository;
import com.universales.prueba2.wsint.CorreoInt;

@Component
public class CorreoImpl implements CorreoInt {

	@Autowired
	CorreoRepository correoRepository;
	
	/**
	 * Método para buscar todos los correos electrónicos.
	 * 
	 * @return lista de todos los correos electrónicos
	 */
	
	@Override
	public List<Correo>buscarCorreo(){
		return correoRepository.findAll();
	}
	
	/**
	 * Método para guardar un correo electrónico.
	 * 
	 * @param correo el correo electrónico a guardar
	 * @return el correo electrónico guardado
	 */
	
	@Override
	public Correo guardar(Correo correo) {
		return correoRepository.save(correo);
	}
	
	/**
	 * Método para eliminar un correo electrónico por su ID.
	 * 
	 * @param id_correo el ID del correo electrónico a eliminar
	 */
	
	@Override
	public void eliminar(Integer id_correo) {
		Optional <Correo> correos =  correoRepository.findById(id_correo);
		if(correos.isPresent()) {
			correoRepository.delete(correos.get());
		}
		
	}
	
	/**
	 * Método para buscar un correo electrónico por su ID.
	 * 
	 * @param idCorreo el ID del correo electrónico a buscar
	 * @return lista de correos electrónicos con el ID especificado
	 */
	
	@Override
	public List<Correo>buscarPorIdCorreo(Integer idCorreo){
		return correoRepository.findByIdCorreo(idCorreo);
	}
	
	/**
	 * Método para obtener una página de correos electrónicos.
	 * 
	 * @param page número de página
	 * @param size tamaño de la página
	 * @return lista de correos electrónicos en la página especificada
	 */
	
	@Override
	public List<Correo>getCorreo(int page,int size){
	Pageable pageable=PageRequest.of(page, size);
	Page<Correo> correos=correoRepository.findAll(pageable);
	return correos.stream().map(correo -> {
	Correo dto=new Correo();
	dto.setIdCorreo(correo.getIdCorreo());
	dto.setIdUsuario(correo.getIdUsuario());
	dto.setCorreo(correo.getCorreo());
	return dto;
	}).collect(Collectors.toList());
	}
	
}
