# API de Estoque — provedora HTTP

Aplicação Spring Boot independente na porta **8082**. Ela disponibiliza uma rota consultada pela API de Pedidos.

## Executar
Na pasta do projeto:
```bash
mvn spring-boot:run
```

## Testar diretamente
Abra no navegador ou no Postman:
`http://localhost:8082/api/estoque/produtos/1?quantidade=2`

Produtos de demonstração:
- id 1 — Teclado — 10 unidades
- id 2 — Mouse — 3 unidades
- id 3 — Monitor — 0 unidades

A API responde com JSON. Não há banco de dados: o estoque é apenas uma estrutura em memória para fins didáticos.
