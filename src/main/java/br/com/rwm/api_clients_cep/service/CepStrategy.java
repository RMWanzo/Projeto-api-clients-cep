package br.com.rwm.api_clients_cep.service;

import br.com.rwm.api_clients_cep.model.Endereco;

/**
 * Interface do padrão de projeto Strategy para definição de contratos de busca de CEP.
 * Permite plugar diferentes provedores de consulta de endereço (ex.: ViaCEP, BrasilAPI, Correios)
 * de forma intercambiável.
 *
 * @author RMWanzo
 */
public interface CepStrategy {

    /**
     * Busca informações de endereço a partir de um CEP.
     *
     * @param cep código de endereçamento postal
     * @return objeto Endereco correspondente
     */
    Endereco consultar(String cep);
}
