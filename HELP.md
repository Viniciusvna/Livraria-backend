# Getting Started

### Configurando o projeto
* Primeiramente extraia o arquivo zip para o workspace do eclipse
* Em seguida importe o projeto indo em File -> Import -> Existing Maven Projects,
	procure pela pasta do projeto, selecione o mesmo e clique em Finish
* Terminada a importação, crie um banco de dados no MySQL chamado livraria
* Em seguida volte para o eclipse e abra o src/main/resources -> application.properties
* Coloque seu usuário do MySQL no username e a senha no password, depois salve o arquivo application

### Executando o projeto
* Finalmente abra o src/main/java -> com.eliwelton.livraria -> Botão direito em cima do arquivo LivrariaApplication.java,
	vá em Run As -> Java Application
* Depois de carregado o servidor, você tem duas opções:
* *** Digitar o seguinte endereço no seu navegador: http://localhost:8080/swagger-ui.html
	A aplicação executará usando a swagger-ui;
* *** Extrair o arquivo zip livraria-api-rest, consultar o seu README.md para executar a aplicação pelo Vue.js