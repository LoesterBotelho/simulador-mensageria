# Projeto didático - Aulas 1 e 2

## Integrações, Mensageria e Observabilidade - Java/Spring Boot

Este projeto foi preparado para ser usado progressivamente em sala de aula.

### Aula 1 - Comunicação entre Sistemas e Versionamento de APIs

Implementações marcadas com `AULA 1`:

- API V1: `POST /api/v1/pedidos`
- API V2: `POST /api/v2/pedidos`
- V1 e V2 coexistem para demonstrar evolução de contrato.
- O contrato V2 reorganiza as informações do produto e utiliza `total`.

### Aula 2 - Mensageria

Implementações marcadas com `AULA 2`:

```text
Pedido
   ↓
Evento PedidoCriado
   ↓
Produtor
   ↓
Fila em memória
   ↓
Consumidor
   ↓
Estoque
```

A fila é feita com `ConcurrentLinkedQueue` apenas para simular o conceito de mensageria.

**RabbitMQ NÃO é necessário para executar este projeto.**

Em uma aplicação real, um broker como RabbitMQ faria o papel de transporte/armazenamento/entrega das mensagens.

## Teste rápido

### Criar pedido pela V1

```http
POST http://localhost:8080/api/v1/pedidos
Content-Type: application/json

{
  "produtoId": 1,
  "quantidade": 2
}
```

### Criar pedido pela V2

```http
POST http://localhost:8080/api/v2/pedidos
Content-Type: application/json

{
  "produtoId": 1,
  "quantidade": 2
}
```

Depois de criar o pedido, observe o console. O produtor publica o evento e o consumidor o processa aproximadamente até 1 segundo depois.

## Dependências propositalmente NÃO utilizadas nesta etapa

- RabbitMQ / Spring AMQP
- Docker
- Actuator / métricas
- Correlation ID
- Idempotência

Esses assuntos entram nas próximas etapas do curso.
