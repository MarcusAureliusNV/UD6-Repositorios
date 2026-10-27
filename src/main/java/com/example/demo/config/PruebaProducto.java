package com.example.demo.config;

import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.entity.Categoria;
import com.example.demo.entity.Producto;

@Configuration
public class PruebaProducto {

	@Bean
	CommandLineRunner crearProducto() {
		return args->{
			Set<Producto> productos = new HashSet<>();
			Categoria c = new Categoria(1L, "Culinarios", productos);
			Producto p = new Producto(1L, "Mondongo", 67.67, 67, c);
			productos.add(p);
			System.out.println(p);
			System.out.println(c);
		};
		
	}
}
