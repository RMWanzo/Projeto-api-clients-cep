# API de Cadastro de Clientes com Consulta de CEP

> **Autor:** RMWanzo  
> **Tecnologias:** Java, Spring Boot, Spring Data JPA, OpenFeign, H2 Database, SpringDoc OpenAPI (Swagger)

---

## 📖 Sobre o Projeto

Esta aplicação é uma API REST desenvolvida em **Spring Boot** com o objetivo de gerenciar o ciclo de vida cadastral de clientes, integrando automaticamente o preenchimento de endereço através da consulta externa ao serviço **ViaCEP** via **OpenFeign**.

O projeto consolida os fundamentos de desenvolvimento web e a aplicação prática de padrões de projeto (*Design Patterns*):

* **Facade (`ClienteFacade`):**  
  Centraliza e simplifica as chamadas aos serviços de negócio e consulta de CEP, expondo uma interface unificada e coesa para a camada de controladores REST.

* **Strategy (`CepStrategy` e `ViaCepStrategy`):**  
  Define um contrato intercambiável para a busca de endereços por CEP, permitindo plugar novos provedores (como Correios, BrasilAPI, etc.) sem alterar as regras centrais da aplicação.

---

## 📁 Estrutura de Pacotes

```text
br.com.rwm.api_clients_cep
├── controller   → Endpoints REST e tratamento global de exceções
├── model        → Entidade JPA (Cliente) e DTOs/Records (Endereco, Request, Response)
├── repository   → Interface Spring Data JPA para acesso ao banco de dados H2
└── service      → Regras de negócio, cliente OpenFeign, Strategy e Facade
```

---

## 🚀 Como Executar a Aplicação

### Pré-requisitos
* Java JDK (versão configurada no projeto)
* Maven Wrapper (incluso no repositório)

### Execução via Terminal
```bash
./mvnw spring-boot:run
```

### Execução via IDE
Basta executar o método `main` da classe principal:
* `br.com.rwm.api_clients_cep.ApiClientsCepApplication`

---

## 🔍 Acesso aos Recursos e Testes

### 1. Documentação Interativa (Swagger UI)
Acesse no seu navegador para testar todas as rotas de forma visual:
* 🌐 [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

### 2. Console do Banco de Dados H2
* 🌐 [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
* **JDBC URL:** `jdbc:h2:mem:clientedb`
* **User Name:** `sa`
* **Password:** *(deixar em branco)*

---

## 📡 Endpoints da API

| Método | Endpoint | Descrição |
| :--- | :--- | :--- |
| `POST` | `/clientes` | Cadastra um novo cliente (consulta o endereço pelo CEP informado) |
| `GET` | `/clientes` | Lista todos os clientes cadastrados |
| `GET` | `/clientes/{id}` | Busca um cliente específico por ID |
| `PUT` | `/clientes/{id}` | Atualiza dados cadastrais e endereço de um cliente existente |
| `DELETE` | `/clientes/{id}` | Remove um cliente da base de dados |

### Exemplo de Payload para Cadastro (`POST /clientes`)
```json
{
  "nome": "João da Silva",
  "email": "joao@email.com",
  "cep": "01001-000"
}
```
