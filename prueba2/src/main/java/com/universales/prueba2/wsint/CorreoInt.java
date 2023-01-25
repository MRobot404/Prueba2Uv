package com.universales.prueba2.wsint;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.universales.prueba2.entity.Correo;
import com.universales.prueba2.entity.Telefono;

@RestController
@RequestMapping("/correos")
@CrossOrigin
public interface CorreoInt {
	@GetMapping("/buscar")
	public List<Correo>buscarCorreo();
	
	@PostMapping("/guardar")
	public Correo guardar(@RequestBody Correo correo);
	
	@DeleteMapping(path="/eliminar/{id_correo}")
	public void eliminar(@PathVariable ("id_correo")Integer id_correo);
	
	@GetMapping(path="/buscar/por/{idCorreo}")
	public List<Correo> buscarPorIdCorreo(@PathVariable Integer idCorreo);
}
