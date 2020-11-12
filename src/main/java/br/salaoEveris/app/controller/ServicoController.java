package br.salaoEveris.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.salaoEveris.app.request.ServicoRequest;
import br.salaoEveris.app.response.BaseResponse;
import br.salaoEveris.app.response.ServicoListResponse;
import br.salaoEveris.app.response.ServicoResponse;
import br.salaoEveris.app.service.ServicoService;

@RestController
@RequestMapping("/servico")
public class ServicoController extends BaseController {

	@Autowired
	private ServicoService service;

	@PostMapping
	public ResponseEntity inserir(@RequestBody ServicoRequest request) {
		try {
			BaseResponse response = service.inserir(request);

			return ResponseEntity.status(response.statusCode).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(errorBase.statusCode).body(errorBase);
		}
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity obter(@PathVariable Long id) {
		try {

			ServicoResponse response = service.obter(id);
			return ResponseEntity.status(response.statusCode).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(errorBase.statusCode).body(errorBase);
		}
	}

	@GetMapping
	public ResponseEntity listar() {
		try {
			ServicoListResponse response = service.listar();
			return ResponseEntity.status(response.statusCode).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(errorBase.statusCode).body(errorBase);
		}
	}

}
