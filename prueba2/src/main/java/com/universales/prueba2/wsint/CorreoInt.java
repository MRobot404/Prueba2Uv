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

import com.universales.prueba2.entity.Correo;


@RestController
@RequestMapping("/correos")
@CrossOrigin
public interface CorreoInt {

	/**
	 * Servicio REST que permite buscar todos los correos.
	 * @return Lista de correos.
	 */
	@GetMapping("/buscar")
	public List<Correo> buscarCorreo();

	/**
	 * Servicio REST que permite guardar un correo.
	 * @param correo Correo a guardar.
	 * @return Correo guardado.
	 */
	@PostMapping("/guardar")
	public Correo guardar(@RequestBody Correo correo);

	/**
	 * Servicio REST que permite eliminar un correo.
	 * @param id_correo Identificador del correo a eliminar.
	 */
	@DeleteMapping(path = "/eliminar/{id_correo}")
	public void eliminar(@PathVariable("id_correo") Integer id_correo);

	/**
	 * Servicio REST que permite buscar un correo por su identificador.
	 * @param idCorreo Identificador del correo a buscar.
	 * @return Lista de correos.
	 */
	@GetMapping(path = "/buscar/por/{idCorreo}")
	public List<Correo> buscarPorIdCorreo(@PathVariable Integer idCorreo);

	/**
	 * Servicio REST que permite paginar los correos.
	 * @param page Número de página.
	 * @param size Tamaño de la página.
	 * @return Lista de correos.
	 */
	@GetMapping("/paginar")
	public List<Correo> getCorreo(@RequestParam("page") int page, @RequestParam("size") int size);
}
