import pandas as pd
#from pandas import ExcelFile
from pandas import ExcelWriter

table={
    "FirstName":["Satvik","Avinash","Lahri"],
    "LastName":["Shah","Kati","Rath"],
    "Email":["satshah@example.com", "avinashK@example.com", "lahri.rath@example.com"],
	"PhoneNumber":["4537829158", "4892184058", "4528727830"]
}

dataframe=pd.DataFrame(table)

print(dataframe)

writer=ExcelWriter("inputs/details.xlsx")
dataframe.to_excel(writer,sheet_name="sheet1",index=False)
writer._save()
