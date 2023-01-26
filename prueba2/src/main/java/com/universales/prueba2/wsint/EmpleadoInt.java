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
import org.springframework.web.bind.annotation.RestController;


import com.universales.prueba2.entity.Empleado;
import com.universales.prueba2.entity.Rol;

@RestController
@RequestMapping("/empleados")
@CrossOrigin
public interface EmpleadoInt {
	@GetMapping("/buscar")
	public List<Empleado>buscarEmpleado();
	
	@PostMapping("/guardar")
	public Empleado guardar(@RequestBody Empleado empleado);
	
	@DeleteMapping(path="/eliminar/{id_empleado}")
	public void eliminar(@PathVariable ("id_empleado")Integer id_empleado);
	
	@GetMapping(path="/buscar/por/{idEmpleado}")
	public List<Empleado> buscarPorIdEmpleado(@PathVariable Integer idEmpleado);
	
	@GetMapping(path="/join/{idRol}")
	public List<Map<String,Object>>buscarporNombre(@PathVariable Integer idRol);
}
