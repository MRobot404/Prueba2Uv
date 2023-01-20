package com.universales.prueba2.entity;

import java.io.Serializable;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "TELEFONO")
public class Telefono implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@GenericGenerator(name = "ID_TELEFONO", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
			@Parameter(name = "sequence_name", value = "test_seq29"), @Parameter(name = "initial_value", value = "1"),
			@Parameter(name = "increment_size", value = "1"), @Parameter(name = "schema", value = "SYSTEM") })
	@Id
	@Basic(optional = false)
	@Column(name = "ID_TELEFONO")
	@GeneratedValue(generator = "ID_TELEFONO")
	private Integer idTelefono;
	
	@Column(name="TELEFONO")
	@GeneratedValue(generator = "TELEFONO")
	private int telefono;
	
	@Column(name="EXTENSION")
	@GeneratedValue(generator = "EXTENSION")
	private int extension;
	
	@Column(name="ID_USUARIO")
	@GeneratedValue(generator = "ID_USUARIO")
	private int idUsuario;

	public Integer getIdTelefono() {
		return idTelefono;
	}

	public void setIdTelefono(Integer idTelefono) {
		this.idTelefono = idTelefono;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public int getExtension() {
		return extension;
	}

	public void setExtension(int extension) {
		this.extension = extension;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
