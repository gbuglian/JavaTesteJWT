package br.salaoEveris.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.salaoEveris.app.model.*;
import br.salaoEveris.app.repository.ClienteRepository;
import br.salaoEveris.app.request.ClienteRequest;
import br.salaoEveris.app.response.BaseResponse;
import br.salaoEveris.app.response.ClienteListResponse;
import br.salaoEveris.app.response.ClienteResponse;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository _repository;

	public BaseResponse inserir(ClienteRequest clienteRequest) {
		Cliente cliente = new Cliente();
		BaseResponse base = new BaseResponse();

		if (clienteRequest.getNome() == "") {
			base.message = "Erro, nome não inserido!";
			base.statusCode = 400;
			return base;
		}

		if (clienteRequest.getCpf() == "") {
			base.message = "Erro, CPF não inserido!";
			base.statusCode = 400;
			return base;
		}

		if (clienteRequest.getTelefone() == "") {
			base.message = "Erro, telefone não inserido!";
			base.statusCode = 400;
			return base;
		}

		if (clienteRequest.getEndereco() == "") {
			base.message = "Erro, endereço não inserido!";
			base.statusCode = 400;
			return base;
		}

		cliente.setNome(clienteRequest.getNome());
		cliente.setCpf(clienteRequest.getCpf());
		cliente.setTelefone(clienteRequest.getTelefone());
		cliente.setEndereco(clienteRequest.getEndereco());

		_repository.save(cliente);

		base.statusCode = 201;
		base.message = "Cliente Inserido com sucesso!";

		return base;
	}

	public ClienteResponse obter(Long id) {
		Optional<Cliente> cliente = _repository.findById(id);
		ClienteResponse response = new ClienteResponse();
		response.statusCode = 400;

		if (cliente.isEmpty()) {
			response.message = "Cliente não localizado!";
			return response;
		}

		if (cliente.get().getId() == 0) {
			response.message = "Cliente não localizado!";
			return response;
		}

		if (cliente.get().getId() == null) {
			response.message = "Id não informado, tente novamente";
			return response;
		}

		response.setId(cliente.get().getId());
		response.setNome(cliente.get().getNome());
		response.setTelefone(cliente.get().getTelefone());
		response.setEndereco(cliente.get().getEndereco());

		response.statusCode = 200;
		response.message = "Cliente Obtido com sucesso!";

		return response;

	}

	public ClienteListResponse listar() {
		List<Cliente> lista = _repository.findAll();
		List<ClienteResponse> listaResposta = new ArrayList<ClienteResponse>();
		ClienteListResponse response = new ClienteListResponse();
		ClienteResponse cliente = new ClienteResponse();

		for (Cliente c : lista) {

			cliente = new ClienteResponse();
			cliente.setId(c.getId());
			cliente.setEndereco(c.getEndereco());
			cliente.setTelefone(c.getTelefone());
			cliente.setNome(c.getNome());

			listaResposta.add(cliente);
		}

		response.setClientes(listaResposta);

		response.statusCode = 200;
		response.message = "Clientes obtidos com sucesso.";

		return response;
	}
}
