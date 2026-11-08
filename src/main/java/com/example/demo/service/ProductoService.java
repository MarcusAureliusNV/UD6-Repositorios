package com.example.demo.service;


import java.util.List;

import com.example.demo.entity.Producto;

public interface ProductoService {
	
	Producto crearProducto(Producto p);
	Producto buscarPorId(long id);
	List<Producto> listarProductos();
	Producto modificarProducto(Producto p);
	void eliminarProducto(Producto p2);

	List<Producto> buscarPorNombre(String nombre);
	List<Producto> buscarPorCadena(String cadena);
	
	List<Producto> buscarEntrePrecios(Double min,Double max);
	List<Producto> buscarEntrePreciosOrdenNombre(Double min,Double max);
	List<Producto> buscarEntrePreciosOrdenPrecio(Double min,Double max);
	
	
	List<Producto> buscarPorCategoria(String nombre);
}
