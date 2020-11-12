package br.salaoEveris.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import br.salaoEveris.app.request.AgendamentoRequest;
import br.salaoEveris.app.response.BaseResponse;
import br.salaoEveris.app.service.AgendamentoService;

@RestController
@RequestMapping("/agendamento")
public class AgendamentoController extends BaseController {

	@Autowired
	private AgendamentoService service;

	@PostMapping
	public ResponseEntity inserir(@RequestBody AgendamentoRequest request) {
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
			BaseResponse response = service.obter(id);
			return ResponseEntity.status(response.statusCode).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(errorBase.statusCode).body(errorBase);
		}
	}
//
//	@GetMapping
//	public ResponseEntity listar() {
//		try {
//			BaseResponse response = service.listar();
//			return ResponseEntity.status(response.statusCode).body(response);
//		} catch (Exception e) {
//			return ResponseEntity.status(errorBase.statusCode).body(errorBase);
//
//		}
//	}
}
