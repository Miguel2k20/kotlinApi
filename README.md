# API de estudo em Kotlin

API criada apenas para estudar Kotlin, usando Spring Boot, Java 21 e PostgreSQL.

## Rodar com Docker

Com Docker e Docker Compose instalados, execute na pasta do projeto:

```bash
docker compose up --build
```

O comando compila a API e inicia o PostgreSQL. Não é necessário instalar Java ou Gradle na máquina. A primeira execução pode demorar para baixar as dependências.

A API fica disponível em **http://localhost:8080**. Para listar os usuários:

```bash
curl http://localhost:8080/users
```

Para rodar em segundo plano e acompanhar os logs:

```bash
docker compose up --build -d
docker compose logs -f api
```

Para parar os containers (os dados do banco ficam salvos):

```bash
docker compose down
```

Para parar e **apagar todos os dados do banco**:

```bash
docker compose down -v
```

Depois de alterar o código, execute novamente `docker compose up --build`.
