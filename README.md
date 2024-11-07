   Esta api foi desenvolvida para cadastrar, fazer o login e autenticação e listar os usuarios.

   Atenção esse passo a passo com os comandos são para executar a aplicação pelo Ubuntu-24.04.1 via terminal e precisa ter o asdf instalado para executar os comandos dessa forma que foi explicado .

   Oque é o asdf: O asdf é uma ferramenta de gerenciamento de versões para diferentes linguagens de programação. 

   Para o funcionamento da Api tem que instalar as seguintes aplicações:
    
    Java:
    
    Usar os seguintes comandos:

    1-Plugin: 

    asdf plugin add java

    2-Versão
    asdf install java 17.0.2

    Maven:

   1- Plugin:

   asdf plugin-add maven  https://github.com/halcyon/asdf-maven.git

   2-Versão:
    asdf install maven 3.9.8 



    

    1-Para rodar a aplicação usar o comando: `mvn spring-boot:run`.

    Depois abra mais um terminal e execute os comandos abaixo:

  
   
1. É necessário cadastrar um usuário com os seguintes dados:
    
    Usar um json na requisição Post contendo os dados do usuario:

    exemplo: 

    json:

    {
     "nome": "Agster Junior",
     "cpf": "12345678991",
     "categoria": "ADMINISTRADOR", //Colocar a sua categoria de usuario valida.
     "username": "Agster123", 
     "password": "senha123"  
    }

    Depois execute o seguinte comando:

    
   
   curl -i -X POST "http://localhost:8080/usuarios/cadastro" -H "Content-Type: application/json" -d 
   '{
     "nome": "Agster Junior",
     "cpf": "12345678991",
     "categoria": "ADMINISTRADOR",
     "username": "Agster123", 
     "password": "senha123"  
    }'

   Após isso, faça o login da seguinte forma:

   Exemplo:

   json:

   //Colocar nome que esta no cadastro
   //Colocar senha do cadastro

   {
     "login": "Agster123", //Colocar nome que esta no cadastro
     "senha": "senha123"   //Colocar senha do cadastro
   }


    Após isso faça o login da seguinte forma:


    curl -i -X POST "http://localhost:8080/login" -H "Content-Type: application/   json" -d 
    '{
       "login": "Agster123",
       "senha": "senha123"   
     }'

     No retorno da solicitação de login vai vir o token para a autenticação dos dados .

     exemplo de token:

     SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c
     



    Agora, para listar os usuários, pegue o token que retorna na requisição de login e execute este comando:


    curl -X GET "http://localhost:8080/usuarios" -H "Authorization: Bearer SEU_TOKEN_AQUI"
  
    Obs: Estas instruções acima são para rodar a aplicação no Linux para rodar no windows da para rodar pelo prompt de comando também ou por uma IDE exemplo: IntelliJ IDEA   .

