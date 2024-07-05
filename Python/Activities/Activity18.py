import pandas as pd

data={
    "usernames":["admin","charles","Deku"],
    "passwords":["password","Charl13","AllMight"]
}

dataframe=pd.DataFrame(data)

dataframe.to_csv("inputs/creds.csv",index=False)

#Read from file
table=pd.read_csv("inputs/creds.csv")

print(table["usernames"])

print("username:",table["usernames"][1],"|password:",table["passwords"][1])

print(table.sort_values("usernames"))

print(table.sort_values("passwords",ascending=False))