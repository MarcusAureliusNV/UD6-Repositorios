package com.example.demo.service.imp;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Producto;
import com.example.demo.repository.ProductoRepository;
import com.example.demo.service.ProductoService;

@Service
public class ProductoServiceImp implements ProductoService{

	private ProductoRepository productoRepository;
	
	
	public ProductoServiceImp(ProductoRepository productoRepository) {
		this.productoRepository = productoRepository;
	}

	@Override
	public Producto crearProducto(Producto p) {
		return productoRepository.save(p);
		
	}

	@Override
	public Producto buscarPorId(long id) { 
		return productoRepository.findById(id).orElse(null);
	}

	@Override
	public List<Producto> listarProductos() {
		return productoRepository.findAll();
	}

	@Override
	public Producto modificarProducto(Producto p) {
		return productoRepository.save(p);
		
	}

	@Override
	public void eliminarProducto(Producto p) { 
		productoRepository.deleteById(p.getId());
		
	}

	@Override
	public List<Producto> buscarPorNombre(String nombre) {
		return productoRepository.findByNombre(nombre);
	}

	@Override
	public List<Producto> buscarPorCadena(String cadena) {
		return productoRepository.findByNombreContaining(cadena);
	}
	@Override
	public List<Producto> buscarEntrePrecios(Double min,Double max){
		return productoRepository.findByPrecioBetween(min, max);
	}
	
	@Override
	public List<Producto> buscarEntrePreciosOrdenNombre(Double min,Double max){
		
		List<Producto> prods= productoRepository.findByPrecioBetween(min, max);

		return prods.stream().sorted(Comparator.comparing(Producto::getNombre)).toList();
	}

	
	@Override
	public List<Producto> buscarEntrePreciosOrdenPrecio(Double min,Double max){
		
		List<Producto> prods= productoRepository.findByPrecioBetween(min, max);

		return prods.stream().sorted(Comparator.comparing(Producto::getPrecio)).toList();
	}

	@Override
	public List<Producto> buscarPorCategoria(String nombre) {
		
		return productoRepository.findByCategoriaNombre(nombre);
	}


}