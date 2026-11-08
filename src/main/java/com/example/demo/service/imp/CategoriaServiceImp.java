package com.example.demo.service.imp;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Categoria;
import com.example.demo.entity.Producto;
import com.example.demo.repository.CategoriaRepository;
import com.example.demo.service.CategoriaService;

@Service
public class CategoriaServiceImp implements CategoriaService{

	private CategoriaRepository categoriaRepository;

	public CategoriaServiceImp(CategoriaRepository categoriaRepository) {
		super();
		this.categoriaRepository = categoriaRepository;
	}

	@Override
	public Categoria crearCategoria(Categoria c) {
		return categoriaRepository.save(c);
	}

	@Override
	public void eliminarCategoria(Categoria c) {
		categoriaRepository.delete(c);
		
	}

	@Override
	public List<Categoria> CategoriasConProductos() {
		return categoriaRepository.buscarCategoriasConProductos();
	}
}
