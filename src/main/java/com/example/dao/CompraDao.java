package com.example.dao;

import java.util.List;

import com.example.entidades.Compra;
import com.example.entidades.Pedido;
/*
public interface CompraDao extends DaoGenerico<Pedido>{
	
	public List<Pedido> listarPedidos(long idUsuario);
}

*/

public interface CompraDao extends DaoGenerico<Compra>{
	
	public List<Compra> listarPedidos(long idUsuario);
	
}

