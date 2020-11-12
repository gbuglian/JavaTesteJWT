package br.salaoEveris.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.salaoEveris.app.model.Agendamento;
import br.salaoEveris.app.repository.AgendamentoRepository;
import br.salaoEveris.app.request.AgendamentoRequest;
import br.salaoEveris.app.response.AgendamentoResponse;
import br.salaoEveris.app.response.BaseResponse;

@Service
public class AgendamentoService {
	
	@Autowired
	private AgendamentoRepository _repository;
	
	public BaseResponse inserir(AgendamentoRequest request) {
		Agendamento agendamento = new Agendamento();
		BaseResponse base = new BaseResponse();
		base.statusCode = 400;
		
		if(request.getdata() == null) {
			base.message = "Data de agendamento não informado!";
			return base;
		}
		
		if(request.getCliente() == null) {
			base.message = "Cliente não informado!";
			return base;
		}
		
		 if(request.getServico() == null) {
			base.message = "Servico não informado!";
			return base;
		}
		
		agendamento.setCliente(request.getCliente());
		agendamento.setServico(request.getServico());
		agendamento.setData(request.getdata());
		
		_repository.save(agendamento);
		
		base.statusCode = 201;
		base.message = "Agendamento Realizado";
		return base;
	}
	
	public BaseResponse obter(Long id) {
		Optional<Agendamento> agendamento = _repository.findById(id);
		AgendamentoResponse response = new AgendamentoResponse();
		response.statusCode = 400;
		
		if(agendamento.isEmpty()) {
			response.message = "Agendamento não localizado";
			return response;
		}
		
		if(agendamento.get().getId() == null) {
			response.message = "Id de agendamento não informado, tente novamente!";
			return response;
		}
		
		response.setCliente(agendamento.get().getCliente());
		response.setData(agendamento.get().getData());
		response.setServico(agendamento.get().getServico());
		response.setId(agendamento.get().getId());
		
		
		response.statusCode = 200;
		response.message = "Agendamento obtido com sucesso!";
		
		return response;
	}

}
