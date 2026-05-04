# Manual do Usuário – Sistema de Análise de Varejo Multimodelo

## Funcionalidades
- Visualização de vendas mensais
- Análise de comentários de clientes
- Previsão de vendas futuras
- Agrupamento de clientes

## Como Executar

1. Suba o PostgreSQL e crie o banco `dw_varejo`
2. Execute o servidor FastAPI:
   ```bash
   cd backend
   uvicorn main:app --reload

   cd dashboard
   streamlit run app.py