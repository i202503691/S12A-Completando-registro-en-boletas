package com.ciberfarma.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ciberfarma.model.Producto;
import com.ciberfarma.service.CategoriaService;
import com.ciberfarma.service.ProductoService;
import com.ciberfarma.service.ProveedorService;
import com.ciberfarma.util.Alert;

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
		model.addAttribute("producto", new Producto());
		return "producto/nuevo";
	}
	
	@PostMapping("registrar")
	public String registrar(
			@ModelAttribute Producto producto, 
			Model model, 
			RedirectAttributes flash) {
		
		var response = productoService.create(producto);
		
		if (!response.success()) {
			model.addAttribute("categorias", categoriaService.getAll());
			model.addAttribute("proveedores", proveedorService.getAll());
			model.addAttribute("producto", producto);
			model.addAttribute("alert", Alert.sweetAlertError(response.mensaje()));
			return "producto/nuevo";
		}
		
		var toast = Alert.sweetToast(response.mensaje(), "success", 5000);
		flash.addFlashAttribute("toast", toast);
		return "redirect:/producto/listado";
	}
	
	@GetMapping("edicion/{id}")
	public String edicion(@PathVariable Integer id,Model model) {
		model.addAttribute("categorias", categoriaService.getAll());
		model.addAttribute("proveedores", proveedorService.getAll());
		model.addAttribute("producto", productoService.getOne(id));
		return "producto/edicion";
	}
	
	@PostMapping("guardar")
	public String guardar(
			@ModelAttribute Producto producto, 
			Model model, 
			RedirectAttributes flash) {
		
		var response = productoService.update(producto);
		
		if (!response.success()) {
			model.addAttribute("categorias", categoriaService.getAll());
			model.addAttribute("proveedores", proveedorService.getAll());
			model.addAttribute("producto", producto);
			model.addAttribute("alert", Alert.sweetAlertError(response.mensaje()));
			return "producto/edicion";
		}
		
		var toast = Alert.sweetToast(response.mensaje(), "success", 5000);
		flash.addFlashAttribute("toast", toast);
		return "redirect:/producto/listado";
	}
	
	
	
	
	
}
