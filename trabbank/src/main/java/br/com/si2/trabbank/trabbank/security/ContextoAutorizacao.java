package br.com.si2.trabbank.trabbank.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.si2.trabbank.trabbank.constants.MensagensConstants;
import br.com.si2.trabbank.trabbank.dtos.MensagemErro;
import br.com.si2.trabbank.trabbank.exceptions.BankTrabException;
import br.com.si2.trabbank.trabbank.models.Conta;
import br.com.si2.trabbank.trabbank.services.ContaService;
import br.com.si2.trabbank.trabbank.services.TokenService;

@Component
public class ContextoAutorizacao {

	@Autowired
	private ContaService contaService;

	@Autowired
	private TokenService tokenService;

	public Conta getConta(String token) {

		if (token.isEmpty()) {
			throw new BankTrabException(new MensagemErro(MensagensConstants.MENSAGEM_ERRO_10));
		}

		Long numero = tokenService.getNumeroConta(token);

		Conta c = contaService.findByNumero(numero);

		if (c == null) {
			throw new BankTrabException(new MensagemErro(MensagensConstants.MENSAGEM_ERRO_07));
		}

		return c;
	}

}
