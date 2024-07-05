import pandas as pd

table={
    "Usernames":["admin","Charles","Deku"],
    "Passwords":["password","Charl13","AllMight"]
}

dataframe=pd.DataFrame(table)

print(dataframe)

dataframe.to_csv("input/credentials.csv",index=False)