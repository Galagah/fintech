# Fintech FIAP - Backend

Projeto backend da Fintech FIAP desenvolvido em Java, Spring Boot, Spring Data JPA e Oracle.

## Integrantes

- Nome do integrante 1 - RM000000
- Nome do integrante 2 - RM000000
- Nome do integrante 3 - RM000000

## Objetivo

Disponibilizar uma API REST para gerenciamento de dados financeiros pessoais. A API permite consultar, cadastrar, atualizar e remover registros de usuarios, contas, despesas e investimentos.

## Tecnologias

- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- Bean Validation
- Oracle JDBC
- Maven
- Oracle FIAP

## Estrutura do Projeto

```text
fintech/
|-- database/
|   `-- schema-oracle.sql
|-- src/main/java/com/fiap/fintech/
|   |-- controller/
|   |   |-- ApiExceptionHandler.java
|   |   |-- AuthController.java
|   |   |-- ContaController.java
|   |   |-- DespesaController.java
|   |   |-- InvestimentoController.java
|   |   `-- UsuarioController.java
|   |-- model/
|   |   |-- Conta.java
|   |   |-- Despesa.java
|   |   |-- Investimento.java
|   |   |-- TipoConta.java
|   |   `-- Usuario.java
|   |-- repository/
|   |   |-- ContaRepository.java
|   |   |-- DespesaRepository.java
|   |   |-- InvestimentoRepository.java
|   |   `-- UsuarioRepository.java
|   |-- service/
|   |   |-- ContaService.java
|   |   |-- DespesaService.java
|   |   |-- InvestimentoService.java
|   |   |-- ResourceNotFoundException.java
|   |   `-- UsuarioService.java
|   `-- FintechApplication.java
|-- src/main/resources/
|   `-- application.properties
|-- pom.xml
|-- README.md
`-- README-COLEGAS.md
```

## Entidades

O backend possui quatro entidades:

- `Usuario`
- `Conta`
- `Despesa`
- `Investimento`

Cada entidade possui classe model, repository, service e controller REST.

## Configuracao do Oracle

O backend usa variaveis de ambiente para conectar no Oracle da FIAP.

Git Bash:

```bash
export ORACLE_DB_URL="jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL"
export ORACLE_DB_USER="RM000000"
export ORACLE_DB_PASSWORD="sua_senha"
```

PowerShell:

```powershell
$env:ORACLE_DB_URL="jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL"
$env:ORACLE_DB_USER="RM000000"
$env:ORACLE_DB_PASSWORD="sua_senha"
```

IntelliJ:

```text
Run > Edit Configurations > Environment variables
```

Formato:

```text
ORACLE_DB_URL=jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL;ORACLE_DB_USER=RM000000;ORACLE_DB_PASSWORD=sua_senha
```

## Como Rodar

Na raiz do projeto:

```bash
mvn spring-boot:run
```

A API fica disponivel em:

```text
http://localhost:8080
```

Teste rapido:

```bash
curl http://localhost:8080/api/usuarios
```

## Endpoints

Autenticacao:

```http
POST /api/auth/login
```

Usuarios:

```http
GET    /api/usuarios
GET    /api/usuarios/{id}
POST   /api/usuarios
PUT    /api/usuarios/{id}
DELETE /api/usuarios/{id}
```

Contas:

```http
GET    /api/contas
GET    /api/contas/{id}
POST   /api/contas
PUT    /api/contas/{id}
DELETE /api/contas/{id}
```

Despesas:

```http
GET    /api/despesas
GET    /api/despesas/{id}
POST   /api/despesas
PUT    /api/despesas/{id}
DELETE /api/despesas/{id}
```

Investimentos:

```http
GET    /api/investimentos
GET    /api/investimentos/{id}
POST   /api/investimentos
PUT    /api/investimentos/{id}
DELETE /api/investimentos/{id}
```

## Status HTTP

- `200 OK`: consulta ou atualizacao realizada
- `201 Created`: registro criado
- `204 No Content`: registro removido
- `400 Bad Request`: dados invalidos
- `401 Unauthorized`: login invalido
- `404 Not Found`: registro nao encontrado

## Banco de Dados

Script para criacao manual:

```text
database/schema-oracle.sql
```

Configuracao JPA:

```properties
spring.jpa.hibernate.ddl-auto=update
```

Com essa configuracao, o Hibernate pode criar/atualizar as tabelas automaticamente quando a conexao Oracle estiver correta.

## Observacoes para Entrega

- Preencher nomes e RMs dos integrantes.
- Testar a API conectada ao Oracle da FIAP.
- Confirmar funcionamento de pelo menos tres entidades.
- Nao incluir `target/`, `build/`, `.idea/` ou arquivos `.class` no arquivo `.zip`.
