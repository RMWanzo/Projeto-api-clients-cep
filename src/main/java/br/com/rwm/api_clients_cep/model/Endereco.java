package br.com.rwm.api_clients_cep.model;

/**
 * Record que representa a resposta da consulta de endereço retornada pelo serviço ViaCEP.
 *
 * @author RMWanzo
 */
public record Endereco(
        String cep,
        String logradouro,
        String complemento,
        String unidade,
        String bairro,
        String localidade,
        String uf,
        String estado,
        String regiao,
        String ibge,
        String gia,
        String ddd,
        String siafi,
        Boolean erro
) {
}
