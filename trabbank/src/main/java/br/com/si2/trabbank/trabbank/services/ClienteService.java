package br.com.si2.trabbank.trabbank.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.si2.trabbank.trabbank.daos.ClienteDAO;
import br.com.si2.trabbank.trabbank.dtos.ClienteDTO;
import br.com.si2.trabbank.trabbank.dtos.MensagemErro;
import br.com.si2.trabbank.trabbank.dtos.MensagemSucesso;
import br.com.si2.trabbank.trabbank.exceptions.BankTrabException;
import br.com.si2.trabbank.trabbank.models.Cliente;

@Service
public class ClienteService {

	@Autowired
	private ClienteDAO dao;

	public MensagemSucesso cadastrarCliente(ClienteDTO clienteDto) {

		Cliente cliente = new Cliente();

		if (dao.existysByNome(clienteDto.getNome())) {
			throw new BankTrabException(new MensagemErro("Cliente j� existe"));
		}

		cliente.setCodigo(clienteDto.getCodigo());
		cliente.setNome(clienteDto.getNome());
		
		dao.save(cliente);

		return new MensagemSucesso("Sucesso ao cadastrar cliente e conta");
	}
}
