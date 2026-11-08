package com.example.demo.config;

import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.entity.Categoria;
import com.example.demo.entity.Producto;
import com.example.demo.service.CategoriaService;
import com.example.demo.service.ProductoService;

@Configuration
public class PruebaProducto {

	private ProductoService productoService;
	private CategoriaService categoriaService;

	public PruebaProducto(ProductoService productoService, CategoriaService categoriaService) {
		super();
		this.productoService = productoService;
		this.categoriaService = categoriaService;
	}

	@Bean
	CommandLineRunner crearProducto() {
		return args -> {
			Set<Producto> productos = new HashSet<>();
			Categoria c = new Categoria("Culinarios", productos);
			Producto p = new Producto("Mondongo", 67.67, 67, c);
			Producto p2 = new Producto("Borra", 23.0, 45, c);
			
			productos.add(p);
			productos.add(p2);
			System.out.println(p);
			System.out.println(p2);

			categoriaService.crearCategoria(c);
			System.out.println(c);
			productoService.crearProducto(p);
			productoService.crearProducto(p2);
			p.setNombre("Mondongón");
			productoService.modificarProducto(p);

			System.out.println(productoService.buscarPorId(p.getId()));
			System.out.println(productoService.listarProductos());
			productoService.eliminarProducto(p2);
			System.out.println(productoService.buscarPorId(p2.getId()));
			
			Producto p3= new Producto("Samuelongo",700.00,90,c);
			productoService.crearProducto(p3);
			
			System.out.println(productoService.buscarPorNombre("Samuelongo"));
			System.out.println(productoService.buscarPorCadena("ngo"));
			
			System.out.println(productoService.buscarEntrePrecios(67.67, 700.00));
			
			System.out.println("Lista ordenada por Nombre "+productoService.buscarEntrePreciosOrdenNombre(67.67, 700.00));
			System.out.println("Lista ordenada por Precio "+productoService.buscarEntrePreciosOrdenPrecio(67.67, 700.00));
			System.out.println(productoService.buscarPorCategoria("Culinarios"));
		
		};

	}
}