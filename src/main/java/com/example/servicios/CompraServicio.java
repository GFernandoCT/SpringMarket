package com.example.servicios;

import java.util.List;

import com.example.entidades.Pedido;

public interface CompraServicio {

	public List<Pedido> listarPedidos(long idUsuario);

	public Pedido obtenerPedido(long idPedido);
}
