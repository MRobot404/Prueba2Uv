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

	
	/**
	 * Inyección de dependencia de UsuarioRepository para el manejo de operaciones CRUD en la tabla usuario.
	 */
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	/**
	 * Inyección de dependencia de TelefonoRepository para el manejo de operaciones CRUD en la tabla telefono.
	 */
	
	@Autowired
	TelefonoRepository telefonoRepository;
	
	/**
	 * Inyección de dependencia de CorreoRepository para el manejo de operaciones CRUD en la tabla correo.
	 */
	
	@Autowired
	CorreoRepository correoRepository;
	
	/**
	 * Inyección de dependencia de EmpleadoRepository para el manejo de operaciones CRUD en la tabla empleado.
	 */
	
	@Autowired
	EmpleadoRepository empleadoRepository;
	
	/**
	 * Inyección de dependencia de UsuarioService para el manejo de operaciones CRUD en la tabla usuario.
	 */
	
	@Autowired(required=true)
	UsuarioService ps;
	
	/**
	 * Método que busca todos los usuarios registrados en la tabla usuario.
	 * 
	 * @return Una lista con todos los usuarios encontrados en la tabla usuario.
	 */
	
	@Override
	public List<Usuario>buscarUsuario(){
		return usuarioRepository.findAll();
	}
	
	/**
	 * Método que guarda un nuevo usuario en la tabla usuario y sus respectivos telefonos, correos y empleados en las tablas correspondientes.
	 * 
	 * @param usuario Usuario a ser guardado en la tabla usuario.
	 * 
	 * @return El usuario guardado en la tabla usuario.
	 */
	
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
	
	/**
	 * Método para eliminar un usuario por su identificador.
	 * 
	 * @param id_usuario identificador del usuario a eliminar.
	 */
	
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
	
	/**
	 * Método para buscar usuarios por su nombre y apellido.
	 * 
	 * @param nombre nombre del usuario a buscar.
	 * @param apellido apellido del usuario a buscar.
	 * 
	 * @return lista de usuarios con el nombre y apellido especificados.
	 */

	@Override
	public List<Usuario>buscarPorNombreYApellido(String nombre, String apellido){
		return usuarioRepository.findByNombreAndApellido(nombre, apellido);
	}
	
	/**
	 * Método para buscar usuarios por su identificador.
	 * 
	 * @param idUsuario identificador del usuario a buscar.
	 * 
	 * @return lista de usuarios con el identificador especificado.
	 */
	
	@Override
	public List<Usuario>buscarPorIdUsuario(Integer idUsuario){
		return usuarioRepository.findByidUsuario(idUsuario);
	}
	
	/**
	 * Método para buscar usuarios por una fecha específica.
	 * 
	 * @param fecha fecha a partir de la cual se buscarán usuarios.
	 * 
	 * @return lista de usuarios creados después de la fecha especificada.
	 */
	
	@Override
	public List<Usuario>buscarPorFecha(Date fecha){
		return usuarioRepository.findByFechaAfter(fecha);
	}
	
	/**
	 * Método para buscar usuarios por nombre.
	 * 
	 * @param nombre nombre del usuario a buscar.
	 * 
	 * @return lista de mapas con la información de los usuarios encontrados.
	 */

	@Override
	public List<Map<String, Object>> buscarporNombre(String nombre) {
		// TODO Auto-generated method stub
		return ps.buscarporNombre(nombre);
	}
	
	/**
	* Método para obtener una lista de usuarios
	* 
	* @param page número de página
	* 
	* @param size tamaño de página
	* 
	* @return Lista de usuarios en forma de objetos Usuario
	*/
	
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
