package com.example.dao;

import com.example.entidades.Rol;

public interface RolDao extends DaoGenerico<Rol>{

	public Rol buscarPorId(int idRol);
	
}
