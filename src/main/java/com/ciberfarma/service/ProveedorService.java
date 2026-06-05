package com.ciberfarma.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ciberfarma.model.Proveedor;
import com.ciberfarma.repository.ProveedorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProveedorService {
	
	private final ProveedorRepository proveedorRepository;
	
	public List<Proveedor> getAll() {
		return proveedorRepository.findAll();
	}
}
