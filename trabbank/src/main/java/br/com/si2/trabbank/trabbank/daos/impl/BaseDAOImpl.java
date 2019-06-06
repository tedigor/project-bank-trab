package br.com.si2.trabbank.trabbank.daos.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import br.com.si2.trabbank.trabbank.daos.BaseDAO;
import br.com.si2.trabbank.trabbank.models.EntityBase;

public class BaseDAOImpl<K extends Serializable, T extends EntityBase<K>> implements BaseDAO<K, T> {

	@PersistenceContext
	private EntityManager em;

	private Class<T> classe;

	@SuppressWarnings("unchecked")
	public BaseDAOImpl() {
		this.classe = (Class<T>) getTypeClass();
	}

	public List<T> findAll() {

		CriteriaQuery<T> query = getCriteriaBuilder().createQuery(classe);
		Root<T> from = query.from(classe);
		query.select(from);

		return getEntityManager().createQuery(query).getResultList();
	}

	@Transactional(value = TxType.REQUIRED)
	public T save(T entity) {

		if (entity.getId() != null) {
			getEntityManager().merge(entity);
		} else {
			entity.setAtivo(true);
			getEntityManager().persist(entity);
		}

		return entity;
	}

	@Transactional(value = TxType.REQUIRED)
	public T deleteById(K id) {

		T entity = getEntityManager().find(classe, id);
		entity.setAtivo(false);
		getEntityManager().merge(entity);

		return entity;
	}

	public T findById(K id) {
		return getEntityManager().find(classe, id);
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
