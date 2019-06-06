package br.com.si2.trabbank.trabbank.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.si2.trabbank.trabbank.daos.TipoTransacaoDAO;
import br.com.si2.trabbank.trabbank.models.TipoTransacao;

@Service
public class TipoTransacaoService {

	@Autowired
	private TipoTransacaoDAO dao;
	
	public TipoTransacao findById(Integer id) {
		return dao.findById(id);
	}
}
