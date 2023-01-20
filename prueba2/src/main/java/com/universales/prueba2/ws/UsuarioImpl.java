package com.universales.prueba2.ws;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.universales.prueba2.entity.Usuario;
import com.universales.prueba2.repository.UsuarioRepository;
import com.universales.prueba2.wsint.UsuarioInt;


@Component
public class UsuarioImpl implements UsuarioInt{

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Override
	public List<Usuario>buscarUsuario(){
		return usuarioRepository.findAll();
	}
	
	@Override
	public Usuario guardar(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	@Override
	public void eliminar(Integer id_usuario) {
		Optional <Usuario> usuarios =  usuarioRepository.findById(id_usuario);
		if(usuarios.isPresent()) {
			usuarioRepository.delete(usuarios.get());
		}
		
	}
}
