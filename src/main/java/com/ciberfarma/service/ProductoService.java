package com.ciberfarma.service;

import java.util.List;

import org.springframework.stereotype.Service;

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
	
	
	
	
	
	
	
	
	
	
	
}
