def calculatesum(numbers):
    sum=0
    for num in numbers:
        sum=sum+num
    return sum    

#number_list=list(input("enter numbers:"))
number_list=[1,2,3,5,7]
result=calculatesum(number_list)

print(str(result))