import statsmodels.api as sm
import pandas as pd

# Dados fictícios de vendas mensais
vendas = pd.Series([100, 120, 130, 150, 140, 160])

# Modelagem
model = sm.tsa.ARIMA(vendas, order=(1, 1, 0))
results = model.fit()

print(results.summary())