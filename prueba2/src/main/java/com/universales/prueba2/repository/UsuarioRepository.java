package com.universales.prueba2.repository;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.universales.prueba2.entity.Usuario;

@Repository("usuarioRepository")
public interface UsuarioRepository extends JpaRepository<Usuario, Serializable>,PagingAndSortingRepository<Usuario, Serializable> {
	public List<Usuario> findByNombreAndApellido(String nombre, String apellido);
	public List<Usuario> findByidUsuario(int idUsuario);
	public List<Usuario> findByFechaAfter(Date fecha);
	public List<Usuario> findByFechaBetween(Date fechaInicio, Date fechaFin);
	public List<Usuario> findByCorreolist_IdCorreo(Integer idCorreo);
}
