package com.ciberfarma.service;

import org.springframework.stereotype.Service;

import com.ciberfarma.dto.AutentacionFilter;
import com.ciberfarma.model.Usuario;
import com.ciberfarma.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AutenticacionService {
	private final UsuarioRepository usuarioRepository;
	
	public Usuario autenticathe(AutentacionFilter filter) {
		return usuarioRepository.findByCuentaAndClave(filter.getCuenta(), filter.getClave());
	}
	
}
