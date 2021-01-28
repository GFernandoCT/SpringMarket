package com.example.servicios;

import org.springframework.web.multipart.MultipartFile;

import com.example.entidades.Imagen;

public interface ImagenServicio {
	
	public int guardarImagen(Imagen img);
	
	public Imagen obtenerImagen(Long id);
	
	public Boolean actualizarImagen(long idProducto,MultipartFile file);

}
