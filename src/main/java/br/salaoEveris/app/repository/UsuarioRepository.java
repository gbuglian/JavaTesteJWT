package br.salaoEveris.app.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.salaoEveris.app.model.Usuario;

public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Long> {

	Usuario findByUsuario(String usuario);
	
}
