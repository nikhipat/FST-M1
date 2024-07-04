def calulatesum(num):    
    if num:
        sum=0
        sum=num+calulatesum(num-1)
        return sum
    else:
        return 0
    
total=calulatesum(10)

print(total)