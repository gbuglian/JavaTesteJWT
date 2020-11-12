package br.salaoEveris.app.response;

import java.util.List;

import br.salaoEveris.app.model.RelatorioAgendamento;

public class AgendamentoListResponse extends BaseResponse{
	
	private List <RelatorioAgendamento> relatorio;

	public List<RelatorioAgendamento> getRelatorio() {
		return relatorio;
	}

	public void setRelatorio(List<RelatorioAgendamento> relatorio) {
		this.relatorio = relatorio;
	}
	
	

}
