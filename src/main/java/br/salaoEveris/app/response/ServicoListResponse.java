package br.salaoEveris.app.response;

import java.util.List;

import br.salaoEveris.app.model.Servico;

public class ServicoListResponse extends BaseResponse {
	
	private List <ServicoResponse> servicos;
	private List <Servico> servico;
	
	public List<ServicoResponse> getServicos() {
		return servicos;
	}
	public void setServicos(List<ServicoResponse> servicos) {
		this.servicos = servicos;
	}
	public List<Servico> getServico() {
		return servico;
	}
	public void setServico(List<Servico> servico) {
		this.servico = servico;
	}
}
