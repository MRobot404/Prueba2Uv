package com.universales.prueba2.security;

import java.util.Map;

import com.universales.prueba2.entity.Empleado;

public interface JwtGeneratorInterface {
	Map<String, String> generateToken(Empleado empleado);
}
