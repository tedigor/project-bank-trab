package br.com.si2.trabbank.trabbank.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import br.com.si2.trabbank.trabbank.models.Conta;
import br.com.si2.trabbank.trabbank.utils.JWTUtils;

@Service
public class TokenService {

	@Autowired
	private JWTUtils jwtUtil;

	private static final String HEADER_AUTHORIZATION = "Authorization";
	private static final String TOKEN_PREFIX = "Bearer ";

	public HttpHeaders addTokenToHeader(Conta conta, String token) {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set(HEADER_AUTHORIZATION, TOKEN_PREFIX + token);
		return responseHeaders;
	}

	public String generateToken(Conta conta) {
		return jwtUtil.generateToken(conta);
	}

	public Long getNumeroConta(String token) {
		return jwtUtil.getSubject(token.substring(7));
	}

}
