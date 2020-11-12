package br.salaoEveris.app.repository;

import br.salaoEveris.app.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente , Long>{

}
