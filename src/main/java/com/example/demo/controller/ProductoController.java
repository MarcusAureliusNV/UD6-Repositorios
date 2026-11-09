package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Producto;
import com.example.demo.service.CategoriaService;
import com.example.demo.service.ProductoService;


@Controller
@RequestMapping("/productos")
public class ProductoController {
	private static final String PRODUCTOS_VIEW="productos";
	private static final String FORM_VIEW="productoForm";
	
	private final ProductoService productoService;
	private final CategoriaService categoriaService;

	public ProductoController(ProductoService productoService, CategoriaService categoriaService) {
	    this.productoService = productoService;
		this.categoriaService = categoriaService;
	}
	
	@GetMapping({"", "/"})
	public ModelAndView listProductos() {

	    ModelAndView mav = new ModelAndView("productos");
	    mav.addObject("productos", productoService.listarProductos());

	    return mav;
	}
	
	@GetMapping("/formProducto")
	public String formProducto(Model model) {
		model.addAttribute("producto", new Producto());
		model.addAttribute("categorias", categoriaService.listarCategorias());
		model.addAttribute("editando", false);
		return FORM_VIEW;
	}
	
	@PostMapping("/formProducto")
	public String addProducto(@ModelAttribute("producto") Producto producto) {
		productoService.crearProducto(producto);
		return "redirect:/productos";
	}
	
	
	@PostMapping("/{id}/eliminarProducto")
	public String eliminarProducto(@PathVariable long id, @ModelAttribute("producto") Producto producto) {
		productoService.eliminarProducto(producto);
		return "redirect:/productos";
	}
	
	@GetMapping("/{id}/editar")
	public String editarProducto(long id, Model model) {
		Producto p = productoService.buscarPorId(id);
		
		model.addAttribute("producto", p);
		model.addAttribute("editando", true);
		model.addAttribute("categorias", categoriaService.listarCategorias());
		
		return FORM_VIEW;
	}
	
	@PostMapping("/{id}/editar")
	public String editar(@PathVariable long id, @ModelAttribute("producto") Producto producto) {

		productoService.crearProducto(producto);

		return "redirect:/productos";
	}
}
