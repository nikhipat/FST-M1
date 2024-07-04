choice1=input("Enter player1 choice:")
choice2=input("Enter player2 choice:")

if choice1==choice2:
    print("tie")
elif choice1=="rock":
    print("player1 wins")
elif choice2=="rock":
    print("player2 wins")
elif choice1=="scissors":
    if choice2=="paper":
        print("player1 wins")
    else: print("player2")
elif choice1=="paper":
    if choice2=="scissors":
        print("player2 wins")
else: print("Player2 wins")