from sklearn.cluster import KMeans
import pandas as pd

# Simulação de dados fictícios
dados_clientes = pd.DataFrame({
    'gasto_total': [1000, 2000, 3000, 1500, 2500],
    'frequencia': [5, 10, 3, 7, 9]
})

# Aplicando K-Means
kmeans = KMeans(n_clusters=2)
kmeans.fit(dados_clientes)
dados_clientes['cluster'] = kmeans.labels_

print("Clientes agrupados:")
print(dados_clientes)