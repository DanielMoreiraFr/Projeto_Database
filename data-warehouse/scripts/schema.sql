-- Dimensão Tempo
CREATE TABLE dim_tempo (
    id_tempo SERIAL PRIMARY KEY,
    ano INT,
    mes INT,
    dia INT
);

-- Dimensão Produto
CREATE TABLE dim_produto (
    id_produto SERIAL PRIMARY KEY,
    nome VARCHAR(100),
    categoria VARCHAR(50),
    marca VARCHAR(50)
);

-- Tabela Fato Venda
CREATE TABLE fato_venda (
    id_venda SERIAL PRIMARY KEY,
    tempo_id INT REFERENCES dim_tempo(id_tempo),
    produto_id INT REFERENCES dim_produto(id_produto),
    quantidade INT,
    valor_total DECIMAL(10,2)
);
