package br.salaoEveris.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import br.salaoEveris.app.request.ClienteRequest;
import br.salaoEveris.app.response.BaseResponse;
import br.salaoEveris.app.response.ClienteListResponse;
import br.salaoEveris.app.response.ClienteResponse;
import br.salaoEveris.app.service.ClienteService;

@RestController
@RequestMapping("v1")
public class ClienteController extends BaseController{

	@Autowired
    private ClienteService service;

	
    @PostMapping(path = "admin/clientes/inserir")
    public ResponseEntity inserir(@RequestBody ClienteRequest request) {
        try {
            BaseResponse response = service.inserir(request);
            return ResponseEntity.status(response.statusCode).body(response);
        } catch (Exception e) {
            return ResponseEntity.status(errorBase.statusCode).body(errorBase);
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(path = "admin/clientes/{id}")
    public ResponseEntity obter(@PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails) {
        try {
            ClienteResponse response = service.obter(id);
            return ResponseEntity.status(response.statusCode).body(response);
        } catch (Exception e) {
            return ResponseEntity.status(errorBase.statusCode).body(errorBase);
        }
    }
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(path = "admin/clientes")
    public ResponseEntity listar() {
        try {
            ClienteListResponse response = service.listar();
            return ResponseEntity.status(response.statusCode).body(response);
        } catch (Exception e) {
            return ResponseEntity.status(errorBase.statusCode).body(errorBase);
        }
    }
}
