package br.com.si2.trabbank.trabbank.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.si2.trabbank.trabbank.dtos.ClienteDTO;
import br.com.si2.trabbank.trabbank.dtos.ExibirInfoClienteDTO;
import br.com.si2.trabbank.trabbank.dtos.MensagemSucesso;
import br.com.si2.trabbank.trabbank.services.ClienteService;

@Controller
@RequestMapping("cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@PostMapping
	public ResponseEntity<MensagemSucesso> save(@RequestBody ClienteDTO clienteDto) {
		return new ResponseEntity<MensagemSucesso>(clienteService.cadastrarCliente(clienteDto), HttpStatus.CREATED);
	}

	@GetMapping("saldo")
	public ResponseEntity<ExibirInfoClienteDTO> consultarSaldo(@RequestHeader("Authorization") String token) {
		return new ResponseEntity<ExibirInfoClienteDTO>(clienteService.consultarSaldo(token), HttpStatus.OK);
	}

	@GetMapping("extrato")
	public ResponseEntity<ExibirInfoClienteDTO> consultarExtrato(@RequestHeader("Authorization") String token) {
		return new ResponseEntity<ExibirInfoClienteDTO>(clienteService.consultarExtrato(token), HttpStatus.OK);
	}

}
