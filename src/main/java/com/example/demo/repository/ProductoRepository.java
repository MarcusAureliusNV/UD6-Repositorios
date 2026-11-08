package com.example.demo.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Categoria;
import com.example.demo.entity.Producto;

@Repository("productoRepository")
public interface ProductoRepository extends JpaRepository<Producto, Serializable>{

	List<Producto> findByNombre(String nombre);
	List<Producto> findByNombreContaining(String fragmento);
	List<Producto> findByPrecioBetween(Double min, Double max);
	
	List<Producto> findByPrecioLessThanOrderByPrecioAsc(Double precio);
	
	List<Producto> findByCategoriaNombre(String nombre);
}
