**Desafio PlaceTI** 

**Autor:** Davi Crisóstomo de Sousa 

Este documento descreve o webservice desenvolvido em Java com Spring para gerenciar marcas e modelos. O webservice permite realizar operações básicas de CRUD (Create, Read, Update, Delete) nas entidades Marca e Modelo. 

**Requisitos**

Antes de começar, certifique-se de ter os seguintes softwares instalados:

Java Development Kit (JDK) 11+ 

Maven 

Git 

Postman ou Insomnia 

**Passos para Clonar o Repositório** 

Clone o Repositório 

Abra um terminal e execute o comando: 

*git clone https://github.com/DVZoRD/desafioplaceti.git* 
 

Isso criará uma cópia local do repositório na sua máquina. 

 

Navegue até o Diretório do Projeto 

*cd desafioplaceti* 

 

**Configurando o Projeto**

Compilar e Construir o Projeto 

No diretório raiz do projeto, execute: 

*mvn clean install*

 

Isso irá compilar o projeto e baixar todas as dependências necessárias. 

 

 

**Execute o Projeto** 

Ainda no diretório raiz do projeto, execute: 

mvn spring-boot:run 

 

**Testando a API com Postman** 

**Importar Coleção do Postman** 

Você pode criar uma nova coleção no Postman para testar os endpoints do projeto. Adicione os seguintes endpoints: 

 

**GET /api/marcas** 

**POST /api/marcas** 

**GET /api/marcas/{id}** 

**PUT /api/marcas/{id}** 

**DELETE /api/marcas/{id}** 

**GET /api/modelos**

**POST /api/modelos** 

**GET /api/modelos/{id}** 

**PUT /api/modelos/{id}** 

**DELETE /api/modelos/{id}**

 

**Configurar Requisições no Postman** 
**Marcas:** 

**Criar uma Marca** 

Método HTTP: **POST** 

**URL:** http://localhost:8080/api/marcas 

**Body (raw JSON):** 

{  

 "nome": "Marca Exemplo", 

 "codigoDenatran": "12345",  

"ativo": true,  

"modelos": []  

} 

 

**Obter Todas as Marcas** 

Método HTTP: **GET** 

**URL:** http://localhost:8080/api/marcas 

 

 

 

**Obter Marca por ID** 

Método HTTP: **GET** 

**URL:** http://localhost:8080/api/marcas/{id} 

 

**Atualizar uma Marca** 

Método HTTP: **PUT** 

**URL:** http://localhost:8080/api/marcas/{ìd} 

**Body (raw JSON):** 

{  

 "nome": "Marca Exemplo Atualizada", 

 "codigoDenatran": "54321",  

"ativo": false,  

"modelos": []  

} 

 

**Deletar uma Marca**

Método HTTP: **DELETE** 

**URL:** http://localhost:8080/api/marcas/{id} 

 

**Modelos:** 

**Criar um Modelo** 

Método HTTP: **POST** 

**URL:** http://localhost:8080/api/modelos 

**Body (raw JSON):** 

{  

"nome": "Modelo Exemplo",  

"ano": 2024,  

"ativo": true,  

"marca": { 

 "id": 1  

}  

} 

 

**Obter Todos os Modelos** 

Método HTTP: **GET** 

**URL:** http://localhost:8080/api/modelos 

 

 

**Obter Modelo por ID** 

Método HTTP: **GET** 

**URL:** http://localhost:8080/api/modelos/{id} 

 

**Atualizar um Modelo** 

Método HTTP: **PUT**

**URL:** http://localhost:8080/api/modelos/{ìd} 

**Body (raw JSON):** 

{ 

  "nome": "Modelo Exemplo Atualizado", 

  "ano": 2025, 

  "ativo": false, 

  "marca": { 

    "id": 1 

  } 

} 

 

Deletar um Modelo 

Método HTTP: DELETE 

URL: http://localhost:8080/api/modelos/{id} 
