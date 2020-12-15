package com.example.dao;

import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.entidades.Pedido;

@Repository
@Component("CompraDao")
public class CompraDaoImpl extends DaoGenericoImpl<Pedido> implements CompraDao {

}
