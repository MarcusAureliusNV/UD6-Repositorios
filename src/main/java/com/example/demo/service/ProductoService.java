package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Producto;

public interface ProductoService {
	Producto crearProducto(Producto p);
	Optional<Producto> buscarPorId(long id);
	List<Producto> listarProductos();
	Producto modificarProducto(Producto p);
	void eliminarProducto(Producto p2);
}
