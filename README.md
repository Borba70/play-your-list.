# Play Your List - HPWM

Projeto Spring Boot com os quatro serviços solicitados no enunciado, mantidos no mesmo projeto para facilitar a entrega:

- musicas
- playlists
- reproducoes
- api

## Tecnologias

- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- Bean Validation
- OpenFeign
- H2 Database
- Maven

## Como executar no VS Code

1. Abra a pasta do projeto no VS Code.
2. Confirme que `java -version` retorna Java 21.
3. No terminal do VS Code execute:

```bash
./mvnw spring-boot:run
```

No Windows também pode ser:

```bash
mvnw.cmd spring-boot:run
```

4. A API ficará em:

http://localhost:8080

## H2 Console

http://localhost:8080/h2-console

JDBC URL:

jdbc:h2:mem:playyourlist

User: sa
Password: deixar vazio

## Exemplos de testes

### Listar músicas

GET http://localhost:8080/musicas

### Cadastrar música

POST http://localhost:8080/musicas

```json
{
  "titulo": "Hotel California",
  "artista": "Eagles",
  "album": "Hotel California",
  "duracao": 391,
  "genero": "Rock"
}
```

### Listar playlists

GET http://localhost:8080/playlists

### Adicionar música pela API de orquestração

POST http://localhost:8080/api/adicionar/1/musicas/2

### Executar playlist

PUT http://localhost:8080/api/executar/1

### Consultar reproduções

GET http://localhost:8080/reproducao/1

### Consultar total

GET http://localhost:8080/reproducao/total/1

## Observação sobre o enunciado

O enunciado cita `POST /statistic` na parte de orquestração, enquanto o serviço de reprodução é apresentado como `/reproducao`. Este projeto aceita os dois caminhos para o cadastro de reprodução e o OpenFeign utiliza `/statistic`, exatamente como solicitado na parte da API.
