# RoomNow

Sistema de gerenciamento de aluguel de salas de escritório, com controle de clientes (pessoa física e jurídica), salas, recursos disponíveis e autenticação de usuários via JWT.

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
![Spring Security](https://img.shields.io/badge/Spring%20Security-6DB33F?style=for-the-badge&logo=springsecurity&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-000000?style=for-the-badge&logo=jsonwebtokens&logoColor=white)

## Sobre o projeto

O **RoomNow** é uma API REST desenvolvida para gerenciar o aluguel de salas de escritório. O sistema permite cadastrar clientes (pessoa física ou jurídica), salas com seus respectivos recursos (equipamentos/estrutura disponível) e controlar os aluguéis realizados, associando cliente, sala e usuário responsável.

## Funcionalidades

- Cadastro e autenticação de usuários (login e registro) com JWT
- Cadastro de clientes: Pessoa Física e Pessoa Jurídica
- Cadastro de salas e seus recursos (equipamentos, estrutura)
- Registro de aluguel de salas, vinculando cliente, sala e usuário
- Controle de autorização por papel de usuário (roles)

##  Tecnologias utilizadas

- **Java**
- **Spring Boot**
- **Spring Data JPA** — persistência e acesso a dados
- **Spring Security** — autenticação e autorização
- **JWT (JSON Web Token)** — autenticação stateless
- **Bean Validation (@Valid)** — validação de DTOs
- **Maven** — gerenciamento de dependências

## Autenticação

A API utiliza autenticação baseada em JWT. Os principais endpoints de autenticação são:

| Método | Endpoint         | Descrição                  |
|--------|------------------|-----------------------------|
| POST   | `/auth/login`    | Realiza login e retorna token JWT |
| POST   | `/auth/registrar`| Registra um novo usuário          |

## Estrutura do domínio

- **Cliente** — pode ser `PessoaFisica` ou `PessoaJuridica`
- **Usuario** — responsável pelo aluguel, com autenticação e papéis (roles)
- **Sala** — sala disponível para aluguel
- **Recurso** — equipamento/recurso vinculado a uma sala (`SalaRecurso`)
- **AluguelSala** — relaciona `Cliente`, `Usuario` e `Sala` em um aluguel

## Como executar

```bash
# Clone o repositório
git clone https://github.com/chinagliadev/RoomNow.git

# Entre na pasta do projeto
cd RoomNow

# Configure suas variáveis de banco de dados em src/main/resources/application.properties

# Execute com Maven Wrapper
./mvnw spring-boot:run
```

A aplicação sobe por padrão em `http://localhost:3300`.

##  Status do projeto

 Em desenvolvimento

## 📄 Licença

Este projeto está sob livre uso para fins de estudo.
