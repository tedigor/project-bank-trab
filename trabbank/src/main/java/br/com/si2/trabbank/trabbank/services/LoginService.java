package br.com.si2.trabbank.trabbank.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import br.com.si2.trabbank.trabbank.dtos.CredenciaisDTO;
import br.com.si2.trabbank.trabbank.models.Conta;

@Service
public class LoginService {

	@Autowired
	private ContaService contaService;

	@Autowired
	private TokenService tokenService;

	public HttpHeaders logar(CredenciaisDTO credenciaisDTO) {

		Conta conta = contaService.findByNumero(credenciaisDTO.getNumero());
		String token = tokenService.generateToken(conta);
		return tokenService.addTokenToHeader(conta, token);
	}

}
