package com.universales.prueba2.wsint;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.universales.prueba2.entity.Empleado;
@RestController
@RequestMapping("/empleados")
@CrossOrigin
public interface EmpleadoInt {
	
	/**
	 * Método que busca todos los empleados existentes.
	 * @return Lista de objetos Empleado
	 */
	@GetMapping("/buscar")
	public List<Empleado>buscarEmpleado();
	
	/**
	 * Método que guarda un empleado en la base de datos.
	 * @param empleado objeto Empleado a ser guardado.
	 * @return objeto Empleado guardado.
	 */
	@PostMapping("/guardar")
	public Empleado guardar(@RequestBody Empleado empleado);
	
	/**
	 * Método que elimina un empleado de la base de datos.
	 * @param id_empleado identificador del empleado a ser eliminado.
	 */
	@DeleteMapping(path="/eliminar/{id_empleado}")
	public void eliminar(@PathVariable ("id_empleado")Integer id_empleado);
	
	/**
	 * Método que busca un empleado por su identificador.
	 * @param idEmpleado identificador del empleado a buscar.
	 * @return Lista de objetos Empleado
	 */
	@GetMapping(path="/buscar/por/{idEmpleado}")
	public List<Empleado> buscarPorIdEmpleado(@PathVariable Integer idEmpleado);
	
	/**
	 * Método que realiza una búsqueda de empleados por identificador de rol.
	 * @param idRol identificador del rol a buscar.
	 * @return Lista de objetos Map que contienen información de empleados y roles.
	 */
	@GetMapping(path="/join/{idRol}")
	public List<Map<String,Object>>buscarporNombre(@PathVariable Integer idRol);
	
	/**
	 * Método que devuelve una lista paginada de empleados.
	 * @param page número de página.
	 * @param size tamaño de la página.
	 * @return Lista de objetos Empleado.
	 */
	@GetMapping("/paginar")
	List<Empleado> getEmpleado(@RequestParam ("page") int page, @RequestParam ("size")  int size);
}
