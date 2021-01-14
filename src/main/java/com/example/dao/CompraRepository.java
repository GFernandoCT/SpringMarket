package com.example.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.entidades.Compra;

@Repository
public interface CompraRepository extends CrudRepository<Compra,Long> {

}
