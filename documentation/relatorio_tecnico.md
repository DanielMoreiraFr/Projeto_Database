
### Arquivo: `documentation/relatorio_tecnico.md`

```markdown
# Relatório Técnico – Sistema de Análise de Varejo Multimodelo

## Arquitetura
O sistema foi desenvolvido com múltiplos modelos de bancos de dados:
- PostgreSQL: armazena dados históricos com esquema estrela
- MongoDB: armazena dados não estruturados (comentários de clientes)
- FastAPI: integra os diferentes bancos de dados
- Streamlit: interface interativa para análise de vendas

## Modelagem de Dados
- **Dimensões**: Tempo, Produto
- **Tabela Fato**: Venda
- **Modelo Temporal**: histórico de preços e estoque

## Análise de Dados
- Clusterização de clientes com KMeans
- Previsão de vendas com modelo ARIMA
- Consultas OLAP com agrupamento por mês e categoria

## Integração entre Bancos
- API REST integrando PostgreSQL + MongoDB
- Dashboard consumindo dados da API
- Scripts de análise usando Pandas e Scikit-Learn

## Resultados
- Dados históricos organizados
- Insights sobre tendências de vendas
- Comentários de clientes disponíveis via API
- Visualizações interativas no dashboard