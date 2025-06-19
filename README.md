# 📌 Gerenciador escolar - Back

## 🔹 Sobre
Este projeto é uma aplicação em **Java** com **SpringBoot** que permite **adicionar**, **listar**, **atualizar** e **deletar** objetos. Ele se comunica com um front em React.js.

## ✨ Funcionalidades
✅ **Adicionar**  
✅ **Deletar**  
✅ **Listar** <br/>
✅ **Atualizar**  

## 🚀 Como rodar o projeto

### 1️⃣ Clone o repositório
```bash
git clone https://github.com/seuusuario/seu-repositorio.git
```

### 2️⃣ Para executar o servidor:
- abrir o terminal na pasta onde você clonou a API;
- rodar o comando `mvn spring-boot:run` para rodar o projeto (precisa ter o maven instalado);
- Ou, pode rodar pelo intellij;

## 📈 Teste:

### PostgreSQL
- Crie um banco de dados local utilizando postgres;
- Os comandos sql estão em um arquivo `comandos-sql.txt` no projeto;
- Será necessário mudar as configurações do banco no arquivo `application.yml`:
 ```bash
    datasource:
      url: jdbc:postgresql://localhost:5432/escola
      username: *****
      password: *****
      driver-class-name: org.postgresql.Driver
  ```

### Postman
- Utilize o postman para poder testar a api

## 📩 Autora
Desenvolvedora: Luísa de Andrade Deschamps

LinkedIn: https://www.linkedin.com/in/luisa-deschamps-404a35311/

E-mail: andradeps434@gmail.com
