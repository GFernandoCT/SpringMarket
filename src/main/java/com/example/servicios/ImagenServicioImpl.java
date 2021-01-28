package com.example.servicios;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.example.dao.ImagenRepository;
import com.example.dao.ProductoRepository;
import com.example.entidades.Imagen;
import com.example.entidades.Producto;

@Transactional
@Service
public class ImagenServicioImpl implements ImagenServicio{

	@Autowired
	private ImagenRepository imagenRepository;

	@Autowired
	private ProductoRepository productoRepository;

	public int guardarImagen(Imagen img) {
		try {
			imagenRepository.save(img);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	public Imagen obtenerImagen(Long id) {
		Imagen findById = imagenRepository.findById(id).orElse(null);
		
		if (findById != null) {
			Imagen getImageDetails = findById;
			return findById;
		} else {
			return null;
		}
	}

	public Boolean actualizarImagen(long idProducto, MultipartFile file) {

		Producto p = productoRepository.findById(idProducto).orElse(null);

		if (p == null)
			return false;
		try {
			byte[] image = file.getBytes();
			if (!p.getImagen().isEmpty()) {

				Set<Imagen> limg = p.getImagen();
				for (Imagen a : limg) {
					a.setImagen(image);
					imagenRepository.save(a);
					return true;
				}
				return null;

			} else {
				Imagen img = new Imagen("foto", image);
				p.anadirImagen(img);
				productoRepository.save(p);
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}
