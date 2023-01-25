package com.universales.prueba2.wsint;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.universales.prueba2.entity.Correo;
import com.universales.prueba2.entity.Rol;

@RestController
@RequestMapping("/rol")
@CrossOrigin
public interface RolInt {

	@GetMapping("/buscar")
	public List<Rol>buscarRol();
	
	@PostMapping("/guardar")
	public Rol guardar(@RequestBody Rol rol);
	
	@DeleteMapping(path="/eliminar/{id_rol}")
	public void eliminar(@PathVariable ("id_rol")Integer id_rol);
	
	@GetMapping(path="/buscar/por/{idRol}")
	public List<Rol> buscarPorIdRol(@PathVariable Integer idRol);

}
