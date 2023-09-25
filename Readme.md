# README

## Easy Money Pessoa

### 1. Sobre o Projeto
Easy Money Pessoa é uma aplicação de gestão de pessoas da Easy Money que permite aos 
usuários terem as operações de um crud
Utilizamos uma arquitetura bem robusta a **Hexagonal** com descoplamento total das 
portas e adaptadores


### 2. Tecnologias Utilizadas
- **Java 17**: Linguagem de programação que oferece um forte sistema de tipos e um excelente
 gerenciamento de memória.
- **Spring Boot**: Usado para simplificar o processo de configuração e desenvolvimento.
- **Swagger**: Para documentação da api.
- **Maven**: Para gerenciamento de dependências.
- **JUnit 5**: Para testes unitários.
- **H2 database**: Facil usabilidade e flexibilidade

Cada tecnologia foi escolhida com o objetivo de tornar a aplicação mais eficiente, 
fácil de testar e manter.

### 3. Arquitetura e Padrões
A aplicação segue a arquitetura **Hexagonal** naão modular, que ffaz uma separação total 
das ports om as tecnlogias que elas implementam. 
Toda porta de saida tem a responsabilidade unica de uma operação, ja a porta de entrada
pode ter varias operações. A implementação de cada porta é feita por adaptadores **adapters**
que são criados de acordo com a tecnologia que estão usando com isso facilita a alteração
de um adaptador sem nehuma dor para o desenvolvimento 



### 4. Instalação e Execução
Para instalar e executar este projeto, siga os seguintes passos:


##### Use o Maven para compilar e rodar
mvn clean install
mvn spring-boot:run
\```

### 5. Console H2
Colocar no seu browser o endereço http://localhost:8080/h2-console/
-url: jdbc:h2:file:./data/EasyMoneyPessoa  
-driverClassName: org.h2.Driver
-username: sa
-password: 

### 6. Swagger
Colocar no seu browser o endereço http://localhost:8080/swagger-ui/index.html