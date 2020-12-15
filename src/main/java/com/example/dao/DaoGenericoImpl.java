package com.example.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public abstract class DaoGenericoImpl<T> implements DaoGenerico<T> {

	@PersistenceContext
	protected EntityManager em;

	private Class<T> type;

	public DaoGenericoImpl() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		type = (Class) pt.getActualTypeArguments()[0];
	}

	@Override
	public long contarTodos(final Map<String, Object> params) {
		final StringBuffer queryString = new StringBuffer("SELECT count(o) from ");
		queryString.append(type.getSimpleName()).append(" o ");
		queryString.append(this.getQueryClauses(params, null));
		final Query query = this.em.createQuery(queryString.toString());
		return (Long) query.getSingleResult();
	}

	@Override
	public T crear(final T t) {
		this.em.persist(t);
		return t;
	}

	@Override
	public T buscar(final Object id) {
		return (T) this.em.find(type, id);
	}

	@Override
	public T actualizar(final T t) {
		return this.em.merge(t);
	}

	@Override
	public void borrar(final Object id) {
		this.em.remove(this.em.getReference(type, id));
	}

	private String getQueryClauses(final Map<String, Object> params, final Map<String, Object> orderParams) {
		final StringBuffer queryString = new StringBuffer();
		if ((params != null) && !params.isEmpty()) {
			queryString.append(" where ");
			for (final Iterator<Map.Entry<String, Object>> it = params.entrySet().iterator(); it.hasNext();) {
				final Map.Entry<String, Object> entry = it.next();
				if (entry.getValue() instanceof Boolean) {
					queryString.append(entry.getKey()).append(" is ").append(entry.getValue()).append(" ");
				} else {
					if (entry.getValue() instanceof Number) {
						queryString.append(entry.getKey()).append(" = ").append(entry.getValue());
					} else {
						// string equality
						queryString.append(entry.getKey()).append(" = '").append(entry.getValue()).append("'");
					}
				}
				if (it.hasNext()) {
					queryString.append(" and ");
				}
			}
		}
		if ((orderParams != null) && !orderParams.isEmpty()) {
			queryString.append(" order by ");
			for (final Iterator<Map.Entry<String, Object>> it = orderParams.entrySet().iterator(); it.hasNext();) {
				final Map.Entry<String, Object> entry = it.next();
				queryString.append(entry.getKey()).append(" ");
				if (entry.getValue() != null) {
					queryString.append(entry.getValue());
				}
				if (it.hasNext()) {
					queryString.append(", ");
				}
			}
		}
		return queryString.toString();
	}
}
