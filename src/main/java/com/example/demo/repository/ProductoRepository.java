package com.example.demo.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Producto;

@Repository("productoRepository")
public interface ProductoRepository extends JpaRepository<Producto, Serializable>{

	public List<Producto> findByNombre(String nombre);
	
	public List<Producto> findByNombreContaining(String cadena);
	
	public List<Producto> findByPrecioBetween(Double min,Double max);
	
	public List<Producto> findByCategoriaNombre(String nombre);
	
	@Query("SELECT p FROM Producto p "+
			"WHERE p.categoria.nombre = :nombreCategoria " +
			"AND p.precio > :precioMin "+
			"AND p.precio < :precioMax")
	List<Producto> filtrarProductoPorPrecioMaxMinCategoria(
			@Param("precioMax")Double max,
			@Param("precioMin")Double min, 
			@Param("nombreCategoria")String categoriaNombre);
		
}
