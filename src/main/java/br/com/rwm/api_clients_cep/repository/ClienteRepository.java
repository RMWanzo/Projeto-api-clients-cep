package br.com.rwm.api_clients_cep.repository;

import br.com.rwm.api_clients_cep.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface de repositório Spring Data JPA para operações de persistência da entidade Cliente.
 *
 * @author RMWanzo
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
