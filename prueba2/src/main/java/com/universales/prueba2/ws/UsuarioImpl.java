package com.universales.prueba2.ws;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.universales.prueba2.entity.Telefono;
import com.universales.prueba2.entity.Usuario;
import com.universales.prueba2.repository.TelefonoRepository;
import com.universales.prueba2.repository.UsuarioRepository;
import com.universales.prueba2.wsint.UsuarioInt;


@Component
public class UsuarioImpl implements UsuarioInt{

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	TelefonoRepository telefonoRepository;
	
	@Override
	public List<Usuario>buscarUsuario(){
		return usuarioRepository.findAll();
	}
	
	@Override
	public Usuario guardar(Usuario usuario) {
	List<Telefono> telefonos=usuario.getTelefonolist();
	usuario.setTelefonolist(null);
	usuarioRepository.save(usuario);
	for(Telefono tel:telefonos) {
		tel.setIdUsuario(usuario.getIdUsuario());
	}
	
	telefonoRepository.saveAll(telefonos);
	usuario.setTelefonolist(telefonos);
		return usuario;
	}
	
	@Override
	public void eliminar(Integer id_usuario) {
		Optional <Usuario> usuarios =  usuarioRepository.findById(id_usuario);
		if(usuarios.isPresent()) {
			telefonoRepository.deleteAll(usuarios.get().getTelefonolist());
			usuarioRepository.delete(usuarios.get());
		}
		
	}
}
