# FórumHub API

API REST desenvolvida em **Java 17 com Spring Boot** para o curso Praticando Spring Framework: Challenge Fórum Hub

O projeto implementa o CRUD de tópicos de um fórum, com persistência em banco de dados, validações e autenticação.

---

## Funcionalidades

- Cadastro de tópicos
- Listagem de tópicos (com paginação e filtro por curso)
- Detalhamento de tópico por ID
- Atualização de tópico
- Exclusão de tópico
- Autenticação com Spring Security e JWT

---

## Tecnologias Utilizadas

- Java 17
- Spring Boot 4.0.1
- Spring Data JPA
- Spring Validation
- Spring Security
- Flyway Migration
- MySQL
- Lombok
- JWT (Auth0)
- Maven

---

## Banco de Dados

- MySQL
- Migrations gerenciadas com Flyway
- Tabela principal: `topicos`

---

## Endpoints Principais

- `POST /topicos` – cadastrar tópico
- `GET /topicos` – listar tópicos (paginado)
- `GET /topicos/{id}` – detalhar tópico
- `PUT /topicos/{id}` – atualizar tópico
- `DELETE /topicos/{id}` – excluir tópico
- `POST /login` – autenticação

---

## Execução do Projeto

1. Criar o banco de dados no MySQL  
2. Configurar `application.properties`  
3. Executar a aplicação.

```bash
mvn spring-boot:run
