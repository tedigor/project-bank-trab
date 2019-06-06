package br.com.si2.trabbank.trabbank.daos.impl;

import org.springframework.stereotype.Repository;

import br.com.si2.trabbank.trabbank.daos.TransacaoDAO;
import br.com.si2.trabbank.trabbank.models.Transacao;

@Repository(value = "TransacaoDao")
public class TransacaoDAOImpl extends BaseDAOImpl<Long, Transacao> implements TransacaoDAO{

}
