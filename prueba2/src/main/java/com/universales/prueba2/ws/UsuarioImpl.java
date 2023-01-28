package com.universales.prueba2.ws;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;


import com.universales.prueba2.entity.Correo;
import com.universales.prueba2.entity.Empleado;
import com.universales.prueba2.entity.Telefono;
import com.universales.prueba2.entity.Usuario;
import com.universales.prueba2.repository.CorreoRepository;
import com.universales.prueba2.repository.EmpleadoRepository;
import com.universales.prueba2.repository.TelefonoRepository;
import com.universales.prueba2.repository.UsuarioRepository;
import com.universales.prueba2.service.UsuarioService;
import com.universales.prueba2.wsint.UsuarioInt;




@Component
public class UsuarioImpl implements UsuarioInt{

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	TelefonoRepository telefonoRepository;
	
	@Autowired
	CorreoRepository correoRepository;
	
	@Autowired
	EmpleadoRepository empleadoRepository;
	
	@Autowired(required=true)
	UsuarioService ps;
	
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
	
	List<Correo> correos=usuario.getCorreolist();
	usuario.setCorreolist(null);
	usuarioRepository.save(usuario);
	for(Correo cor:correos) {
		cor.setIdUsuario(usuario.getIdUsuario());
	}
	
	correoRepository.saveAll(correos);
	usuario.setCorreolist(correos);
	
	List<Empleado> empleados=usuario.getEmpleadolist();
	usuario.setEmpleadolist(null);
	usuarioRepository.save(usuario);
	for(Empleado emp:empleados) {
		emp.setIdUsuario(usuario.getIdUsuario());
	}
	
	empleadoRepository.saveAll(empleados);
	usuario.setCorreolist(correos);
		return usuario;
	}
	
	@Override
	public void eliminar(Integer id_usuario) {
		Optional <Usuario> usuarios =  usuarioRepository.findById(id_usuario);
		if(usuarios.isPresent()) {
			telefonoRepository.deleteAll(usuarios.get().getTelefonolist());
			correoRepository.deleteAll(usuarios.get().getCorreolist());
			empleadoRepository.deleteAll(usuarios.get().getEmpleadolist());
			usuarioRepository.delete(usuarios.get());
		}
		
	}

	@Override
	public List<Usuario>buscarPorNombreYApellido(String nombre, String apellido){
		return usuarioRepository.findByNombreAndApellido(nombre, apellido);
	}
	
	@Override
	public List<Usuario>buscarPorIdUsuario(Integer idUsuario){
		return usuarioRepository.findByidUsuario(idUsuario);
	}
	@Override
	public List<Usuario>buscarPorFecha(Date fecha){
		return usuarioRepository.findByFechaAfter(fecha);
	}

	@Override
	public List<Map<String, Object>> buscarporNombre(String nombre) {
		// TODO Auto-generated method stub
		return ps.buscarporNombre(nombre);
	}
	
	@Override
	public List<Usuario>getUsuario(int page,int size){
		Pageable pageable = PageRequest.of(page, size);
		Page<Usuario> usuarios=usuarioRepository.findAll(pageable);
		return usuarios.stream().map(usuario -> {
			Usuario dto=new Usuario();
			dto.setIdUsuario(usuario.getIdUsuario());
			dto.setNombre(usuario.getNombre());
			dto.setApellido(usuario.getApellido());
			dto.setNit(usuario.getNit());
			dto.setTelefonolist(usuario.getTelefonolist());
			dto.setCorreolist(usuario.getCorreolist());
			dto.setEmpleadolist(usuario.getEmpleadolist());
			return dto;
		}).collect(Collectors.toList());
	}
}
