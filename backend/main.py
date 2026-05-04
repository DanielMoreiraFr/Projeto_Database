from fastapi import FastAPI
import psycopg2
from pymongo import MongoClient

app = FastAPI()

# Conexão com PostgreSQL
def get_postgres():
    return psycopg2.connect(
        dbname="dw_varejo",
        user="postgres",
        password="123321",
        host="localhost"
    )

# Conexão com MongoDB
def get_mongo():
    client = MongoClient("mongodb://localhost:27017")
    db = client["varejo"]
    return db["comentarios"]

# Rota Raiz
@app.get("/")
def read_root():
    return {"message": "Sistema de Análise de Varejo Multimodelo"}

# Rota OLAP: Vendas por mês
@app.get("/api/vendas/mensais")
def vendas_mensais():
    conn = get_postgres()
    cur = conn.cursor()
    cur.execute("""
        SELECT t.mes, SUM(f.valor_total) AS total
        FROM fato_venda f
        JOIN dim_tempo t ON f.tempo_id = t.id_tempo
        GROUP BY t.mes
        ORDER BY t.mes;
    """)
    result = cur.fetchall()
    conn.close()
    return [{"mes": row[0], "total": float(row[1])} for row in result]

# Rota MongoDB: Comentários
@app.get("/api/comentarios")
def get_comentarios():
    collection = get_mongo()
    comentarios = list(collection.find({}, {"_id": 0}))
    return {"comentarios": comentarios}