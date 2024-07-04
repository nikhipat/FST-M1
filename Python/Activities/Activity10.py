num_tuple=tuple(input("Enter numbers:").split(","))

for num in num_tuple:
    if (int(num)%5==0):
        print(num)