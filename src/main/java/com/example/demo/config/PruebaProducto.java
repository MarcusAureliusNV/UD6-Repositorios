package com.example.demo.config;

import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Sort;

import com.example.demo.entity.Categoria;
import com.example.demo.entity.Producto;
import com.example.demo.service.CategoriaService;
import com.example.demo.service.ProductoService;
import com.example.demo.service.imp.CategoriaServiceImp;

@Configuration
public class PruebaProducto {

	private final CategoriaServiceImp categoriaServiceImp;
	private ProductoService productoService;
	private CategoriaService categoriaService;

	public PruebaProducto(ProductoService productoService, CategoriaService categoriaService, CategoriaServiceImp categoriaServiceImp) {
		super();
		this.productoService = productoService;
		this.categoriaService = categoriaService;
		this.categoriaServiceImp = categoriaServiceImp;
	}

	@Bean
	CommandLineRunner crearProducto() {
		return args -> {
			Set<Producto> productos = new HashSet<>();
			
			Categoria c = new Categoria("Yakuza", productos);
			Producto p = new Producto("Kiryu", 10.0, 1, c);
			Producto p2 = new Producto("Majima", 24.0, 7, c);
			Producto p3 = new Producto("Ryuji", 2.0, 2, c);
			
			productos.add(p);
			productos.add(p2);
			productos.add(p3);
			
			System.out.println(p);
			System.out.println(p2);
			System.out.println(p3);

			categoriaService.crearCategoria(c);
			System.out.println(c);
			productoService.crearProducto(p);
			productoService.crearProducto(p2);
			productoService.crearProducto(p3);
			
			p.setNombre("Joryu");
			productoService.modificarProducto(p);

			System.out.println(productoService.buscarPorId(p.getId()));
			System.out.println(productoService.listarProductos());
			
			System.out.println("\n\nBÚSQUEDAS DE FRAGMENTO");
			System.out.println(productoService.buscarPorNombre("Joryu"));
			System.out.println(productoService.buscarPorNombreConFragmento("yu"));
			System.out.println(productoService.buscarPorNombreConFragmento("i"));

			System.out.println("\n\nCOMPROBAR PRECIO");
			System.out.println(productoService.buscarPorPrecioAcotado(1.0, 24.0)); // creo que se incluyen los dos límites
			
			System.out.println("\n\nSORT");
			System.out.println("\nMétodo derivado");
			System.out.println(productoService.buscarProductosMenorQueOrdenadoAsc(68.0));
			System.out.println("\nSort sort");
			Sort sort = Sort.by("precio").ascending();
			System.out.println(productoService.listarProductosOrdenadosPorPrecioAsc(sort));
			
			System.out.println("\n\nCATEGORIA-PRODUCTO");
			Set<Producto> productos2 = new HashSet<>();
			Set<Producto> productos3 = new HashSet<>();
			Categoria c2 = new Categoria("Hanzi", productos2); // 1 Producto
			Producto p4 = new Producto("Gaoxing", 6.0, 3, c2);
			productos2.add(p4);
			Categoria c3 = new Categoria("Zhong", productos3); // Vacía para comprobar CategoriasConProductos

			categoriaService.crearCategoria(c2);
			categoriaService.crearCategoria(c3);
			productoService.crearProducto(p4);
			
			System.out.println(productoService.buscarPorNombreCategoria("Yakuza"));
			System.out.println(categoriaService.CategoriasConProductos());
			
			categoriaService.eliminarCategoria(c2);
			categoriaService.eliminarCategoria(c3);
			
			productoService.eliminarProducto(p2);
			productoService.eliminarProducto(p4);
			System.out.println(productoService.buscarPorId(p2.getId()));
		};

	}
}
