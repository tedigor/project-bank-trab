package br.com.si2.trabbank.trabbank.daos.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import br.com.si2.trabbank.trabbank.daos.ContaDAO;
import br.com.si2.trabbank.trabbank.models.Conta;

@Repository(value = "ContaDAO")
public class ContaDAOImpl extends BaseDAOImpl<Long, Conta> implements ContaDAO {

	@Override
	public List<Conta> findByNumero(Long numero) {

		CriteriaQuery<Conta> query = getCriteriaBuilder().createQuery(Conta.class);
		Root<Conta> from = query.from(Conta.class);

		query.where(getCriteriaBuilder().equal(from.get("numeroConta"), numero));
		return getEntityManager().createQuery(query).getResultList();
	}

}
