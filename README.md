# DESAFIO DE PROGRAMAÇÃO - ACADEMIA CAPGEMINI
#### By Thiago Ferreira Matos
![](https://www.capgemini.com/br-pt/wp-content/themes/capgemini-komposite/assets/images/logo.svg)

## Requisitos
Java 11 ou superior - https://www.oracle.com/br/java/technologies/javase/jdk11-archive-downloads.html

## Build da aplicação
```sh
.\mvnw spring-boot:run
```
Após iniciar o servidor três endpoint serão disponibilizados, a saber:

GET http://localhost:8080/escada/{degr} -> 1º Questão

POST http://localhost:8080/password -> 2º Questão

GET http://localhost:8080/anagram -> 3º Questão

onde o {degr} é o tamanho da escada.

## Teste/Utilização

Linux
```sh
curl --location --request GET 'http://localhost:8080/escada/6'

curl --location --request POST 'http://localhost:8080/password' \
--header 'Content-Type: text/plain' \
--data-raw 'pass'

curl --location --request GET 'http://localhost:8080/anagram' \
--header 'Content-Type: text/plain' \
--data-raw 'ovo'
```
Windows
```sh
curl --location --request GET "http://localhost:8080/escada/6"

curl --location --request POST "http://localhost:8080/password" --header "Content-Type: text/plain" --data-raw "pass"

curl --location --request GET "http://localhost:8080/anagram" --header "Content-Type: text/plain" --data-raw "ovo"
```
