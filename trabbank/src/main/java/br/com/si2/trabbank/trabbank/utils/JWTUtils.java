package br.com.si2.trabbank.trabbank.utils;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import br.com.si2.trabbank.trabbank.models.Conta;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTUtils {

	@Value("${jwt.expiration}")
	private Long expiration;

	@Value("${jwt.secret}")
	private String secret;

	public String generateToken(Conta conta) {
		return Jwts.builder().setSubject(conta.getNumeroConta().toString())
				.setExpiration(new Date(System.currentTimeMillis() + expiration))
				.signWith(SignatureAlgorithm.HS512, secret.getBytes()).compact();
	}

	public Long getSubject(String token) {
		Claims claims = getClaims(token);
		if (claims != null) {
			return Long.parseLong(claims.getSubject());
		}
		return null;
	}

	private Claims getClaims(String token) {
		try {
			return Jwts.parser().setSigningKey(secret.getBytes()).parseClaimsJws(token).getBody();
		} catch (Exception e) {
			return null;
		}
	}

}
