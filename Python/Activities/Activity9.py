num_list1=[1,2,4,7,5]
num_list2=[9,8,5,3]

result_list=[]

for num1 in num_list1:
    if (num1%2!=0):
        result_list.append(num1)

for num2 in num_list2:
    if (num2%2==0):
        result_list.append(num2)

print(result_list)        
