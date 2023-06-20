## Questão 1:
#### Desenvolva uma aplicação Java com JSF + richfaces (ou primefaces). Esta aplicação listará os planetas encontrados em Star Wars.
### Funcionalidades desejadas:
- Adicionar um planeta (com nome, clima e terreno)
- Listar planetas
- Buscar por nome
- Buscar por ID
- Remover planeta

### Requisitos:
#### Para cada planeta, os seguintes dados devem ser obtidos do banco de dados da aplicação, sendo inserido manualmente: Nome, Clima e Terreno
#### Para cada planeta também devemos ter a quantidade de aparições em filmes, que podem ser obtidas pela API pública do Star Wars: https://swapi.dev/about, buscando pelo nome do planeta

### Linguagens: #### Java
### Bancos: #### SQL em memória

Um bom software é um software bem testado.
-------------
A API adiciona, busca e remove planetas. Caso o planeta adicionado for do universo Star Wars a API conta quantas vezes o planeta apareceu em filmes e adiciona essa informação no campo count_films

Comando para inicialização do projeto:
```
$ mvn spring-boot:run
```
### POST /planets
Requisição para criação de um Planeta
```
{
  "nome": "Dagobah", 
  "clima": "tropical",
  "terreno": "jungle"
}
```
### GET /planets
Requisição para listar todos os planetas

### GET /planets/id/2
Requisição para buscar um planeta pelo id

### GET /planets/name/cote
Requisição para buscar um planeta pelo nome

### DELETE /planets/1
Requisição para remover um planeta pelo id

### GET /swapi/planets
Requisição para listar todos os planetas da API externa (swapi.dev/api/)
___________________________________________

## Questão 2:

#### Em uma estrutura git onde temos as branchs master e develop, após receber duas solicitações, uma para correção de um erro e outra para criação de uma nova funcionalidade. Como deveria ser criada as branchs segundo o gitflow? Responda em um arquivo .txt nomeado Questao2.txt” dentro do projeto do
Github.

### [resposta no arquivo Questao2.txt]
___________________________________________

## Questão 3 (extra):

##### Em react, faça uma tela com um contador iniciado em 0 e um botão responsável por incrementar este valor. Cada vez que o botão for clicado, o contador deve ser incrementado em 1 unidade. Crie também um botão para zerar o contador. 

### Tecnologias utilizadas:
- React
- CSS

### link para visualizar o projeto:
https://counter-react-diegocrodrigues.vercel.app

