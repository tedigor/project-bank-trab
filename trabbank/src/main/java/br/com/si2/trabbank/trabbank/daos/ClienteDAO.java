package br.com.si2.trabbank.trabbank.daos;

import br.com.si2.trabbank.trabbank.models.Cliente;

public interface ClienteDAO extends BaseDAO<Long, Cliente> {
	
	Boolean existysByNome(String nome);
	
}
