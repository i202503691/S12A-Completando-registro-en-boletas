package com.ciberfarma.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ciberfarma.service.CategoriaService;
import com.ciberfarma.service.ProductoService;
import com.ciberfarma.service.ProveedorService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("producto")
public class ProductoController {
	
	private final ProductoService productoService;
	private final CategoriaService categoriaService;
	private final ProveedorService proveedorService;
	
	@GetMapping("listado")
	public String listado(Model model) {
		model.addAttribute("lstProductos", productoService.getAll());
		return "producto/listado";
	}
	
	@GetMapping("nuevo")
	public String nuevo(Model model) {
		model.addAttribute("categorias", categoriaService.getAll());
		model.addAttribute("proveedores", proveedorService.getAll());
		return "producto/nuevo";
	}
	
	
	
	
	
	
	
	
	
}
