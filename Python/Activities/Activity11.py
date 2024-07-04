fruit_dict = {
    "apple":12,
    "banana":11,
    "orange":13,
    "kiwi":14
}

for fruit,price in fruit_dict.items():
    print(fruit,price)

name=input("Enter fruit name:").lower()

if(name in fruit_dict):
    print("fruit is available")
else:
    print("fruit is not available")
