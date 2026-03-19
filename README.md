# API Resume Descrição

Aplicação Spring Boot para resumir descrição dos itens da Ordem de Compra.

## Pré-requisitos

- Java 17 ou superior
- Maven 3.6+ (para build)

## Estrutura de Perfis

A aplicação possui dois perfis principais:

- **dev**: perfil de desenvolvimento, configurado por padrão em `application.properties`.
- **prod**: perfil de produção, deve ser informado explicitamente ao executar o `.jar`.

### Exemplo de como executar a aplicação no servidor em produção:

```bash
java -jar caminho_para_arquivo_jar.jar --spring.profiles.active=prod
```

### Exemplo de como configurar os perfis no ambiente de desenvolvimento
- Crie o arquivo `application-dev.properties` no caminho `src/main/resources/application-dev.properties`
- Preencha as propriedades abaixo nesse arquivo,  
- Voce precisara consultar as chaves de API usadas no Google AI Studio
```bash
# Chave de API dos projetos criados no Google AI Studio que serão usadas nesse projeto
gemini.api.key=
```
### Exemplo de como configurar os perfis no ambiente de Produção
- Crie o arquivo `application-prod.properties` no caminho `src/main/resources/application-prod.properties`
- Preencha as propriedades abaixo nesse arquivo,  
- Voce precisara consultar as chaves de API usadas no Google AI Studio
```bash
# Chave de API dos projetos criados no Google AI Studio que serão usadas nesse projeto
gemini.api.key=
```
---

## Build da aplicação

Para gerar o `.jar` da aplicação, execute no terminal:

```bash
mvn clean package
```

Ou gere o `.jar` através do plugin Maven no Intellij:
- Abra o plugin do Maven
- Selecione a aplicação
- Selecione `Lifecycle`
- Execute a opção `clean`
- Depois execute a opção `package`

O arquivo `.jar` será gerado na pasta `target`.

# Visão geral da aplicação
A aplicação recebe uma descrição de um item de uma ordem de compra, passa ela
junto com um prompt para o Gemini usando a API do Google AI Studio, a API, retorna uma String
resumindo essa descrição e atualiza no banco de dados.