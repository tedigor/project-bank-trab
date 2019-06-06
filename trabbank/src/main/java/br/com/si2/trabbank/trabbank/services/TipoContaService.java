
package br.com.si2.trabbank.trabbank.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.si2.trabbank.trabbank.daos.TipoContaDAO;
import br.com.si2.trabbank.trabbank.models.TipoConta;

@Service
public class TipoContaService {

	@Autowired
	private TipoContaDAO dao;
	
	public TipoConta findById(Integer id) {
		return dao.findById(id);
	}
}
