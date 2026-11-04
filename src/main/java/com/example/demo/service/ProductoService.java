package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Producto;

public interface ProductoService {
	
	Producto crearProducto();
	Producto consultarPorId(long id);
	List<Producto> listarProductos();
	Producto modificarProducto(Producto p);
	void eliminarProdcuto(int id);

}
