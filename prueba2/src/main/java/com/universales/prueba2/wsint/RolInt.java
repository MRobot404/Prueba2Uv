package com.universales.prueba2.wsint;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.universales.prueba2.entity.Rol;

@RestController
@RequestMapping("/rol")
@CrossOrigin
public interface RolInt {
	
	/**
	
	Método para buscar todos los roles.
	@return una lista con todos los roles.
	*/
	
	@GetMapping("/buscar")
	public List<Rol> buscarRol();
	/**
	
	Método para guardar un rol.
	@param rol El rol a guardar.
	@return El rol guardado.
	*/
	
	@PostMapping("/guardar")
	public Rol guardar(@RequestBody Rol rol);
	
	/**
	
	Método para eliminar un rol.
	@param id_rol El ID del rol a eliminar.
	*/
	
	@DeleteMapping(path = "/eliminar/{id_rol}")
	public void eliminar(@PathVariable("id_rol") Integer id_rol);
	
	/**
	
	Método para buscar un rol por su ID.
	@param idRol El ID del rol a buscar.
	@return La lista de roles con el ID especificado.
	*/
	
	@GetMapping(path = "/buscar/por/{idRol}")
	public List<Rol> buscarPorIdRol(@PathVariable Integer idRol);
	
	/**
	
	Método para paginar los roles.
	@param page El número de página a obtener.
	@param size El número de elementos por página.
	@return La lista de roles en la página especificada.
	*/
	@GetMapping("/paginar")
	public List<Rol> getRol(@RequestParam("page") int page, @RequestParam("size") int size);
	}
