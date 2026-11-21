package br.com.rwm.api_clients_cep.service;

import br.com.rwm.api_clients_cep.model.Cliente;
import br.com.rwm.api_clients_cep.model.ClienteRequest;
import br.com.rwm.api_clients_cep.model.ClienteResponse;
import br.com.rwm.api_clients_cep.model.Endereco;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Padrão Facade que unifica e orquestra a lógica de CRUD de clientes com a consulta de endereço
 * via estratégia (Strategy), simplificando a interface consumida pela camada de controle.
 *
 * @author RMWanzo
 */
@Component
public class ClienteFacade {

    private final ClienteService clienteService;
    private final CepStrategy cepStrategy;

    public ClienteFacade(ClienteService clienteService, CepStrategy cepStrategy) {
        this.clienteService = clienteService;
        this.cepStrategy = cepStrategy;
    }

    public List<ClienteResponse> buscarTodos() {
        return clienteService.buscarTodos()
                .stream()
                .map(ClienteResponse::fromEntity)
                .toList();
    }

    public ClienteResponse buscarPorId(Long id) {
        Cliente cliente = clienteService.buscarPorId(id);
        return ClienteResponse.fromEntity(cliente);
    }

    public ClienteResponse cadastrar(ClienteRequest request) {
        Endereco endereco = cepStrategy.consultar(request.cep());
        Cliente novoCliente = new Cliente(
                null,
                request.nome(),
                request.email(),
                endereco.cep(),
                endereco.logradouro(),
                endereco.bairro(),
                endereco.localidade(),
                endereco.uf()
        );
        Cliente salvo = clienteService.salvar(novoCliente);
        return ClienteResponse.fromEntity(salvo);
    }

    public ClienteResponse atualizar(Long id, ClienteRequest request) {
        Cliente clienteExistente = clienteService.buscarPorId(id);
        Endereco endereco = cepStrategy.consultar(request.cep());

        clienteExistente.setNome(request.nome());
        clienteExistente.setEmail(request.email());
        clienteExistente.setCep(endereco.cep());
        clienteExistente.setLogradouro(endereco.logradouro());
        clienteExistente.setBairro(endereco.bairro());
        clienteExistente.setCidade(endereco.localidade());
        clienteExistente.setUf(endereco.uf());

        Cliente atualizado = clienteService.salvar(clienteExistente);
        return ClienteResponse.fromEntity(atualizado);
    }

    public void deletar(Long id) {
        clienteService.deletarPorId(id);
    }
}
