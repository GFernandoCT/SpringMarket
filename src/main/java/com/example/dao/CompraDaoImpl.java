package com.example.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.entidades.Pedido;
import com.example.entidades.Usuario;

@Repository
@Component("CompraDao")
public class CompraDaoImpl extends DaoGenericoImpl<Pedido> implements CompraDao {

	@Override
	public List<Pedido> listarPedidos(long idUsuario) {
		Query query = this.em.createQuery("select u FROM Pedido u where u.usuario =: idUsuario");
		query.setParameter("idUsuario", idUsuario);
		List<Pedido> lPedido = query.getResultList();
		return null;
	}

}
