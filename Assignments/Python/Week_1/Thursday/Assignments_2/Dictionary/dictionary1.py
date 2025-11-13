

countries = {"USA" : "Washington D.C.",
             "UK" : "London",
             "Canada" : "Ottawa", 
             "Japan" : "Tokyo",
             "Spain" : "Madrid"}

def get_capital(country):
    if country in countries:
        return countries[country]
    else:
        return "Not in dictionary"
            



print(get_capital("UK"))