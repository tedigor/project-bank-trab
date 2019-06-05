package br.com.si2.trabbank.trabbank.daos.impl;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import br.com.si2.trabbank.trabbank.daos.ClienteDAO;
import br.com.si2.trabbank.trabbank.models.Cliente;

@Repository(value = "ClienteDAO")
public class ClienteDAOImpl extends BaseDAOImpl<Long, Cliente> implements ClienteDAO {

	public Boolean existysByNome(String nome) {

		CriteriaQuery<Cliente> query = getCriteriaBuilder().createQuery(Cliente.class);
		Root<Cliente> from = query.from(Cliente.class);

		query.where(getCriteriaBuilder().equal(from.get("nome"), nome));
		
		return !getEntityManager().createQuery(query).getResultList().isEmpty();
	}

}
