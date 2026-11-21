package br.com.rwm.api_clients_cep.service;

import br.com.rwm.api_clients_cep.model.Endereco;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Cliente HTTP declarativo OpenFeign para consumo da API pública do ViaCEP.
 *
 * @author RMWanzo
 */
@FeignClient(name = "viaCepClient", url = "https://viacep.com.br/ws")
public interface ViaCepClient {

    /**
     * Consulta endereço a partir de um CEP formatado em JSON.
     *
     * @param cep código de endereçamento postal
     * @return objeto Endereco contendo as informações retornadas pelo ViaCEP
     */
    @GetMapping("/{cep}/json")
    Endereco consultarCep(@PathVariable("cep") String cep);
}
