# Controle de Estoque

Fala, seja bem-vindo(a) ao meu projeto!

## Sobre o projeto

Esse é um projeto pessoal feito com Spring Boot, criado pra estudar e treinar desenvolvimento back-end com Java na prática. A ideia é montar uma API pra controle de estoque, colocando em prática conceitos de API REST, banco de dados e controle de acesso por cargo.

Como é um projeto de estudo, é bem provável que você encontre partes do código meio bagunçadas ou que dava pra fazer de um jeito mais simples — o foco aqui não é ter o código perfeito, é aprender fazendo.

## O que já tem

- Cadastro de produtos no estoque
- Cadastro de funcionários, cada um com um cargo dentro do sistema


## Tecnologias usadas

- Java com Spring Boot
- Spring Web (pra construir a API REST)
- Spring Data JPA (pra persistência de dados)
- PostgreSQL (banco de dados)
- Spring Boot Validation (validação dos dados que chegam na API)
- Postman (pra testar os endpoints na mão)

## O que ainda vem por aí

- Controle de permissão por cargo.
- Por exemplo, um Auxiliar de Logística só pode consultar os produtos, enquanto adicionar ou remover produto é coisa de Supervisor pra cima.
