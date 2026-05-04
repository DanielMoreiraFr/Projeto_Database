from pymongo import MongoClient

def get_mongo():
    client = MongoClient("mongodb://localhost:27017")
    db = client["varejo"]
    return db["comentarios"]

# Exemplo de inserção de dados
def insert_comentario(cliente_id, produto_id, texto):
    collection = get_mongo()
    comentario = {
        "cliente_id": cliente_id,
        "produto_id": produto_id,
        "texto": texto
    }
    collection.insert_one(comentario)
    print("Comentário inserido no MongoDB")

if __name__ == "__main__":
    insert_comentario(101, 1, "Produto excelente!")
    insert_comentario(102, 2, "Entrega rápida.")