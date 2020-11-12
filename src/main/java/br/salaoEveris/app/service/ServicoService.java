package br.salaoEveris.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.salaoEveris.app.model.Servico;
import br.salaoEveris.app.repository.ServicoRepository;
import br.salaoEveris.app.request.ServicoRequest;
import br.salaoEveris.app.response.BaseResponse;
import br.salaoEveris.app.response.ServicoListResponse;
import br.salaoEveris.app.response.ServicoResponse;

@Service
public class ServicoService {

	@Autowired
	private ServicoRepository _repository;

	public BaseResponse inserir(ServicoRequest servicoRequest) {
		Servico servico = new Servico();
		BaseResponse base = new BaseResponse();
		base.statusCode = 400;

		if (servicoRequest.getNome() == "") {
			base.message = "Nome do serviço não informado!";
			return base;
		}

		if (servicoRequest.getValor() == 0) {
			base.message = "Valor do serviço não informado";
			return base;
		}

		servico.setNome(servicoRequest.getNome());
		servico.setValor(servicoRequest.getValor());

		_repository.save(servico);

		base.statusCode = 201;
		base.message = "Serviço inserido com sucesso!";
		return base;

	}

	public ServicoResponse obter(Long id) {
		Optional<Servico> servico = _repository.findById(id);
		ServicoResponse response = new ServicoResponse();
		response.statusCode = 400;

		if (servico.isEmpty()) {
			response.message = "Serviço não localizado!";
			return response;
		}

		if (servico.get().getId() == 0) {
			response.message = "Serviço não localizado!";
			return response;
		}

		if (servico.get().getNome() == "") {
			response.message = "Nome de serviço não localizado";
			return response;
		}

		if (servico.get().getValor() == 0) {
			response.message = "Valor de serviço não localizado!";
			return response;
		}

		response.setId(servico.get().getId());
		response.setNome(servico.get().getNome());
		response.setValor(servico.get().getValor());
		
		response.statusCode = 200;
		response.message = "Serviço obtido com sucesso!";
		
		return response;
	}

	public ServicoListResponse listar() {
		List<Servico> lista = _repository.findAll();
		ServicoListResponse response = new ServicoListResponse();

		response.setServico(lista);
		response.statusCode = 200;
		response.message = "Serviços obtidos com sucesso.";

		return response;
	}

}
