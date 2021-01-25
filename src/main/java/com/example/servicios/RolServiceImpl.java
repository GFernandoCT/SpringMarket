package com.example.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.RolDao;
import com.example.entidades.Rol;

@Transactional
@Service
public class RolServiceImpl implements RolService{

	@Autowired
	private RolDao rolDao;

	@Override
	public Rol obtenerRol(int idRol) {
		// TODO Auto-generated method stub
		return rolDao.buscarPorId(idRol);
	}
	
	
}
