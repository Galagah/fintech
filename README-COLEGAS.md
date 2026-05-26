# Guia Interno - Backend e Banco

Este arquivo explica o que foi feito no backend e o que ainda precisa ser conferido por quem cuidar do banco.

## O que Mudou no Backend

O projeto original era um Java/Maven simples, com classes de modelo e um `Main` para testes no console.

Agora ele foi convertido para uma API REST com Spring Boot.

Principais mudancas:

- `pom.xml` atualizado para Spring Boot.
- Criada a classe principal `FintechApplication`.
- Classes antigas foram convertidas em entidades JPA.
- Entidades movidas para o pacote `model`.
- Criada camada `repository` usando Spring Data JPA.
- Criada camada `service` para centralizar as operacoes de CRUD.
- Criada camada `controller` com endpoints REST.
- Criado tratamento global de erros em `ApiExceptionHandler`.
- Criado endpoint simples de login em `AuthController`.
- Criado arquivo `application.properties` com configuracao por variaveis de ambiente.
- Criado script SQL Oracle em `database/schema-oracle.sql`.

## Estrutura Atual do Backend

```text
src/main/java/com/fiap/fintech/
|-- config/
|-- controller/
|-- model/
|-- repository/
|-- service/
`-- FintechApplication.java
```

## Entidades Implementadas

- `Usuario`
- `Conta`
- `Despesa`
- `Investimento`

Tambem existe o enum:

- `TipoConta`

## Como Rodar

Na raiz do projeto:

```bash
mvn spring-boot:run
```

Antes de rodar, configurar o Oracle:

```bash
export ORACLE_DB_URL="jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL"
export ORACLE_DB_USER="RM000000"
export ORACLE_DB_PASSWORD="sua_senha"
```

No IntelliJ:

```text
Run > Edit Configurations > Environment variables
```

Formato:

```text
ORACLE_DB_URL=jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL;ORACLE_DB_USER=RM000000;ORACLE_DB_PASSWORD=sua_senha
```

## Responsavel pelo Banco

Verificar:

- se a URL do Oracle da FIAP esta correta;
- se usuario e senha do RM estao corretos;
- se o backend sobe sem erro de conexao;
- se as tabelas foram criadas no Oracle;
- se o script `database/schema-oracle.sql` precisa ser ajustado ao padrao do professor.

Erro comum:

```text
ORA-01017: invalid username/password; logon denied
```

Esse erro significa usuario ou senha incorretos.

## Endpoints para Teste

Usuarios:

```http
GET    /api/usuarios
POST   /api/usuarios
PUT    /api/usuarios/{id}
DELETE /api/usuarios/{id}
```

Contas:

```http
GET    /api/contas
POST   /api/contas
PUT    /api/contas/{id}
DELETE /api/contas/{id}
```

Despesas:

```http
GET    /api/despesas
POST   /api/despesas
PUT    /api/despesas/{id}
DELETE /api/despesas/{id}
```

Investimentos:

```http
GET    /api/investimentos
POST   /api/investimentos
PUT    /api/investimentos/{id}
DELETE /api/investimentos/{id}
```

## Exemplos de JSON

Usuario:

```json
{
  "nome": "Usuario Teste",
  "email": "usuario@fiap.com.br",
  "cpf": "123.456.789-00",
  "telefone": "(11) 99999-9999",
  "idade": 22,
  "perfil": "premium"
}
```

Conta:

```json
{
  "numeroConta": "0001-1234",
  "titular": "Usuario Teste",
  "saldo": 1500.00,
  "tipo": "CORRENTE",
  "ativa": true
}
```

Despesa:

```json
{
  "descricao": "Supermercado",
  "valor": 350.75,
  "data": "2026-05-25",
  "categoria": "Alimentacao",
  "formaPagamento": "Pix",
  "paga": false
}
```

Investimento:

```json
{
  "descricao": "Tesouro Direto",
  "valor": 2000.00,
  "data": "2026-05-25",
  "categoria": "Renda fixa",
  "rendimento": 150.00,
  "taxaJuros": 10.50,
  "resgatado": false
}
```

## Comandos Uteis

Compilar:

```bash
mvn -DskipTests package
```

Rodar:

```bash
mvn spring-boot:run
```

Testar:

```bash
curl http://localhost:8080/api/usuarios
```

## Checklist

- `mvn -DskipTests package` executa com sucesso.
- Backend sobe com `mvn spring-boot:run`.
- Variaveis Oracle estao configuradas.
- `GET /api/usuarios` responde.
- Pelo menos 3 entidades foram testadas com GET, POST, PUT e DELETE.
- Tabelas existem no Oracle da FIAP.
