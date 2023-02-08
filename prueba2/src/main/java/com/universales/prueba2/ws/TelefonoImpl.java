package com.universales.prueba2.ws;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;


import com.universales.prueba2.entity.Telefono;

import com.universales.prueba2.repository.TelefonoRepository;
import com.universales.prueba2.service.TelefonoService;
import com.universales.prueba2.wsint.TelefonoInt;


@Component
public class TelefonoImpl implements TelefonoInt {
	
	 /**
     * Inyección de dependencia del repositorio TelefonoRepository para acceder a la base de datos.
     */
	@Autowired
	TelefonoRepository telefonoRepository;
	
	 /**
     * Inyección de dependencia del servicio TelefonoService para acceder a los métodos del negocio.
     */
	@Autowired
	TelefonoService ps;
	
	 /**
     * Método que busca todos los registros de la entidad Telefono en la base de datos.
     * 
     * @return Lista de objetos Telefono.
     */
	
	@Override
	public List<Telefono>buscarTelefono(){
		return telefonoRepository.findAll();
	}
	
	  /**
     * Método que guarda un registro de la entidad Telefono en la base de datos.
     * 
     * @param telefono Objeto de la entidad Telefono a guardar.
     * @return Objeto de la entidad Telefono guardado.
     */
	
	@Override
	public Telefono guardar(Telefono telefono) {
		return telefonoRepository.save(telefono);
	}
	
	/**
     * Método que elimina un registro de la entidad Telefono en la base de datos.
     * 
     * @param id_telefono Identificador único del registro de la entidad Telefono a eliminar.
     */
	
	@Override
	public void eliminar(Integer id_telefono) {
		Optional <Telefono> telefonos =  telefonoRepository.findById(id_telefono);
		if(telefonos.isPresent()) {
			telefonoRepository.delete(telefonos.get());
		}
		
	}
	
	  /**
     * Método que busca un registro de la entidad Telefono en la base de datos por su identificador único.
     * 
     * @param idTelefono Identificador único del registro de la entidad Telefono a buscar.
     * @return Lista de objetos Telefono encontrados.
     */
	
	@Override
	public List<Telefono>buscarPorIdTelefono(Integer idTelefono){
		return telefonoRepository.findByidTelefono(idTelefono);
	}
	
	/**
	 * Método para insertar un nuevo telefono en la base de datos.
	 *
	 * @param telefono El objeto Telefono a insertar. Debe ser enviado en el cuerpo de la petición.
	 */
	
	@Override
	 public void insertarTelefono(@RequestBody Telefono telefono) {
        ps.insertTelefono(telefono);
   }
	
	/**
	 * Método para obtener una página de telefonos de la base de datos.
	 *
	 * @param page Número de página a obtener (empezando por 0).
	 * @param size Número de elementos por página.
	 * @return La lista de telefonos correspondiente a la página solicitada.
	 */
	
	@Override
	 public List<Telefono>getTelefonos(int page,int size) {
		 Pageable pageable = PageRequest.of(page, size);
		 Page<Telefono> telefonos = telefonoRepository.findAll(pageable);
	        return telefonos.stream().map(telefono -> {
	            Telefono dto = new Telefono();
	            dto.setIdTelefono(telefono.getIdTelefono());
	            dto.setTelefono(telefono.getTelefono());
	            dto.setExtension(telefono.getExtension());
	            dto.setIdUsuario(telefono.getIdUsuario());
	            return dto;
	        }).collect(Collectors.toList());
}
	

}
