import pandas as pd
from pandas import ExcelFile

dataframe=pd.read_excel("inputs/details.xlsx")
print(dataframe)

print(dataframe.shape)

print(dataframe["Email"])

print(dataframe.sort_values("FirstName"))