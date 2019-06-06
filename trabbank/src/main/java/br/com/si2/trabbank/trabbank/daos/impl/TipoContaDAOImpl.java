package br.com.si2.trabbank.trabbank.daos.impl;

import org.springframework.stereotype.Repository;

import br.com.si2.trabbank.trabbank.daos.TipoContaDAO;
import br.com.si2.trabbank.trabbank.models.TipoConta;

@Repository(value = "TipoContaDAO")
public class TipoContaDAOImpl extends BaseDAOImpl<Integer, TipoConta> implements TipoContaDAO {

}
