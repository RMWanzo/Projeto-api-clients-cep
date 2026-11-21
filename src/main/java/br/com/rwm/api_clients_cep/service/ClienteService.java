package br.com.rwm.api_clients_cep.service;

import br.com.rwm.api_clients_cep.model.Cliente;
import br.com.rwm.api_clients_cep.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Serviço responsável pelas operações de negócio e gerenciamento do ciclo de vida da entidade Cliente.
 *
 * @author RMWanzo
 */
@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Cliente não encontrado com ID: " + id));
    }

    public Cliente salvar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public void deletarPorId(Long id) {
        if (!clienteRepository.existsById(id)) {
            throw new NoSuchElementException("Cliente não encontrado com ID: " + id);
        }
        clienteRepository.deleteById(id);
    }
}
