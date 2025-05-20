# agregador-investimento-api

Este projeto é uma API para agregação de investimentos desenvolvida em Java utilizando o framework Spring Boot.

## Requisitos
- Java 17 ou superior
- Maven 3.8 ou superior

## Instalação
1. Clone o repositório:
   ```sh
   git clone <url-do-repositorio>
   ```
2. Acesse o diretório do projeto:
   ```sh
   cd agregador-investimento-api
   ```
3. Compile o projeto:
   ```sh
   ./mvnw clean install
   ```

## Execução
Para iniciar a aplicação, execute o comando abaixo:
```sh
./mvnw spring-boot:run
```
A aplicação estará disponível em `http://localhost:8080`.

## Estrutura do Projeto
- `src/main/java/br/com/agin/api/controller` - Controllers da aplicação
- `src/main/java/br/com/agin/api/entity` - Entidades do domínio
- `src/main/java/br/com/agin/api/repository` - Repositórios de acesso a dados
- `src/main/java/br/com/agin/api/service` - Serviços de negócio
- `src/main/resources` - Arquivos de configuração e recursos estáticos

## Testes
Para rodar os testes automatizados:
```sh
./mvnw test
```

## Configuração
As configurações da aplicação estão no arquivo `src/main/resources/application.properties`.

## Autor
Desenvolvido por [Cleyton Melo](https://github.com/CleytonW).
