🛡️ Projeto Spring Boot com Autenticação JWT
Este repositório contém um projeto backend desenvolvido em Java com Spring Boot, que implementa um sistema básico de autenticação e autorização utilizando JWT (JSON Web Tokens).

🔐 Funcionalidades principais:
Autenticação via /auth/login com geração de token JWT;

Proteção de rotas com verificação de token JWT em todas as requisições (exceto /auth);

Validação automática do token em filtros (via OncePerRequestFilter);

Spring Security configurado para permitir acesso somente a usuários autenticados;

Integração com um repositório JPA para consulta de usuários no banco de dados.

🚀 Tecnologias utilizadas:
Java 17+

Spring Boot

Spring Security

JWT (com biblioteca io.jsonwebtoken)

JPA / Hibernate

Postgres SQL

📦 Como rodar:
Clone o projeto:

bash
Copiar
Editar
git clone #linkgit#
cd nome-do-repo
Rode a aplicação:

bash
Copiar
Editar
./mvnw spring-boot:run
Faça login com o endpoint /auth/login e utilize o token JWT nas demais rotas com o header:

makefile
Copiar
Editar
Authorization: Bearer <seu-token-jwt>