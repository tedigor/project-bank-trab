package br.com.unifacisa.si2.banktrab.daos;

import br.com.unifacisa.si2.banktrab.models.Cliente;

public interface ClienteDAO extends BaseDAO<Long, Cliente> {
	
	Boolean existysByNome(String nome);
	
}
