package br.com.unifacisa.si2.banktrab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unifacisa.si2.banktrab.daos.ContaDAO;

@Service
public class ContaService {
	
	@Autowired
	private ContaDAO dao;

}
