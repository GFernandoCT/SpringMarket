package com.example.controladores;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.entidades.Imagen;
import com.example.entidades.Producto;
import com.example.servicios.ImagenServicio;
import com.example.servicios.ProductoServicio;

@Controller
@RequestMapping(value = "/imagenes")
public class ImagenControlador {

	@Autowired
	private ImagenServicio imgServicio;

	@Autowired
	ProductoServicio productoService;

	@GetMapping("/cargar/{idProducto}")
	public ModelAndView actualizarFotoPerfil(HttpServletRequest request, @PathVariable("idProducto") long idProducto) {

		ModelAndView mav = new ModelAndView();

		Producto producto = productoService.obtenerProducto(idProducto);
		Imagen img = null;
		if (!producto.getImagen().isEmpty()) {
			for (Imagen i : producto.getImagen()) {
				img = i;
				break;
			}
		}
		mav.addObject("imagen", img);
		mav.addObject("producto", producto);
		mav.setViewName("/imagen/imagen_subir");
		return mav;
	}

	@PostMapping("/cargar/{idProducto}")
	public String fileUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request,
			@PathVariable("idProducto") long idProducto) {
		try {
			byte[] image = file.getBytes();
			Imagen img = new Imagen("foto", image);
			Boolean saveImage = imgServicio.actualizarImagen(idProducto, file);
			if (saveImage) {
				return "redirect:/Producto/" + idProducto;
			} else {
				return "redirect:/imagenes/cargar/" + idProducto;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/imagenes/cargar/" + idProducto;
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity getImageAsResponseEntity(@PathVariable String id) {

		try {
			Imagen imagesObj = imgServicio.obtenerImagen(Long.parseLong(id));
			byte[] media = imagesObj.getImagen();
			HttpHeaders headers = new HttpHeaders();
			headers.setCacheControl(CacheControl.noCache().getHeaderValue());

			ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(media, headers, HttpStatus.OK);
			return responseEntity;

		} catch (Exception e) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
	}
	
}
