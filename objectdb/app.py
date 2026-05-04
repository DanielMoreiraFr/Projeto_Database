import streamlit as st
from connect import get_all_products, create_product, update_product, delete_product

st.title("Interface Interativa com ObjectDB")

# Exibir todos os produtos
st.subheader("Produtos Cadastrados")
products = get_all_products()
for product in products:
    st.write(f"ID: {product.id}, Nome: {product.nome}")

# Adicionar novo produto
st.subheader("Adicionar Novo Produto")
new_product_name = st.text_input("Nome do Produto:")
if st.button("Adicionar"):
    if new_product_name:
        create_product(Produto(nome=new_product_name))
        st.success("Produto adicionado com sucesso!")

# Atualizar produto existente
st.subheader("Atualizar Produto Existente")
product_id = st.number_input("ID do Produto:", min_value=1, step=1)
new_name = st.text_input("Novo Nome do Produto:")
if st.button("Atualizar"):
    if product_id and new_name:
        update_product(product_id, new_name)
        st.success("Produto atualizado com sucesso!")

# Deletar produto
st.subheader("Deletar Produto")
delete_id = st.number_input("ID do Produto para Deletar:", min_value=1, step=1)
if st.button("Deletar"):
    if delete_id:
        delete_product(delete_id)
        st.success("Produto deletado com sucesso!")