package com.universales.prueba2.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "USUARIO")
public class Usuario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@GenericGenerator(name = "ID_USUARIO", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
			@Parameter(name = "sequence_name", value = "test_seq25"), @Parameter(name = "initial_value", value = "1"),
			@Parameter(name = "increment_size", value = "1"), @Parameter(name = "schema", value = "SYSTEM") })
	@Id
	@Basic(optional = false)
	@Column(name = "ID_USUARIO")
	@GeneratedValue(generator = "ID_USUARIO")
	private Integer idUsuario;
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	@Column(name = "APELLIDO")
	private String apellido;
	
	@Column(name = "NIT")
	private float nit;
	
	@Column(name="FECHA_NACIMIENTO")
	private Date fecha;
	
	@OneToMany(mappedBy="idTelefono")
	private List<Telefono> telefonolist;
	

	
	public List<Telefono> getTelefonolist() {
		return telefonolist;
	}

	public void setTelefonolist(List<Telefono> telefonolist) {
		this.telefonolist = telefonolist;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}



	public float getNit() {
		return nit;
	}

	public void setNit(float nit) {
		this.nit = nit;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

}
