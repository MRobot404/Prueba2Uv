package com.universales.prueba2.security;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {
	
	/**
	*Crea un Bean de tipo FilterRegistrationBean para el filtro JwtFilter.
	* @return un objeto de tipo FilterRegistrationBean con la configuración para el filtro JwtFilter.
	*/
	
	@Bean
	    FilterRegistrationBean<JwtFilter> jwtFilter() {
	        FilterRegistrationBean<JwtFilter> filter= new FilterRegistrationBean<JwtFilter>();
	        filter.setFilter(new JwtFilter());
	        filter.addUrlPatterns("/usuarios/*","/telefonos/*","/rol/*","/correos/*");
	    return filter;
	    }
}
