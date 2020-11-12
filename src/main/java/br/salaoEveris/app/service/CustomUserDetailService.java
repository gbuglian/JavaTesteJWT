package br.salaoEveris.app.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import br.salaoEveris.app.model.Usuario;
import br.salaoEveris.app.repository.UsuarioRepository;

@Component
public class CustomUserDetailService implements UserDetailsService {

	private final UsuarioRepository _Repository;
	
	@Autowired
	public CustomUserDetailService(UsuarioRepository _Repository) {
		this._Repository = _Repository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario user = Optional.ofNullable(_Repository.findByUsuario(username))
				.orElseThrow(() -> new UsernameNotFoundException("Usuario não encontrado"));
		List<GrantedAuthority> authorityListAdmin = AuthorityUtils.createAuthorityList("ROLE_USER","ROLE_ADMIN");
		List<GrantedAuthority> authorityListUser = AuthorityUtils.createAuthorityList("ROLE_USER");

		return new org.springframework.security.core.userdetails.User
				(user.getUsuario(), user.getSenha(), user.isAdmin() ? authorityListAdmin : authorityListUser);
	}
	


}
