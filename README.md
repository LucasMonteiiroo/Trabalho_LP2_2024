# Configuração do Ambiente
* Irá precisar que tenha istalado o Maven e o JDK, é possivel verificar executando os seguintes comandos para verificar as versões:
```java
java -version
mvn -version
```
Clone o Repositório
```
- git clone https://github.com/LucasMonteiiroo/Trabalho_LP2_2024
- cd projeto
```
## Compilação e Execução do Projeto
Para compilar e executar o projeto, siga os passos abaixo:

Acesse o diretório raiz do projeto:
```
- cd projeto
```
Compile o projeto usando o Maven:
```
- mvn clean install
```
Execute o aplicativo Spring Boot:
```
java -jar target/Leilao-0.0.1-SNAPSHOT.jar
```
Estará disponível.


# Acesso ao Swagger
* http://localhost:5050/swagger-ui.html

## Endpoints 

## Produto-veiculo-controller

* /dispositivo-veiculo/mudar-leilao/{idProduto}/{idLeilao}

* /dispositivo-veiculo/atualizar/{id}

* /dispositivo-veiculo/criar/{leilaoId}

* /dispositivo-veiculo/criar/utilitario/{leilaoId}

* /dispositivo-veiculo/criar/motocicleta/{leilaoId}

* /dispositivo-veiculo/criar/carro/{leilaoId}

* /dispositivoveiculo/criar/caminhao/{leilaoId}

* /dispositivo-veiculo/{idProduto}

* /dispositivo-veiculo/listar-todos

* /dispositivo-veiculo/deletar/{id}

## Produto-informatica-controller

* /dispositivo-informatica/mudar-leilao/{idProduto}/{idLeilao}

* /dispositivo-informatica/atualizar/{id}

* /dispositivo-informatica/criar/{leilaoId}

* /dispositivo-informatica/criar/switch/{leilaoId}

* /dispositivo-informatica/criar/roteador/{leilaoId}

* /dispositivo-informatica/criar/notebook/{leilaoId}

* /dispositivo-informatica/criar/monitor/{leilaoId}

* /dispositivo-informatica/criar/hub/{leilaoId}

* /dispositivo-informatica/criar/{leilaoId}

* /dispositivo-informatica/listar-todos

* /dispositivo-informatica/deletar/{id}

## Cliente-controller

* /cliente/atualizar-cliente/{cpf}

* /cliente

* /cliente/procurar-por-cpf/{cpf}

* /cliente/procurar-lances-por-cpf/{cpf}

* /cliente/listar-todos

* /cliente/deletar/{cpf}

## Leilao-controller

* /leilao/gerar-arquivo-det/{idLeilao}

* /leilao/criar

* /leilao/listar

* /leilao/detalhamento/{id}

* /leilao/buscar-produtos/{idLeilao}

* /leilao/deletar/{id}

## Instituicao-financeira-controller

* /instituicao-financeira/atualizar/{id}

* /instituicao-financeira/vincular-leilao-instituicao/{idLeilao}/{idInstituicao}

* /instituicao-financeira/criar

* /instituicao-financeira/consultar/{id}

* /instituicao-financeira/consultar/leilao/{id}

* /instituicao-financeira/deletar/{id}

## Lance-controller

* /lance/historico/{produtoId}/{categoriaProduto}

* /lance/gerar-lance/{produtoId}/{clienteCpf}/{valor}/{categoriaProduto}

