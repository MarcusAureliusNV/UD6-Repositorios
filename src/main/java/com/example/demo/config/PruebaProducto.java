package com.example.demo.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.entity.Producto;

@Configuration
public class PruebaProducto {

	@Bean
	CommandLineRunner crearProducto() {
		return args->{
			Producto p = new Producto();
			System.out.println(p);
		};
		
	}
}
