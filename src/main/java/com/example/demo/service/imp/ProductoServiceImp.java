package com.example.demo.service.imp;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Producto;
import com.example.demo.repository.ProductoRepository;
import com.example.demo.service.ProductoService;

@Service
public class ProductoServiceImp implements ProductoService {

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
	public List<Producto> buscarPorNombreConFragmento(String fragmento) {
		return productoRepository.findByNombreContaining(fragmento);
	}

	@Override
	public List<Producto> buscarPorPrecioAcotado(Double min, Double max) {
		return productoRepository.findByPrecioBetween(min, max);
	}

	@Override
	public List<Producto> buscarProductosMenorQueOrdenadoAsc(Double precio) {
		return productoRepository.findByPrecioLessThanOrderByPrecioAsc(precio);
	}

	@Override
	public List<Producto> listarProductosOrdenadosPorPrecioAsc(Sort sort) {
		// Sort sort = Sort.by("precio").ascending();
		return productoRepository.findAll(sort);
		// return productoRepository.findAll(Sort.by("precio").ascending());
	}

	@Override
	public List<Producto> buscarPorNombreCategoria(String nombre) {
		return productoRepository.findByCategoriaNombre(nombre);
	}

}
