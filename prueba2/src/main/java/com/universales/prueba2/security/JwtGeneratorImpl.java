package com.universales.prueba2.security;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.universales.prueba2.entity.Empleado;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtGeneratorImpl implements JwtGeneratorInterface {
	private final String secret = "secret";
	private final String message = "Token generado exitosamente";
	private final long tokenValidityInSeconds = 1800;

	/**
	 * Método para generar un token 
	 * @param empleado objeto Empleado con información del usuario
	 * @return un mapa con el token JWT generado y un mensaje de éxito
	 */
	
	@Override
	public Map<String, String> generateToken(Empleado empleado) {
		String jwtToken = "";
		Date now = new Date();
		Date expiration = new Date(now.getTime() + tokenValidityInSeconds * 1000);
		jwtToken = Jwts.builder().setSubject(String.valueOf(empleado.getCodigo())).setIssuedAt(now).setExpiration(expiration)
				.signWith(SignatureAlgorithm.HS256, secret).compact();
		Map<String, String> jwtTokenGen = new HashMap<>();
		jwtTokenGen.put("token", jwtToken);
		jwtTokenGen.put("message", message);	
		return jwtTokenGen;
	}
}
