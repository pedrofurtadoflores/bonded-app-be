# Bonded App - Back End

Bonded App é um projeto pessoal de um aplicativo voltado para casais, com foco em conectar duas pessoas em um ambiente seguro e privado. Este repositório representa a API RESTful construída com Java e Spring Boot, responsável por gerenciar usuários, autenticação e estrutura inicial do backend.

O projeto também serve como portfólio profissional, demonstrando boas práticas de arquitetura, segurança e testes em aplicações web modernas com Spring.

## Funcionalidades principais

- Cadastro e gerenciamento de usuários
- Autenticação por e-mail e senha com Spring Security
- Senhas criptografadas com `BCryptPasswordEncoder`
- Controle de sessão via `JSESSIONID` (form login padrão)
- API documentada com Swagger
- Tratamento global de exceções
- Testes unitários para camada de serviço

## Tecnologias utilizadas

- Java 17
- Spring Boot 3
- Spring Security
- Spring Data JPA
- PostgreSQL
- Lombok
- Swagger (Springdoc OpenAPI)
- JUnit 5 + Mockito

## Estrutura da API

| Método | Endpoint           | Descrição                          |
|--------|--------------------|------------------------------------|
| POST   | `/auth/register`   | Cadastrar novo usuário             |
| POST   | `/login`           | Login via formulário (session)     |
| GET    | `/api/users`       | Listar todos os usuários           |
| GET    | `/api/users/{id}`  | Buscar usuário por ID              |
| PUT    | `/api/users/{id}`  | Atualizar informações do usuário   |
| DELETE | `/api/users/{id}`  | Deletar usuário                    |

## Como executar o projeto

1. Clone o repositório:
   ```bash
   git clone https://github.com/pedrofurtadoflores/bonded-app-be.git
   cd bonded-app-be
   ```

2. Configure o banco de dados PostgreSQL:
   ```
   Banco: bonded_app_backend
   Usuário: postgres
   Senha: password
   ```

3. Ajuste o arquivo `application.properties`:
   ```
   spring.datasource.url=jdbc:postgresql://localhost:5432/bonded_app_backend
   spring.datasource.username=postgres
   spring.datasource.password=password
   ```

4. Execute o projeto:
   ```bash
   ./mvnw spring-boot:run
   ```

## Documentação da API

Após iniciar o projeto, acesse:
```
http://localhost:8080/swagger-ui.html
```

## Testes

Para rodar os testes unitários:

```bash
mvn test
```

Os testes cobrem todos os métodos de serviço responsáveis por criação, leitura, atualização e remoção de usuários.

## Objetivos do projeto

Este backend faz parte de um projeto maior de um app para casais. O objetivo é oferecer funcionalidades exclusivas para dois usuários conectados, como:

- Compartilhamento de mensagens privadas
- Acompanhamento de datas importantes
- Rotinas do casal, metas e registros afetivos

Essa primeira fase representa a estrutura inicial da API, preparada para evolução futura.

## Autor

Pedro Furtado  
Desenvolvedor 
[LinkedIn](https://www.linkedin.com/in/pedrofurtado-dev)
