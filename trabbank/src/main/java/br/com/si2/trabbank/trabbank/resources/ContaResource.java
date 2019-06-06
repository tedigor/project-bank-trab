package br.com.si2.trabbank.trabbank.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.si2.trabbank.trabbank.dtos.MensagemSucesso;
import br.com.si2.trabbank.trabbank.models.Conta;
import br.com.si2.trabbank.trabbank.services.ContaService;

@Controller
@RequestMapping("/conta")
public class ContaResource {

	@Autowired
	private ContaService contaService;

	@GetMapping
	public ResponseEntity<List<Conta>> listarContas() {
		return new ResponseEntity<List<Conta>>(contaService.findAll(), HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<MensagemSucesso> desativarConta(Long id) {
		return new ResponseEntity<MensagemSucesso>(contaService.desativarConta(id), HttpStatus.OK);
	}

}
