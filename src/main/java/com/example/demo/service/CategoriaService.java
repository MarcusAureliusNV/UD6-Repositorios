package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Categoria;

public interface CategoriaService {
	
	Categoria crearCategoria(Categoria c);
	void eliminarCategoria(Categoria c);
	
	List<Categoria> CategoriasConProductos();
}
