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

import com.universales.prueba2.entity.Usuario;


@RestController
@RequestMapping("/usuarios")
@CrossOrigin
public interface UsuarioInt {
	
	@GetMapping("/buscar")
	public List<Usuario>buscarUsuario();
	
	@PostMapping("/guardar")
	public Usuario guardar(@RequestBody Usuario usuario);
	
	@DeleteMapping(path="/eliminar/{id_usuario}")
	public void eliminar(@PathVariable ("id_usuario")Integer id_usuario);
	
	@GetMapping(path="/buscar/por/{nombre}/{apellido}")
	public List<Usuario>buscarPorNombreYApellido(@PathVariable String nombre,@PathVariable String apellido);
}
