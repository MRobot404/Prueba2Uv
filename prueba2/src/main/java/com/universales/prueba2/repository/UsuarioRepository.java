package com.universales.prueba2.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.universales.prueba2.entity.Usuario;

@Repository("usuarioRepository")
public interface UsuarioRepository extends JpaRepository<Usuario, Serializable> {
	public List<Usuario> findByNombreAndApellido(String nombre, String apellido);
	public List<Usuario> findByidUsuario(int idUsuario);
}
