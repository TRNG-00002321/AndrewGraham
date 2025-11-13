import sys

def Selection():
    input_number = input("Please Select a Drink: 1, 2, or 3\n")

    try:
        input_number = int(input_number)
    except ValueError:
        print("Invalid Selection")
        sys.exit()

    if input_number == 1:
        price = 1.00
        print("Water: $1.00\n")
    elif input_number == 2:
        price = 1.50
        print("Cola: $1.50\n")
    elif input_number == 3:
        price = 2.00
        print("Gatorade: $2.00\n")
    else:
        print("Invalid Selection")
        sys.exit()
    
    return price


def Coin_count():
    
    num_quarters = int(input("How many quarters?\n"))
    num_dimes = int(input("How many dimes?\n"))
    num_nickels = int(input("How many nickels?\n"))
    num_pennies = int(input("How many pennies?\n"))

    total = (num_quarters*.25)+(num_dimes*.10)+(num_nickels*.05)+(num_pennies*.01)
    return total

def Price_Check(payment, price):
    if payment == price:
        print("Thank you for your purchase! No change required.")
        return True
    elif payment > price:
        change = payment - price
        print(f"Thank you for your purchase! Your change is ${change:.2f}.")
        return True
    elif payment < price:
        difference = price - payment
        print(f"Insufficient Funds. Plase add ${difference:.2f}.\n")
        complete_transaction = input("Would you like to continue? y/n \n")
        if complete_transaction =="n":
            print(f"Transaction Cancelled. Returning ${payment:.2f}")
            sys.exit()
        return False

selected_price = Selection()
payment_amount = Coin_count()
while not Price_Check(payment_amount, selected_price):
    payment_amount += Coin_count()
    