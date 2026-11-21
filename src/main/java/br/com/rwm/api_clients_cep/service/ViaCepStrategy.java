package br.com.rwm.api_clients_cep.service;

import br.com.rwm.api_clients_cep.model.Endereco;
import org.springframework.stereotype.Service;

/**
 * Implementação concreta da estratégia de busca de CEP utilizando o serviço ViaCEP via OpenFeign.
 *
 * @author RMWanzo
 */
@Service
public class ViaCepStrategy implements CepStrategy {

    private final ViaCepClient viaCepClient;

    public ViaCepStrategy(ViaCepClient viaCepClient) {
        this.viaCepClient = viaCepClient;
    }

    @Override
    public Endereco consultar(String cep) {
        String cleanCep = (cep != null) ? cep.replaceAll("\\D", "") : "";
        Endereco endereco = viaCepClient.consultarCep(cleanCep);
        if (endereco == null || Boolean.TRUE.equals(endereco.erro())) {
            throw new IllegalArgumentException("CEP não encontrado ou inválido: " + cep);
        }
        return endereco;
    }
}
