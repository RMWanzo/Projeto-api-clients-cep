package br.com.rwm.api_clients_cep.model;

/**
 * DTO que representa os dados de entrada para criação ou atualização de um cliente.
 *
 * @author RMWanzo
 */
public record ClienteRequest(
        String nome,
        String email,
        String cep
) {
}
