package com.example.demo.configuration;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.entity.Producto;


@Configuration
public class ConfiguracionProducto {
	
	
	@Bean
	CommandLineRunner crearProductos() {
		return args -> {
			System.out.println(new Producto());
		};
		
		
	}
	
	
	
}
