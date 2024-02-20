# Ideia

Esse repositório serve como base para exemplos de atividades envolvendo um servidor escrito em Kotlin utilizando o framework [Ktor](https://ktor.io/).

# Features


## Roteamento

O serviço fornece algumas rotas com utilização de alguns recursos, dentre elas:

### /customer/{id}
A rota /customer/{id} introduz uma configuração de rotas dinâmicas, devolvendo uma resposta com base no valor passado em {id}.

### /repos
A rota /repos lista um array de repositórios fictícios, a ideia por trás dessa listagem envolve a utilização de [Data Classes](https://kotlinlang.org/docs/data-classes.html) que poderiam ser futuramente resposta de uma requisição feita pelo server.

## Persistência

A persistêencia é feita utilizando o Local Database Engine H2 em conjunto com o framework [Exposed](https://ktor.io/docs/interactive-website-add-persistence.html) oferecido pelo Ktor como padrão.