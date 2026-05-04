import streamlit as st
import requests
import pandas as pd

st.title("📊 Dashboard de Vendas - Rede de Lojas Fictícia")

# Consulta à API para vendas mensais
response = requests.get("http://localhost:8000/api/vendas/mensais")
data = response.json()

df = pd.DataFrame(data)
st.subheader("📈 Vendas Mensais")
st.bar_chart(df.set_index("mes"))

# Consulta à API para comentários
comment_response = requests.get("http://localhost:8000/api/comentarios")
comments = comment_response.json().get("comentarios", [])

st.subheader("💬 Comentários dos Clientes")
for c in comments:
    st.text(f"Cliente {c['cliente_id']} (Produto {c['produto_id']}): {c['texto']}")