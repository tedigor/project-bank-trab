package br.com.unifacisa.si2.banktrab.daos.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.unifacisa.si2.banktrab.daos.BaseDAO;
import br.com.unifacisa.si2.banktrab.models.EntityBase;

public class BaseDAOImpl<K extends Serializable, T extends EntityBase<K>> implements BaseDAO<K, T> {

	@PersistenceContext
	private EntityManager em;

	private Class<T> classe;

	public BaseDAOImpl() {
		this.classe = (Class<T>) getTypeClass();
	}

	public List<T> findAll() {
		
		CriteriaQuery<T> query = getCriteriaBuilder().createQuery(classe);
		Root<T> from = query.from(classe);
		query.select(from);

		return getEntityManager().createQuery(query).getResultList();
	}

	protected EntityManager getEntityManager() {
		return em;
	}

	protected CriteriaBuilder getCriteriaBuilder() {
		return em.getCriteriaBuilder();
	}

	private Class<?> getTypeClass() {
		return (Class<?>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
	}

}
