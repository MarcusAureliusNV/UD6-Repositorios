package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Producto;
import com.example.demo.service.ProductoService;


@Controller
@RequestMapping("/productos")
public class ProductoController {
	private static final String PRODUCTOS_VIEW="productos";
	private static final String FORM_VIEW="productoForm";
	
	private final ProductoService productoService;

	public ProductoController(ProductoService productoService) {
	    this.productoService = productoService;
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
		return FORM_VIEW;
	}
	
	@PostMapping("/addProducto")
	public String addProducto(@ModelAttribute("producto") Producto producto) {
		productoService.crearProducto(producto);
		return "redirect:/productos/listProductos";
	}
}
