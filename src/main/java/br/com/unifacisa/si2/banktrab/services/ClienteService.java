package br.com.unifacisa.si2.banktrab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unifacisa.si2.banktrab.daos.ClienteDAO;
import br.com.unifacisa.si2.banktrab.dtos.ClienteDTO;
import br.com.unifacisa.si2.banktrab.dtos.MensagemErro;
import br.com.unifacisa.si2.banktrab.dtos.MensagemSucesso;
import br.com.unifacisa.si2.banktrab.exceptions.BankTrabException;
import br.com.unifacisa.si2.banktrab.models.Cliente;

@Service
public class ClienteService {

	@Autowired
	private ClienteDAO dao;

	public MensagemSucesso cadastrarCliente(ClienteDTO clienteDto) {

		Cliente cliente = new Cliente();

		if (dao.existysByNome(clienteDto.getNome())) {
			throw new BankTrabException(new MensagemErro("Cliente já existe"));
		}

		cliente.setCodigo(clienteDto.getCodigo());
		cliente.setNome(clienteDto.getNome());
		
		dao.save(cliente);

		return new MensagemSucesso("Sucesso ao cadastrar cliente e conta");
	}
}
