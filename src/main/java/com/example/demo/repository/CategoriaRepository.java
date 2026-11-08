package com.example.demo.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Categoria;


@Repository("categoriaRepository")
public interface CategoriaRepository extends JpaRepository<Categoria, Serializable>{

	
	@Query("SELECT DISTINCT c FROM Categoria c JOIN FETCH c.productos")
	List<Categoria> buscarCategoriasConProductos();
}
