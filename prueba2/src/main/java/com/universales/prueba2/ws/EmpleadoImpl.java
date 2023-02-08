package com.universales.prueba2.ws;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.universales.prueba2.security.JwtGeneratorInterface;
import com.universales.prueba2.entity.Empleado;
import com.universales.prueba2.repository.EmpleadoRepository;
import com.universales.prueba2.service.EmpleadoService;
import com.universales.prueba2.wsint.EmpleadoInt;
@Component
public class EmpleadoImpl implements EmpleadoInt {
	
	@Autowired
	EmpleadoRepository empleadoRepository;
	
	@Autowired
	JwtGeneratorInterface jwtGenerator;
	
	@Autowired(required=true)
	EmpleadoService ps;
	/**
	 * Método para buscar todos los empleados.
	 * 
	 * @return lista de todos los empleados
	 */
	@Override
	public List<Empleado>buscarEmpleado(){
		return empleadoRepository.findAll();
		
	/**
	 * Método para guardar unempleado.
	* 
	* @param correo el empleado a guardar
	* @return el empleado guardado
	*/	
	}
	@Override
	public Empleado guardar(Empleado empleado) {
		return empleadoRepository.save(empleado);
	}
	
	/**
	 * Método para eliminar un empleado por su ID.
	 * 
	 * @param id_correo el ID del empleado a eliminar
	 */
	
	@Override
	public void eliminar(Integer id_empleado) {
		Optional <Empleado> empleados =  empleadoRepository.findById(id_empleado);
		if(empleados.isPresent()) {
			empleadoRepository.delete(empleados.get());
		}
		
		/**
		 * Método para buscar un empleado por su ID.
		 * 
		 * @param idCorreo el ID del empleado a buscar
		 * @return lista de empleados con el ID especificado
		 */
	}
	
	/**

	Método para buscar un empleado por su identificador
	@param idEmpleado identificador único del empleado
	@return lista de objetos Empleado con el identificador especificado
	*/
	
	@Override
	public List<Empleado>buscarPorIdEmpleado(Integer idEmpleado){
		return empleadoRepository.findByIdEmpleado(idEmpleado);	
		
	/**

	Método para buscar empleados por su identificador de rol
	@param idRol identificador único del rol
	@return lista de objetos {@link Map} con información de los empleados con el identificador de rol especificado
	*/	
	}
	@Override
	public List<Map<String, Object>> buscarporNombre(Integer idRol) {
		// TODO Auto-generated method stub
		return ps.buscarporNombre(idRol);
	}
	
	
	/**
	 * Método para obtener una página de empleados.
	 * 
	 * @param page número de página
	 * @param size tamaño de la página
	 * @return lista de empleados en la página especificada
	 */
	
	@Override
	public List<Empleado>getEmpleado(int page,int size){
		Pageable pageable=PageRequest.of(page, size);
		Page<Empleado> empleados=empleadoRepository.findAll(pageable);
		return empleados.stream().map(empleado -> {
			Empleado dto=new Empleado();
			dto.setCodigo(empleado.getCodigo());
			dto.setIdEmpleado(empleado.getIdEmpleado());
			dto.setIdUsuario(empleado.getIdUsuario());
			dto.setRol(empleado.getRol());
			dto.setContrasena(empleado.getContrasena());
			return dto;
		}).collect(Collectors.toList());
	}
	
	@Override
	  public ResponseEntity<?> loginUser(@RequestBody Empleado empleado) {
		    try {
		      if(empleado.getCodigo() == null ||empleado.getContrasena() == null) {
		      throw new UserPrincipalNotFoundException("Usuario o contraseña vacio");
		    }
		    Empleado userData = getEmpleadoByCodigoAndContrasena(empleado.getCodigo(), empleado.getContrasena());
		    if(userData == null){
		       throw new UserPrincipalNotFoundException("Usuario o contraseña incorrectos");
		    }
		       return new ResponseEntity<>(jwtGenerator.generateToken(empleado), HttpStatus.OK);
		    } catch (UserPrincipalNotFoundException e) {
		       return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
		    }
		  }
	
	
	@Override
	public Empleado getEmpleadoByCodigoAndContrasena(Integer codigo,String contrasena)  throws UserPrincipalNotFoundException {
	   Empleado user = empleadoRepository.findByCodigoAndContrasena(codigo,contrasena);
	    if(user == null){
	       throw new UserPrincipalNotFoundException("Usuario o password invalido");
	    }
	    return user;
	  }
}
