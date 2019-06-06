package br.com.si2.trabbank.trabbank.daos.impl;

import org.springframework.stereotype.Repository;

import br.com.si2.trabbank.trabbank.daos.TipoTransacaoDAO;
import br.com.si2.trabbank.trabbank.models.TipoTransacao;

@Repository(value = "TipoTransacaoDAO")
public class TipoTransacaoDAOImpl extends BaseDAOImpl<Integer, TipoTransacao> implements TipoTransacaoDAO {

}
