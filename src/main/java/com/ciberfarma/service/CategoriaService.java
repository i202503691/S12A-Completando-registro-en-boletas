package com.ciberfarma.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ciberfarma.model.Categoria;
import com.ciberfarma.repository.CategoriaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoriaService {
	
	private final CategoriaRepository categoriaRepository;
	
	public List<Categoria> getAll() {
		return categoriaRepository.findAll();
	}
}
