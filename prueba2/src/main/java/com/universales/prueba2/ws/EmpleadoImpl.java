package com.universales.prueba2.ws;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.universales.prueba2.entity.Empleado;
import com.universales.prueba2.entity.Rol;
import com.universales.prueba2.repository.EmpleadoRepository;
import com.universales.prueba2.service.EmpleadoService;
import com.universales.prueba2.wsint.EmpleadoInt;
@Component
public class EmpleadoImpl implements EmpleadoInt {
	
	@Autowired
	EmpleadoRepository empleadoRepository;
	
	@Autowired(required=true)
	EmpleadoService ps;
	
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
	
	@Override
	public List<Empleado>buscarPorIdEmpleado(Integer idEmpleado){
		return empleadoRepository.findByIdEmpleado(idEmpleado);
	}
	@Override
	public List<Map<String, Object>> buscarporNombre(Integer idRol) {
		// TODO Auto-generated method stub
		return ps.buscarporNombre(idRol);
	}
}
