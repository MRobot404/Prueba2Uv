package com.universales.prueba2.ws;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.universales.prueba2.entity.Telefono;
import com.universales.prueba2.entity.Usuario;
import com.universales.prueba2.repository.TelefonoRepository;
import com.universales.prueba2.service.TelefonoService;
import com.universales.prueba2.wsint.TelefonoInt;

import jakarta.transaction.Transactional;

@Component
public class TelefonoImpl implements TelefonoInt {
	@Autowired
	TelefonoRepository telefonoRepository;
	
	@Autowired
	TelefonoService ps;
	
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
	

	@Override
	 public void insertarTelefono(@RequestBody Telefono telefono) {
        ps.insertTelefono(telefono);
   }
	
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
