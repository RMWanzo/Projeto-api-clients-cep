package br.com.rwm.api_clients_cep.model;

/**
 * DTO que representa os dados de saída de um cliente cadastrado ou consultado.
 *
 * @author RMWanzo
 */
public record ClienteResponse(
        Long id,
        String nome,
        String email,
        String cep,
        String logradouro,
        String bairro,
        String cidade,
        String uf
) {

    /**
     * Construtor de conveniência a partir da entidade Cliente.
     *
     * @param cliente entidade de domínio
     * @return instância de ClienteResponse
     */
    public static ClienteResponse fromEntity(Cliente cliente) {
        return new ClienteResponse(
                cliente.getId(),
                cliente.getNome(),
                cliente.getEmail(),
                cliente.getCep(),
                cliente.getLogradouro(),
                cliente.getBairro(),
                cliente.getCidade(),
                cliente.getUf()
        );
    }
}
