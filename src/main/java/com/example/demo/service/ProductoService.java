package com.example.demo.service;

import java.util.List;

import org.springframework.data.domain.Sort;

import com.example.demo.entity.Producto;

public interface ProductoService {
	Producto crearProducto(Producto p);
	Producto buscarPorId(long id);
	List<Producto> listarProductos();
	Producto modificarProducto(Producto p);
	void eliminarProducto(Producto p2);
	
	List<Producto> buscarPorNombre(String nombre);
	List<Producto> buscarPorNombreConFragmento(String fragmento);
	List<Producto> buscarPorPrecioAcotado(Double min, Double max);
	
	List<Producto> buscarProductosMenorQueOrdenadoAsc(Double precio);
	List<Producto> listarProductosOrdenadosPorPrecioAsc(Sort sort);
	
	List<Producto> buscarPorNombreCategoria(String nombre);
}
