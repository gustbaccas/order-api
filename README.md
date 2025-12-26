# Order API

API REST para gerenciamento de ordens, desenvolvida com **Spring Boot**, aplicando regras de negócio para controle de status da ordem.

---

## Tecnologias

- Java  
- Spring Boot  
- Spring Web  
- Spring Data JPA  
- Bean Validation  
- H2 Database  
- Maven  

---

## Funcionalidades

- Criar ordem  
- Listar ordens  
- Buscar ordem por ID  
- Pagar ordem  
- Cancelar ordem  
- Deletar ordem  
- Filtrar ordens por status  

---

## Status da Ordem

- **OPEN** – Ordem aberta  
- **PAID** – Ordem paga  
- **CANCELLED** – Ordem cancelada  

---

## Regras de Negócio

- Toda ordem é criada com status **OPEN** e ativa por padrão.  
- Apenas ordens com status **OPEN** podem ser pagas.  
- Ordens pagas (**PAID**) não podem ser canceladas.  
- Ordens canceladas (**CANCELLED**) não podem ser pagas.  
- Apenas ordens com status **CANCELLED** podem ser deletadas.  
- A listagem de ordens pode ser filtrada por status através de query parameters.  

---

## Endpoints Principais

| Método | Endpoint              | Descrição                     |
|------|-----------------------|-------------------------------|
| POST | `/orders`             | Criar uma nova ordem          |
| GET  | `/orders`             | Listar ordens                 |
| GET  | `/orders/{id}`        | Buscar ordem por ID           |
| PUT  | `/orders/{id}/pay`    | Pagar uma ordem               |
| PUT  | `/orders/{id}/cancel` | Cancelar uma ordem            |
| DELETE | `/orders/{id}`      | Deletar uma ordem             |

---

## Filtro por Status

É possível filtrar ordens pelo status utilizando query parameters:

```http
GET /orders?status=OPEN
GET /orders?status=PAID
GET /orders?status=CANCELLED
