package br.com.unifacisa.si2.banktrab.daos.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class EntityManagerUtil {

	@PersistenceContext
	private EntityManager em;
	
	public EntityManager getEntityManager() {
		return em;
	}
	
}
