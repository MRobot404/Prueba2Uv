package com.universales.prueba2.ws;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.universales.prueba2.entity.Correo;
import com.universales.prueba2.entity.Empleado;
import com.universales.prueba2.repository.EmpleadoRepository;
import com.universales.prueba2.wsint.EmpleadoInt;
@Component
public class EmpleadoImpl implements EmpleadoInt {
	
	@Autowired
	EmpleadoRepository empleadoRepository;
	
	@Override
	public List<Empleado>buscarEmpleado(){
		return empleadoRepository.findAll();
	}
	@Override
	public Empleado guardar(Empleado empleado) {
		return empleadoRepository.save(empleado);
	}
	
	@Override
	public void eliminar(Integer id_empleado) {
		Optional <Empleado> empleados =  empleadoRepository.findById(id_empleado);
		if(empleados.isPresent()) {
			empleadoRepository.delete(empleados.get());
		}
		
	}
}
