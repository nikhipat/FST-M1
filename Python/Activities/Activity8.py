num_list=list(input("Enter numbers:").split(","))

start=num_list[0]
end=num_list[-1]

if (start==end):
    print(True)
else:
    print(False)