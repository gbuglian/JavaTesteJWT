package br.salaoEveris.app.request;


import java.util.Date;

import br.salaoEveris.app.model.Cliente;
import br.salaoEveris.app.model.Servico;

public class AgendamentoRequest {
	
	private Date data;
	private Servico servico;
	private Cliente cliente;

	public Date getdata() {
		return data;
	}

	public void setdata(Date data) {
		this.data = data;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
