package com.example.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.CompraDao;
import com.example.entidades.Pedido;

@Transactional
@Service
public class CompraServicioImpl implements CompraServicio {

	@Autowired
	private CompraDao compraDao;
	
	@Override
	public List<Pedido> listarPedidos(long idUsuario) {
		return compraDao.listarPedidos(idUsuario);
	}

}
