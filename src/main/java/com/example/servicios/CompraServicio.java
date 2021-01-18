package com.example.servicios;

import java.util.List;

import com.example.entidades.Compra;
import com.example.entidades.Pedido;

public interface CompraServicio {

	public List<Compra> listarPedidos(long idUsuario);
	
	public List<Compra> listarPedidos2(long idUsuario);

	public Compra obtenerPedido(long idPedido);
	
	public Compra crearCompra(Compra compra);
}
