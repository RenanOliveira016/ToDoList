# 📘 Documentação Técnica - Projeto To-Do List

## 🎯 Objetivo
O sistema To-Do List tem como objetivo permitir o cadastro e gerenciamento de usuários e tarefas. Cada tarefa pertence a um usuário e pode conter título, descrição, prioridade e data de vencimento.

---

## ✅ Requisitos Funcionais (RF)

- **RF01**: O sistema deve permitir o cadastro de usuários com nome, e-mail e idade.
- **RF02**: O sistema deve permitir o cadastro de tarefas com título, descrição, prioridade, data de vencimento e status de conclusão.
- **RF03**: O sistema deve associar cada tarefa a um único usuário.
- **RF04**: O sistema deve permitir a exclusão de usuários e tarefas.
- **RF05**: O sistema deve listar todos os usuários cadastrados.
- **RF06**: O sistema deve listar todas as tarefas cadastradas.

---

## ❌ Requisitos Não Funcionais (RNF)

- **RNF01**: O sistema deve ser implementado em Java utilizando o padrão Maven.
- **RNF02**: O sistema deve utilizar JPA com Hibernate como provedor ORM.
- **RNF03**: O banco de dados utilizado deve ser o MySQL.
- **RNF04**: O sistema deve seguir o padrão MVC (Model, View, Controller) adaptado para CLI.
- **RNF05**: A validação de dados deve ser feita utilizando Bean Validation (Hibernate Validator).

---

## 📦 Diagrama de Classes

- **User**
  - id: Long
  - name: String
  - email: String
  - age: int
  - tasks: List<Task>

- **Task**
  - id: Long
  - name: String
  - description: String
  - completed: boolean
  - dueDate: LocalDate
  - createdAt: LocalDateTime
  - updateAt: LocalDateTime
  - priority: Priority (Enum)
  - user: User

- **Enum Priority**
  - LOW
  - MEDIUM
  - HIGH

---

## 🔗 Relacionamentos

- Um `User` pode ter várias `Task`s (**1:N**).
- Uma `Task` pertence a exatamente um `User` (**N:1**).

---

## 📊 Diagrama Entidade-Relacionamento (texto)

```
[User]
- id (PK)
- name
- email
- age

[Task]
- id (PK)
- name
- description
- completed
- dueDate
- createdAt
- updateAt
- priority
- user_id (FK)

Relacionamentos:
User (1) <---- (N) Task
```

---

## 🔧 Tecnologias Utilizadas

- Java 17
- Maven
- Hibernate ORM 6
- JPA (Jakarta Persistence)
- MySQL
- Bean Validation (Jakarta Validation API)
- Eclipse IDE

---

## 🧠 Observações

- O sistema é orientado a objetos e segue boas práticas de encapsulamento, separação de camadas e validação de dados.
- O projeto pode ser facilmente expandido para uma aplicação web ou REST futuramente.