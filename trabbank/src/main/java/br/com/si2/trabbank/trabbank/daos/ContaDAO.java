package br.com.si2.trabbank.trabbank.daos;

import java.util.List;

import br.com.si2.trabbank.trabbank.models.Conta;

public interface ContaDAO extends BaseDAO<Long, Conta>{

	List<Conta> findByNumero(Long numero);

}
