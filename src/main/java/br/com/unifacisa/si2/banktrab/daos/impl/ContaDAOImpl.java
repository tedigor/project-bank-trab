package br.com.unifacisa.si2.banktrab.daos.impl;

import org.springframework.stereotype.Repository;

import br.com.unifacisa.si2.banktrab.daos.ContaDAO;
import br.com.unifacisa.si2.banktrab.models.Conta;

@Repository
public class ContaDAOImpl extends BaseDAOImpl<Long, Conta> implements ContaDAO{

}
