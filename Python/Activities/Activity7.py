num_list=list(input("Enter numbers:").split(","))

#num_list=[1,3,5,7,8]
sum=0
for number in num_list:
    sum=sum+int(number)

print(sum)
