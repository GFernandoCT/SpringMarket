package com.example.dao;

import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.entidades.Rol;


@Repository
@Component("RolDao")
public class RolDaoImpl extends DaoGenericoImpl<Rol> implements RolDao{

	@Override
	public Rol buscarPorId(int idRol) {
		Query query=
			this.em.createQuery("select u FROM Rol u where u.idRol =: idRol");
			query.setParameter("idRol", idRol);
			Rol rol = (Rol) query.getSingleResult();
			
			if (rol != null) {
				return rol;
			}
		return null;
	}

	
	
}
