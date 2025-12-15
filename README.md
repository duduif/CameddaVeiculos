# 🚗 Sistema Camedda Veículos

O **Sistema Camedda Veículos** é uma aplicação desenvolvida em **Java** com o objetivo de gerenciar veículos de uma locadora, permitindo realizar operações de **CRUD (Create, Read, Update e Delete)** com persistência em banco de dados relacional.  
O projeto foi desenvolvido como **Trabalho Final da disciplina Linguagem de Programação III**, integrando POO com Banco de Dados.

A aplicação utiliza **PostgreSQL**, acessado via **JDBC**, e foi estruturada seguindo rigorosamente o padrão de arquitetura **MVC (Model-View-Controller)**.  
As operações de **inserção** e **exclusão** de registros são automaticamente registradas no arquivo de auditoria `transacoes.csv`, conforme especificação do trabalho.

---

## 🗄️ Banco de Dados

- **SGBD:** PostgreSQL  
- **Hospedagem:** Render  
- **URL:** jdbc:postgresql://dpg-d4vh64juibrs73d7qk9g-a.oregon-postgres.render.com:5432/camedda_veiculos
- **Usuário:** `camedda_veiculos_user`  
- **Senha:** `fOwDIiDadEXOXPS9eSeywUjG5yxjaDnt`

O script de criação e carga inicial do banco está disponível no arquivo `setup.sql`.

---

## 📂 Arquitetura

O projeto segue o padrão **MVC**:

- **Model:** Classes de domínio e DAO (acesso a dados)
- **View:** Interface em modo console
- **Controller:** Camada intermediária entre View e Model
- **Utils:** Conexão com o banco e sistema de logs

---

## 🧾 Auditoria

O arquivo `transacoes.csv` registra automaticamente:
- **ID do registro**
- **Tipo da operação (INSERT ou DELETE)**
- **Data e hora da operação**

---

## 👥 Autores

- Eduardo Ferreira  
- Luna Camedda  
- Yan Carlo  
