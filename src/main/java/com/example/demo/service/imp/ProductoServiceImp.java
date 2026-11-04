package com.example.demo.service.imp;

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
	public Optional<Producto> buscarPorId(long id) { // Si no lo encuentra que no pete, se puede hacer con .OrElse
		return productoRepository.findById(id);
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
	public void eliminarProducto(Producto p) { // void? o int y devuelve 0?
		productoRepository.deleteById(p.getId());
		
	}

}
