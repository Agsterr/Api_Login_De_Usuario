CREATE TABLE usuarios (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    cpf VARCHAR(11) NOT NULL UNIQUE,
    categoria VARCHAR(50) NOT NULL,
    username VARCHAR(255) NOT NULL UNIQUE, -- Campo para o nome de usuário (único)
    password VARCHAR(255) NOT NULL -- Campo para a senha criptografada


);
