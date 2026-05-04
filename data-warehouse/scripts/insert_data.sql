-- Inserindo registros na dimensão tempo
INSERT INTO dim_tempo (ano, mes, dia) VALUES
(2024, 1, 10),
(2024, 2, 15),
(2024, 3, 20);

-- Inserindo registros na dimensão produto
INSERT INTO dim_produto (nome, categoria, marca) VALUES
('Notebook Dell XPS', 'Eletrônicos', 'Dell'),
('Smartphone Samsung Galaxy S24', 'Eletrônicos', 'Samsung'),
('Camisa Social Masculina', 'Roupas', 'Nike'),
('Calça Jeans Slim Fit', 'Roupas', 'Levis'),
('Mouse sem fio Logitech M330', 'Acessórios', 'Logitech'),
('Teclado Mecânico Redragon K552', 'Acessórios', 'Redragon');

-- Inserindo vendas
INSERT INTO fato_venda (tempo_id, produto_id, quantidade, valor_total) VALUES
(1, 1, 2, 6000.00),   -- Janeiro - Notebook
(1, 3, 5, 750.00),   -- Janeiro - Camisa
(2, 2, 1, 4500.00),  -- Fevereiro - Smartphone
(2, 5, 3, 240.00),   -- Fevereiro - Mouse
(3, 4, 2, 300.00),   -- Março - Calça
(3, 6, 2, 300.00);   -- Março - Teclado