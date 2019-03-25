# GUIA DE INSTALAÇÃO E EXECUÇÃO

# Resumo: 
Tutorial para configuração e execução da automação Fluxo de Compra.

# Ferramentas utilizadas:
**IDE de desenvolvimento:** Eclipse

# Frameworks: 
- **Maven** – controle de versões.
- **Cucumber** – responsável interação das histórias com desenvolvimento.
- **Selenium Webdriver** – responsável pela manipulação de elementos Web.
- **Junit** -  indicado para criação de testes Unitários.
- **ExtentReports** – responsável pela geração de relatório Html das execuções.

# Estrutura de pastas utilizadas:
O projeto contém a seguinte estrutura
- **locators** – Armazena arquivos dos elementos mapeados da tela.
- **pages** – Armazena arquivos responsáveis pelas interações dos elementos mapeados.
- **steps** – Armazena arquivos gerados a partir das features criadas, fazendo a chamada das pages.
- **system**
	- **TestRule**(Regras de Testes) – são feitas a configurações de execução.
	- **Utils** – utilizado para armazenar métodos reutilizáveis.
 	- **TestRunner** – configuração de chamada da feature para execução.

# Pasta do Relatório de execução:
src\test\resources

Arquivo: **htmlReporter.html**

# Configuração Ambiente Desenvolvimento: 
- Instalar ambiente de desenvolvimento java. *
- Instalar ambiente Maven “https://maven.apache.org/download.cgi”.
- Instalação Cucumber: *
  - Clicar menu Help/ Install New Software
	- Digitar Work With: 
      “https://cucumber.io/cucumber-eclipse/update-site ” *
  - Adicionar dependências no arquivo “pom.xml”.
versões utilizadas na data da criação desta estrutura (21/03/2019).
    - cucumber-java - 1.2.5
    - selenium-java - 3.141.59
    - cucumber-junit - 1.2.5
    - extentreports - 4.0.5

**Obs:** 
1 - As versões frameworks utilizadas informei para efeito de conhecimento, não sendo necessario se atentar, pois ao importar o projeto o arquivo pom.xml se encarrega de baixar as dependências. 

2 - não e necessário instalar o ambiente maven, foi incluido para caso de execução via CMD.
"pasta_projeto/mvn test -Dcucumber.options="--Tags @Tag""


# Configuração Importar para Eclipse:
Após o ambiente desenvolvimento criado:
- Baixar projeto do git "https://github.com/Janiogmf/testdbserver"
- Abrir eclipse.
- Clicar na aba "File".
- Selecionar "Import".
- Selecionar tipo de projeto **"Existing Maven Projects"** na opção Maven.
	-Importar projeto baixado.
- Executar arquivo .feature ou arquivo "FluxoCompraTest.java"
