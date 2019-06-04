package br.com.unifacisa.si2.banktrab.daos.impl;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import br.com.unifacisa.si2.banktrab.daos.ClienteDAO;
import br.com.unifacisa.si2.banktrab.models.Cliente;

@Repository(value = "ClienteDAO")
public class ClienteDAOImpl extends BaseDAOImpl<Long, Cliente> implements ClienteDAO {

	public Boolean existysByNome(String nome) {

		CriteriaQuery<Cliente> query = getCriteriaBuilder().createQuery(Cliente.class);
		Root<Cliente> from = query.from(Cliente.class);

		query.where(getCriteriaBuilder().equal(from.get("nome"), nome));
		
		return !getEntityManager().createQuery(query).getResultList().isEmpty();
	}

}
