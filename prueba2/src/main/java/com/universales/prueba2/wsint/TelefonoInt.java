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

import com.universales.prueba2.entity.Telefono;
import com.universales.prueba2.entity.Usuario;

@RestController
@RequestMapping("/telefonos")
@CrossOrigin
public interface TelefonoInt {
	
	@GetMapping("/buscar")
	public List<Telefono>buscarTelefono();
	
	@PostMapping("/guardar")
	public Telefono guardar(@RequestBody Telefono telefono);
	
	@DeleteMapping(path="/eliminar/{id_telefono}")
	public void eliminar(@PathVariable ("id_telefono")Integer id_telefono);
	
	@GetMapping(path="/buscar/por/{idTelefono}")
	public List<Telefono>buscarPorIdTelefono(@PathVariable Integer idTelefono);
}