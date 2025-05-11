# To-Do List (Java + Hibernate + JPA)

## 📋 Descrição
Este projeto é uma aplicação de linha de comando que permite o gerenciamento de tarefas (to-do list) e usuários, implementada em Java utilizando as tecnologias Hibernate, JPA e Maven. Foi desenvolvido com foco em boas práticas, organização por camadas e uso de validação de dados.

## 🛠 Tecnologias utilizadas
- Java 17
- Maven
- Hibernate ORM 6
- JPA (Jakarta Persistence)
- MySQL
- Bean Validation (Hibernate Validator)

## 📁 Estrutura do projeto
```
todolist/
├── model/         # Entidades JPA (User, Task)
├── repository/    # Acesso ao banco de dados (CRUD)
├── service/       # Camada de regra de negócio (opcional)
├── util/          # Classe JpaUtil para gerenciamento do EntityManager
├── enums/         # Enumeração para prioridade de tarefas
├── app/           # Classe principal com main para testes
└── resources/
    └── META-INF/
        └── persistence.xml
```

## 🚀 Como executar o projeto
1. Clone o repositório
2. Crie o banco de dados `todolist` no MySQL
3. Configure o arquivo `persistence.xml` com suas credenciais
4. Execute a classe `App.java` para testar as operações CRUD

## ✅ Funcionalidades
- Cadastro de usuários com validação
- Cadastro de tarefas com descrição, data de entrega, prioridade e vínculo com o usuário
- Listagem, busca por ID e remoção de registros
- Validação automática com Bean Validation

## 🙋‍♂️ Autor
Desenvolvido por Renan dos Santos Oliveira


---

# To-Do List (Java + Hibernate + JPA)

## 📋 Description
This is a command-line application that allows task and user management, developed in Java using Hibernate, JPA and Maven. The project follows best practices, layered architecture and proper data validation.

## 🛠 Technologies used
- Java 17
- Maven
- Hibernate ORM 6
- JPA (Jakarta Persistence)
- MySQL
- Bean Validation (Hibernate Validator)

## 📁 Project structure
```
todolist/
├── model/         # JPA entities (User, Task)
├── repository/    # Database access layer (CRUD)
├── service/       # Business logic layer (optional)
├── util/          # JpaUtil class for EntityManager management
├── enums/         # Enum class for task priority
├── app/           # Main class for test execution
└── resources/
    └── META-INF/
        └── persistence.xml
```

## 🚀 How to run the project
1. Clone this repository
2. Create the `todolist` database in MySQL
3. Update the `persistence.xml` file with your credentials
4. Run `App.java` to test CRUD operations

## ✅ Features
- User registration with validation
- Task registration with description, due date, priority and user relationship
- Listing, searching by ID, and deleting records
- Automatic validation using Bean Validation

## 🙋‍♂️ Author
Developed by Renan dos Santos Oliveira
