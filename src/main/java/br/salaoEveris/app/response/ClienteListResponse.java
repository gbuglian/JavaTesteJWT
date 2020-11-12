package br.salaoEveris.app.response;

import java.util.List;

import br.salaoEveris.app.model.Cliente;

public class ClienteListResponse extends BaseResponse {

	private List<ClienteResponse> Cliente;

	public List<ClienteResponse> getClientes() {
		return Cliente;
	}

	public void setClientes(List<ClienteResponse> clientes) {
		Cliente = clientes;
	}


}
