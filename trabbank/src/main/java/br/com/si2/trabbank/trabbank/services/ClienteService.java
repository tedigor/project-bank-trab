package br.com.si2.trabbank.trabbank.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.si2.trabbank.trabbank.builders.ContaBuilder;
import br.com.si2.trabbank.trabbank.constants.MensagensConstants;
import br.com.si2.trabbank.trabbank.daos.ClienteDAO;
import br.com.si2.trabbank.trabbank.dtos.ClienteDTO;
import br.com.si2.trabbank.trabbank.dtos.ExibirInfoClienteDTO;
import br.com.si2.trabbank.trabbank.dtos.MensagemErro;
import br.com.si2.trabbank.trabbank.dtos.MensagemSucesso;
import br.com.si2.trabbank.trabbank.enums.TipoConta;
import br.com.si2.trabbank.trabbank.exceptions.BankTrabException;
import br.com.si2.trabbank.trabbank.models.Cliente;
import br.com.si2.trabbank.trabbank.models.Conta;

@Service
public class ClienteService {

	@Autowired
	private ClienteDAO dao;

	@Autowired
	private ContaService contaService;

	@Autowired
	private ContaBuilder contaBuilder;

	public MensagemSucesso cadastrarCliente(ClienteDTO clienteDto) {

		Cliente cliente = new Cliente();

		validarNomeConta(clienteDto);

		cliente.setCodigo(clienteDto.getCodigo());
		cliente.setNome(clienteDto.getNome());

		dao.save(cliente);

		Conta conta;

		conta = gerarConta(clienteDto);

		conta.setCliente(cliente);
		conta.setSenha(clienteDto.getSenha());

		contaService.save(conta);

		return new MensagemSucesso(MensagensConstants.MENSAGEM_SUCESSO_03 + conta.getNumeroConta());
	}

	private Conta gerarConta(ClienteDTO clienteDto) {
		Conta conta;
		if (TipoConta.CONTA_CORRENTE.equals(clienteDto.getTipoConta())) {
			conta = contaBuilder.contaCorrenteBuild();
		} else {
			conta = contaBuilder.contaPoupancaBuild();
		}
		return conta;
	}

	private void validarNomeConta(ClienteDTO clienteDto) {
		if (dao.existysByNome(clienteDto.getNome())) {
			throw new BankTrabException(new MensagemErro(MensagensConstants.MENSAGEM_ERRO_04));
		}
	}

}
