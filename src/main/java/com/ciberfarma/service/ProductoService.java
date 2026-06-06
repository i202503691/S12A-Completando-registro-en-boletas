package com.ciberfarma.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ciberfarma.dto.ResultadoResponse;
import com.ciberfarma.model.Producto;
import com.ciberfarma.repository.ProductoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductoService {
	
	private final ProductoRepository productoRepository;
	
	public List<Producto> getAll() {
		return productoRepository.findAllByOrderByIdProductoDesc();
	}
	
	public ResultadoResponse create(Producto producto) {
		try {
			var registro = productoRepository.save(producto);
			var mensaje = String.format("Producto con Id %s registrado", registro.getIdProducto());
			
			return new ResultadoResponse(true, mensaje);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultadoResponse(false, "Hubo un error en la transacción");
		}
	}
	
	
	public Producto getOne(Integer idProducto) {
		return productoRepository.findById(idProducto).orElseThrow();
	}
	
	public ResultadoResponse update(Producto producto) {
		try {
			var registro = productoRepository.save(producto);
			var mensaje = String.format("Producto con Id %s actualizado", registro.getIdProducto());
			
			return new ResultadoResponse(true, mensaje);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultadoResponse(false, "Hubo un error en la transacción");
		}
	}
	
	
	
	
	
	
	
}
