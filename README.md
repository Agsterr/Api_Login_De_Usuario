# Api_Login_De_Usuario



 Obs: Essas instruções a seguir são um passo a passo completo desde a instalação da maquina virtual até executar a aplicação usando o Linux, se ja tiver a maquina configurada va para a execução de aplicação logo a baixo.
 
1. Virtual Box
2. Primeiro Passo: instalar Ubuntu.
2. Configurar o Ubuntu.
3. Passos para configuração:
   1. Instalar o `apt`, que é um gerenciador de pacotes muito útil.
   2. Instalar o `Vim`, um ótimo editor de texto e documentos.
   3. Instalar o `curl`, que é uma ferramenta muito útil para testes na API e automação.
   4. Instalar o `git`.
   5. Instalar o `asdf`, que é um gerenciador de versões universal de ferramentas de desenvolvimento, permitindo instalar e gerenciar diferentes versões de várias linguagens e ferramentas.
   6. Instalar o `gawk`, que é uma implementação da linguagem AWK, usada para processamento de texto. Ele é muito útil para manipular dados estruturados em arquivos de texto, como logs ou arquivos CSV.
   7. Instalar o `gpg` (GNU Privacy Guard), que é uma ferramenta de criptografia que permite criptografar e assinar dados e comunicações. Ele é amplamente usado para proteger informações confidenciais e para verificação de pacotes em distribuições Linux.
   8. Instalar o comando `sha256sum`, que é uma ferramenta de linha de comando no Linux usada para calcular o hash SHA-256 de um arquivo ou string de texto.
   9. Criar minha chave SSH com `ssh-keygen` para acessar meu Git da máquina virtual.
   10. Baixar o back-end da minha API na máquina virtual.
   11. Instalar o Maven (`mvn`) para gerenciar as dependências da minha API.
   12. Executar o `mvn`.
   13. Adicionar a propriedade `<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>`.

   14. Rodar a aplicação usando o comando `mvn spring-boot:run`.

Agora, vou citar as instruções para a API funcionar.

A API é para login e autenticação de usuário.

1. Para a API funcionar, é necessário cadastrar um usuário com os seguintes dados:

   Criar um arquivo JSON dessa forma no terminal:

   
   curl -i -X POST "http://localhost:8080/usuarios/cadastro" -H "Content-Type: application/json" -d '{
     "nome": "Agster Junior",
     "cpf": "12345678991",
     "categoria": "ADMINISTRADOR",
     "username": "Agster123", //Escolher seu nome de usuario.
     "password": "senha123"   //Escolher a sua senha.
   }'

   Após isso, faça o login da seguinte forma:


curl -i -X POST "http://localhost:8080/login" -H "Content-Type: application/json" -d '{
  "login": "Agster123", //Colocar nome que esta no cadastro
  "senha": "senha123"   //Colocar senha do cadastro
}'


Agora, para listar os usuários, pegue o token que retorna na requisição de login e faça este comando:


curl -X GET "http://localhost:8080/usuarios" -H "Authorization: Bearer SEU_TOKEN_AQUI"
  
 Obs: Estas instruções acima são para rodar a aplicação no Linux para rodar no windows da para rodar pelo prompt de comando tambem ou por uma IDE.

