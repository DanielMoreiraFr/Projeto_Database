from objectdb import ConnectionPool

# Configuração da conexão
connection_string = "objectdb://localhost:27017/database.odb"
factory = ConnectionPool(connection_string)

def get_connection():
    return factory.getConnection()

def create_product(product):
    with get_connection() as conn:
        conn.store(product)
        conn.commit()

def get_all_products():
    with get_connection() as conn:
        query = "SELECT FROM Produto"
        products = conn.query(query)
        return list(products)

def update_product(product_id, new_name):
    with get_connection() as conn:
        product = conn.load(product_id)
        product.nome = new_name
        conn.commit()

def delete_product(product_id):
    with get_connection() as conn:
        product = conn.load(product_id)
        conn.delete(product)
        conn.commit()