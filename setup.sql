-- ==========================
-- TABELA DE VEÍCULOS
-- ==========================
CREATE TABLE veiculos (
    id SERIAL PRIMARY KEY,
    modelo VARCHAR(80) NOT NULL,
    marca VARCHAR(80) NOT NULL,
    ano INT NOT NULL,
    preco NUMERIC(10,2) NOT NULL,
    disponivel BOOLEAN NOT NULL DEFAULT TRUE
);

INSERT INTO veiculos (modelo, marca, ano, preco, disponivel) VALUES
('Onix LT 1.0', 'Chevrolet', 2020, 52800.00, TRUE),
('HB20 Comfort Plus', 'Hyundai', 2019, 45500.00, TRUE),
('Corolla XEi', 'Toyota', 2018, 92500.00, TRUE),
('Gol G6 1.6', 'Volkswagen', 2016, 37900.00, TRUE),
('Fiesta SE 1.6', 'Ford', 2017, 42000.00, TRUE),
('Civic LX 2.0', 'Honda', 2021, 110000.00, TRUE),
('Renegade Sport 1.8', 'Jeep', 2019, 98000.00, TRUE),
('Sandero Expression 1.0', 'Renault', 2018, 40000.00, TRUE);

-- ==========================
-- TABELA DE CLIENTES
-- ==========================
CREATE TABLE clientes (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(14) NOT NULL,
    telefone VARCHAR(15) NOT NULL
);

INSERT INTO clientes (nome, cpf, telefone) VALUES
('Carlos Alberto', '123.456.789-00', '71 98888-1111'),
('Mariana Souza', '987.654.321-00', '71 97777-2222'),
('Eduardo Lima', '111.222.333-44', '71 96666-3333');

-- ==========================
-- TABELA DE ALUGUÉIS
-- ==========================
CREATE TABLE alugueis (
    id SERIAL PRIMARY KEY,
    id_cliente INT NOT NULL,
    id_veiculo INT NOT NULL,
    inicio DATE NOT NULL,
    fim DATE NOT NULL,
    valor NUMERIC(10,2) NOT NULL,
    CONSTRAINT fk_cliente FOREIGN KEY (id_cliente) REFERENCES clientes(id),
    CONSTRAINT fk_veiculo FOREIGN KEY (id_veiculo) REFERENCES veiculos(id)
);

INSERT INTO alugueis (id_cliente, id_veiculo, inicio, fim, valor) VALUES
(1, 1, '2025-01-10', '2025-01-15', 1500.00),
(2, 3, '2025-02-01', '2025-02-05', 2200.00);

-- ==========================
-- TABELA DE FUNCIONÁRIOS
-- ==========================
CREATE TABLE funcionarios (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cargo VARCHAR(50) NOT NULL
);

INSERT INTO funcionarios (nome, cargo) VALUES
('João Silva', 'Atendente'),
('Ana Paula', 'Gerente'),
('Ricardo Santos', 'Vendedor');
