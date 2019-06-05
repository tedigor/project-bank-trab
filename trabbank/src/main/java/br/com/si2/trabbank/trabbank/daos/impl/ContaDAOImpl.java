package br.com.si2.trabbank.trabbank.daos.impl;

import org.springframework.stereotype.Repository;

import br.com.si2.trabbank.trabbank.daos.ContaDAO;
import br.com.si2.trabbank.trabbank.models.Conta;

@Repository(value = "ContaDAO")
public class ContaDAOImpl extends BaseDAOImpl<Long, Conta> implements ContaDAO{

}
