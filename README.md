# One Challenge - LiterAlura

Este projeto Java Spring Boot, desenvolvido como parte do One Challenge da Alura, é um catálogo de livros que permite a interação com a API Gutendex para buscar livros e gerenciar dados de livros e autores em um banco de dados PostgreSQL.

## Funcionalidades

O aplicativo oferece um menu interativo no terminal com as seguintes opções:

1.  **Buscar livro pelo título**: Realiza uma consulta diretamente na API Gutendex e insere o livro resultante no banco de dados.
      * Exemplo: Buscar "Dom Casmurro" ou "Emma".
2.  **Listar livros registrados**: Exibe todos os livros que foram inseridos no banco de dados.
3.  **Listar nossos autores**: Mostra os dados de cada autor registrado no banco de dados, incluindo ano de nascimento e falecimento.
4.  **Listar autores em determinado ano**: Filtra e exibe os autores que estavam vivos em um ano específico.
5.  **Listar livros em determinado idioma**: Permite buscar livros por idioma (Espanhol, Inglês, Francês e Português).

## Tecnologias Utilizadas

  * **Linguagem de Programação**: Java
  * **Framework**: Spring Boot
  * **Gerenciador de Projetos**: Maven
  * **Persistência de Dados**: Spring Data JPA
  * **Banco de Dados**: PostgreSQL
  * **API Externa**: Gutendex API

## Configuração do Ambiente

Para configurar o projeto, siga os passos abaixo:

1.  **Inicialização do Projeto**: Utilize o Spring Initializer com as seguintes configurações:
      * **Linguagem**: Java
      * **Gerenciador de Projetos**: Maven
      * **Dependências**:
          * Spring Data JPA
          * PostgreSQL Driver
2.  **Configuração do Banco de Dados**:
      * Baixe e instale o PostgreSQL. Você pode encontrar a página de download em [PostgreSQL Downloads](https://www.postgresql.org/download/).
      * Configure as credenciais do seu banco de dados PostgreSQL no arquivo `application.properties` (ou `application.yml`) do seu projeto Spring Boot.
3.  **API Gutendex**: A API Gutendex é utilizada para buscar informações sobre os livros. Você pode explorar a API diretamente em seu site: [Gutendex](https://gutendex.com/).

## Como Executar o Projeto

1.  **Clonar o Repositório**:
    ```bash
    git clone https://github.com/matheussouza94/One-Challenge-Literatura-Alura.git
    ```
2.  **Abrir no IntelliJ (ou sua IDE de preferência)**: Importe o projeto Maven na sua IDE.
3.  **Configurar o Banco de Dados**: Certifique-se de que seu banco de dados PostgreSQL está configurado e as credenciais estão corretas no projeto.
4.  **Executar a Aplicação**: Execute a classe `ChallengeLiteraturaApplication` como uma aplicação Spring Boot.
5.  **Interagir no Terminal**: O aplicativo apresentará um menu de opções no terminal para interação.

## Exemplos de Uso

  * Ao iniciar a aplicação, você verá um menu no terminal.
  * Para buscar um livro, digite `1`, pressione Enter, e em seguida digite o título do livro (ex: "Dom Casmurro" ou "Emma").
  * Para listar livros registrados, digite `2` e pressione Enter.
  * Para listar autores, digite `3` e pressione Enter.
  * Para listar autores vivos em um ano, digite `4`, pressione Enter, e digite o ano (ex: "1800").
  * Para listar livros por idioma, digite `5`, pressione Enter, e digite a abreviação do idioma (ex: "PT" para Português, "EN" para Inglês).

-----
