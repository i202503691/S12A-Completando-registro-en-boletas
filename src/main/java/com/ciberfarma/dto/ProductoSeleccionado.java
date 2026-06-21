package com.ciberfarma.dto;

import lombok.Data;

@Data
public class ProductoSeleccionado {
	private Integer idProducto;
	private String descripcion;
	private Double precio;
	private Integer cantidad;

	public Double getSubtotal() {
		return precio * cantidad;
	}
}