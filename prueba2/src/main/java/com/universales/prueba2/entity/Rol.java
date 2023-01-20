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
@Table(name = "ROL")
public class Rol implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@GenericGenerator(name = "ID_ROL", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
			@Parameter(name = "sequence_name", value = "test_seq27"), @Parameter(name = "initial_value", value = "1"),
			@Parameter(name = "increment_size", value = "1"), @Parameter(name = "schema", value = "SYSTEM") })
	@Id
	@Basic(optional = false)
	@Column(name = "ID_ROL")
	@GeneratedValue(generator = "ID_ROL")
	private Integer idRol;
	
	@Column(name="AREA")
	private String area;
	
	@Column(name="ROL")
	private String rol;

	public Integer getIdRol() {
		return idRol;
	}

	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
