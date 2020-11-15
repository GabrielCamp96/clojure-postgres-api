Inicializar web service:
- O projeto foi feito utilizando o automatizador de projetos Clojure Leiningen
- basta rodar lein run na pasta root do projeto
- o host é o http://localhost:3000 e possui apenas a rota /teachers, sendo para operações GET e POST
- Foi utilizado o Postman para testes da API, está em anexo uma collection para importação do mesmo. Mas nada impede de utilizar outras ferramentas para requisição.
- As configurações do PostgreSQL estão apartadas no arquivo .env.development e são consumidas pelo script db.clj, facilitando a edição caso necessário


Iniciar banco de dados Postgres SQL 13:
- abrir o terminal
- no root do projeto, rodar psql -U postgres -f create_user.sql
- rodar psql -U pguser -d pgrest -f create_db.sql


Obs: Caso em alguma das requisições o Postgres avise sobre erro em tipo de autenticação, navegar até as pastas C:\Program Files\PostgreSQL\13\data (exemplo), abrir o arquivo
ph_hba.conf e trocar o METHOD para trust na linha de conexões locals IPv4