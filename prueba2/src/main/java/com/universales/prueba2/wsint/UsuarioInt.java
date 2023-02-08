package com.universales.prueba2.wsint;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.universales.prueba2.entity.Usuario;


@RestController
@RequestMapping("/usuarios")
@CrossOrigin
public interface UsuarioInt {
	
	/**
	 * Método para buscar todos los usuarios.
	 * 
	 * @return Lista de usuarios.
	 */
	
	@GetMapping("/buscar")
	public List<Usuario>buscarUsuario();
	
	/**
	 * Método para guardar un usuario.
	 * 
	 * @param usuario El usuario a guardar.
	 * @return El usuario guardado.
	 */
	
	@PostMapping("/guardar")
	public Usuario guardar(@RequestBody Usuario usuario);
	
	/**
	 * Método para eliminar un usuario.
	 * 
	 * @param id_usuario El id del usuario a eliminar.
	 */
	
	@DeleteMapping(path="/eliminar/{id_usuario}")
	public void eliminar(@PathVariable ("id_usuario")Integer id_usuario);
	
	/**
	 * Método para buscar usuarios por nombre y apellido.
	 * 
	 * @param nombre El nombre del usuario.
	 * @param apellido El apellido del usuario.
	 * @return Lista de usuarios que cumplen con los criterios.
	 */
	
	@GetMapping(path="/buscar/por/{nombre}/{apellido}")
	public List<Usuario>buscarPorNombreYApellido(@PathVariable String nombre,@PathVariable String apellido);
	
	/**
	 * Método para buscar usuarios por nombre.
	 * 
	 * @param nombre El nombre del usuario.
	 * @return Lista de usuarios que cumplen con el criterio.
	 */
	
	@GetMapping(path="/consultar/nombre/{nombre}")
	public List<Map<String,Object>>buscarporNombre(@PathVariable String nombre);
	
	/**
	 * Método para buscar un usuario por id.
	 * 
	 * @param idUsuario El id del usuario.
	 * @return El usuario que cumple con el criterio.
	 */
	
	@GetMapping(path="/buscar/porr/{idUsuario}")
	public List<Usuario>buscarPorIdUsuario(@PathVariable Integer idUsuario);
	
	/**
	 * Método para buscar usuarios por fecha.
	 * 
	 * @param fecha La fecha a buscar.
	 * @return Lista de usuarios que cumplen con el criterio.
	 */
	
	@GetMapping(path="buscar/por/fecha/")
	public List<Usuario>buscarPorFecha(@RequestParam("fecha") @DateTimeFormat(pattern="yyyy-MM-dd") Date fecha);
	
	/**
	 * Método para paginar a los usuarios
	 * 
	 * @param  page el cual sirve para poder saber el numero de la pagina.
	 * 
	 * @param  size para saber el tamaño de la pagina
	 * @return Lista de usuarios que cumplen con el criterio.
	 */

	@GetMapping("/paginar")
	List<Usuario> getUsuario(@RequestParam ("page") int page, @RequestParam ("size")  int size);
	
	
}
