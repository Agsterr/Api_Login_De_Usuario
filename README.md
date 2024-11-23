   
  **Descrição da minha aplicação**:

   Esta api foi desenvolvida para cadastrar, fazer login e autenticação e listar os usuários 
   é um sistema para cadastrar novos usuarios e fazer requisições de dados do usuário e checar se as informações são válidas.
     
   
 
   **Instruções de uso da api de cadastro**:

  
   1-fazer o clone desse repositório .
   2-Instalar um pacote do java jdk ou java jre.
   3-Executar o arquivo jar 
   
  ## Pré-requisitos

  **Java**: Certifique-se de ter o Java instalado em sua máquina. Você pode baixar a versão mais recente do Java no site oficial:
  [https://www.oracle.com/java/technologies/javase-downloads.html](https://www.oracle.com/java/technologies/javase-downloads.html)
  **JDK Compatível**: Este projeto foi testado com a versão `Java 17`. Certifique-se de que sua JDK seja compatível.


  **Digite o comando para verificar se o java foi instalado corretamente**:
  
  java -version
  
  Isso deve retornar a versão do Java instalada em sua máquina.

  **Para executar o sistema, utilize o seguinte comando no terminal**:

  java -jar caminho/para/o/seu/arquivo.jar


  **Exemplo**:

  baixo:

  java -jar demo-0.0.1-SNAPSHOT.jar
  


  
   
 **É necessário cadastrar um usuário com os seguintes dados**:
    
    Usar um json na requisição Post contendo os dados do usuario:

    **Obs**:Escolha a sua cadegoria para o cadastro:
    
    São 3 opções:

    BASICO
    ADMINISTRADOR
    AVANCADO

    exemplo: 

    json:

    {
     "nome": "Nome do usuario",
     "cpf": "12345678991",
     "categoria": "ADMINISTRADOR", 
     "username": "Nome", 
     "password": "Senha"  
    }

     
     
    **Faça uma requisição Post para a api com os dados abaixo**:

    O endereço para a requisição:

    http://localhost:8080/usuarios/cadastro
    
    **Cadastro de usuario**:
     
   '{
     "nome": "Nome",
     "cpf": "12345678991",
     "categoria": "ADMINISTRADOR",
     "username": "Nome de usuario", 
     "password": "Senha"  
    }'

   **Após isso, faça o login da seguinte forma**:

   **Login de usuario**:

   O endereço para a requisição:
   http://localhost:8080/login

   Exemplo:

   json:

   

   {
     "login": "Nome de usuario",
     "senha": "Senha"   
   }


     **Faça uma requisição Post para a api com os dados abaixo**


    
    '{
       "login": "Agster123",
       "senha": "senha123"   
     }'

     No retorno da solicitação de login vai vir o token para a autenticação dos dados .

     exemplo de token:

     SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c
     



    Agora, para **listar** os usuários, pegue o token que retorna na requisição de login e execute este comando:

     **Faça uma requisição Get para a api com os dados abaixo**

      Token de usuario no corpo da requisição.

      Para o endereço:

       http://localhost:8080/usuarios
