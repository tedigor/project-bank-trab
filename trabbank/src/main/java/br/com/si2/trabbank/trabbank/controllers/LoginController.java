package br.com.si2.trabbank.trabbank.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.si2.trabbank.trabbank.dtos.CredenciaisDTO;
import br.com.si2.trabbank.trabbank.services.LoginService;

@Controller
@RequestMapping("login")
public class LoginController {

	@Autowired
	private LoginService loginService;

	@PostMapping
	public ResponseEntity<Void> login(@RequestBody CredenciaisDTO credenciaisDTO) {
		return ResponseEntity.ok().headers(loginService.logar(credenciaisDTO)).build();
	}

}
