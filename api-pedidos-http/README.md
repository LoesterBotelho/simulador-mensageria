# API de Pedidos — chamada HTTP para outra API

Aplicação Spring Boot independente que roda na porta **8081** e chama a API de Estoque, que roda na porta **8082**.

## Pré-requisitos
- Java 21
- Maven
- Inicie primeiro a API de Estoque.

## Executar
No terminal, nesta pasta:
```bash
mvn spring-boot:run
```

## Testar
```http
POST http://localhost:8081/api/pedidos
Content-Type: application/json

{
  "produtoId": 1,
  "quantidade": 2,
  "cliente": "Maria"
}
```

A API de Pedidos chama `GET http://localhost:8082/api/estoque/produtos/1?quantidade=2` e aguarda a resposta antes de responder ao cliente. Esse é o ponto didático da comunicação síncrona entre duas aplicações.
