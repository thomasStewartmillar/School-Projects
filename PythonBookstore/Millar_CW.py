import time
import matplotlib.pyplot as plot

# Global Variables. bookList is populated by the read_file function initially and can be easily accessed and modified
# by all the other functions. menuFormat is a string for readability and called so frequently I declared it as global.
bookList = []
menuFormat = ('-'*101)


def read_file():
    try:
        bookFile = open("BOOK_DATA.txt", "r")
        for line in bookFile:
            bookRead = []  # Create empty list to hold an individual record of a book's details
            startPos = 0
            if not line.startswith('#'):
                for index in range(len(line)):
                    if line[index] == ',' or index == len(line)-1:
                        bookRead.append(line[startPos:index].strip())
                        startPos = index+1
                bookList.append(bookRead)  # Append the now full book entry bookRead into the bookList global list.
        bookFile.close()
        print('File Read Successful!')
        time.sleep(0.5)
    except IOError:
        print('Error Reading File')
        quit()


def print_summary():
    print(menuFormat)
    for title in bookList:
        print()
        for attribute in title:
            print(attribute, "", sep=', ', end='')


def total_stock(x, y):
    numBooks = len(bookList)
    totalStockValue = 0

    for title in bookList:
        bookCost = (float(title[x]))
        bookStock = (int(title[y]))

        totalLineValue = bookCost * bookStock
        totalStockValue += totalLineValue

    return numBooks, totalStockValue


def total_stock_print(stock, value):
    total_stock(4, 5)
    numBooks = stock
    totalStockValue = value

    print()
    print(menuFormat)
    print('\n')
    print('There are', numBooks, 'titles currently stocked.')
    print('Current value of inventory is £', format(totalStockValue, '.2f'), sep='')
    print('\n')
    time.sleep(1)


def average_price(cost, stock):
    bookRunningTotal = 0
    isBookStocked = 0
    averagePrice = 0

    for title in bookList:
        bookCost = (float(title[cost]))
        bookStock = (int(title[stock]))
        if bookStock > 0:
            bookRunningTotal += bookCost
            isBookStocked += 1

    averagePrice = bookRunningTotal/isBookStocked
    return averagePrice, isBookStocked


def average_print(av, bookstock):
    averagePrice = av
    isBookStocked = bookstock
    print(menuFormat)
    print('\n')
    print('Current average value of inventory in stock is £', format(averagePrice, '.2f'), sep='')
    print('There are', isBookStocked, 'titles currently in stock.')
    print('\n')
    time.sleep(1)


def list_sorter_two_param(x, y):
    listKey = []
    listVal = []

    for title in bookList:
        fieldX = (title[x])
        fieldY = (title[y])
        listKey.append(fieldX)
        listVal.append(fieldY)

    listSort = list(zip(listKey, listVal))
    dictionarySort = dict(zip(listKey, listVal))
    return dictionarySort
    return listSort


def genre_sort():
    xAxis = []
    yAxis = []
    uniqueGenre = set()
    genreList = []
    dictionaryTemp = list_sorter_two_param(1, 6)

    for key, value in dictionaryTemp.items():
        genreList.append(value)
        uniqueGenre.add(value)

    for i in range(0, len(uniqueGenre)):
        genre = uniqueGenre.pop()
        counter = 0
        for j in range(0, len(genreList)):
            if genre == genreList[j]:
                counter += 1
        xAxis.append(genre)
        yAxis.append(counter)

    return xAxis, yAxis


def genre_tally_print():
    genreDictionary = list_sorter_two_param(1, 6)

    uniqueGenre = set()
    genreList = []

    for key, value in genreDictionary.items():
        genreList.append(value)
        uniqueGenre.add(value)

    print(menuFormat)
    print('Here are the number of titles we currently offer across different genres: \n')
    for i in range(0, len(uniqueGenre)):
        genre = uniqueGenre.pop()
        counter = 0
        for j in range(0, len(genreList)):
            if genre == genreList[j]:
                counter += 1
        print(str.capitalize(genre), '-', counter)
    print()
    time.sleep(1)


def sorted_print_author():
    print(menuFormat)
    print('Current Titles by Author:\n')
    initialDictionary = list_sorter_two_param(0, 1)

    for value in sorted(initialDictionary):
        print(value, '-', initialDictionary[value])

    time.sleep(3)


def sorted_print_genre():
    print(menuFormat)
    print('Current Titles by Genre:')

    listKey = []
    listVal = []

    for title in bookList:
        fieldX = (title[6])
        fieldY = (title[1])
        listKey.append(fieldX)
        listVal.append(fieldY)

    initialList = list(zip(listKey, listVal))
    sortedList = sorted(initialList)

    for title in sortedList:
        print()
        for attribute in title:
            print(attribute, " - ", sep='', end='')

    print()
    time.sleep(3)


def add_record():
    print(menuFormat)
    bookRecord = []
    correctEntry = True

    startAv, startStock = average_price(4, 5)

    # Create a record for a book from user input by adding relevant data into
    # the empty list bookRecord, where each user input prompt equates to a field for each record.
    # Input validation utilised to ensure consistency of data, specifically with the areas
    # cost and stock that deal with numerical values.

    author = input('Enter Book Author: ')
    author = author.strip()
    bookRecord.append(author)
    title = input('Enter Book Title: ')
    title = title.strip()
    bookRecord.append(title)
    bookFormat = input('Enter Book Format: ')
    bookFormat = bookFormat.strip()
    bookRecord.append(bookFormat)
    publisher = input('Enter Publisher: ')
    publisher = publisher.strip()
    bookRecord.append(publisher)
    try:
        cost = float(input('Enter the cost of a title: '))
        bookRecord.append(cost)
    except ValueError:
        print('Please Enter a Numerical Value: ')
        cost = float(input('Enter the cost of a title: '))
        bookRecord.append(cost)
    try:
        stock = int(input('Enter the stock levels of the item: '))
        bookRecord.append(stock)
    except ValueError:
        print('Please Enter a Numerical Value: ')
        stock = int(input('Enter the stock levels of the item: '))
        bookRecord.append(stock)
    genre = input('Enter the genre of the book: ')
    genre = genre.strip()
    bookRecord.append(genre)

    # Take the individual record for a book and its attributes and data that have been added to the
    # bookRecord list and append that now-completed entry to the original bookList list that
    # was initially read from file, so the new data is now part of that list.

    bookList.append(bookRecord)

    endAv, endStock = average_price(4, 5)
    avDifference = endAv - startAv
    stockIncrease = endStock - startStock
    print(menuFormat)
    print('Record Successfully Entered!\n')
    time.sleep(1.5)
    print('Previous average value of inventory in stock was £',format(startAv, '.2f'), ' for ', startStock, ' items', sep='')

    print('Updated average value of inventory in stock is £',format(endAv, '.2f'), ' for ', endStock, ' items', sep='')
    print('\nA change in average value of £',format(avDifference ,'.2f'), ' for a stock increase of ', stockIncrease, sep='')
    print(menuFormat)
    print()
    time.sleep(2)
    userChoice = input('Do you wish to add another book?\n'
                       'If Yes, enter Y\nTo return to the main menu, enter anything else: ')
    if userChoice.upper() == 'Y':
        add_record()


def query_record(x, y):
    userActive = True

    while userActive:
        searchQuery = input('Enter the name of the title you want to search for: ')
        searchQuery = searchQuery.strip()
        searchSuccess = False

        for title in bookList:

            fieldX = (title[x])
            fieldY = (title[y])

            if fieldX == searchQuery:
                searchSuccess = True
                print('\nSuccess! Record Found')
                print((title[x]),'- With a current stock of', (title[y]))
                print(menuFormat)
                print('What adjustment do you wish to make to stock levels? ')

                userChoice = int(input('\nEnter 1 to Increase Stock, 2 to Decrease Stock: '))
                if userChoice == 1:
                    stockIncrease = int(input('Enter the value you wish to increase stock by: '))
                    newStock = int((title[y])) + stockIncrease
                    print('\nYou have entered:', stockIncrease, '\nThe stock of', (title[x]), 'is now:', newStock)
                    (title[y]) = newStock

                elif userChoice == 2:
                    stockDecrease = int(input('Enter the value you wish to decrease stock by: '))
                    newStock = int((title[y])) - stockDecrease
                    if newStock > 0:
                        print('You have entered:', stockDecrease, '\nThe stock of', (title[x]), 'is now:', newStock)
                        (title[y]) = newStock
                    elif newStock == 0:
                        print()
                        print(title[x], 'is unfortunately now out of stock!')
                        (title[y]) = newStock
                    elif newStock < 0:
                        print('\nError: A negative quantity has been entered for stock!')

                else:
                    print('Please enter a number between 1 and 2 to select a valid option')

            userActive = False
        if not searchSuccess:
            print('\nRecord Not Found!')


    print('\nContinue?')
    userSelect = int(input('1 - Search Again\n2 - Main Menu\nEnter Choice: '))

    if userSelect == 1:
        query_record(1, 5)
    elif userSelect == 2:
        main()
    else:
        print('Please Enter a Value of 1 or 2')


def display_menu():
    time.sleep(2.5)
    print('-_- '*25, '-', sep='')  # Use string repetition, easier to format than typing it in.print()
    print('1: View Summary Report for Total Number of Titles and Total Value of Books in Stock.               |')
    print('2: View Average Price of Books Currently in Stock.                                                 |')
    print('3: View Number of Books by Genre.                                                                  |')
    print('4: Add new Title to Inventory and View Updated Summary Report.                                     |')
    print('5: Check Book Stock Availability and Adjust Stock Level.                                           |')
    print('6: View Books Organised in Alphabetical Order by Title or by Genre.                                |')
    print('7: View Bar Chart for Books by Genre.                                                              |')
    print('8: Exit Program                                                                                    |')
    print('^-^ '*25, '\n')


def display_graph(x, y):

    # Plot a bar chart with the lists passed to the function
    plot.bar(x, y, color=('b', 'k', 'c', 'r'))

    # Add labels to the bar chart and the axes.
    plot.title('Books by Genre')
    plot.xlabel('Genre')
    plot.ylabel('Number of Books')

    # Display the bar chart.
    plot.show()


def main():

    while True:
        display_menu()
        userActive = False

        while not userActive:   # While loop will continue to display menu until userActive = false
            userChoice = input('Please enter the number for your choice: ')

            if userChoice == '1':
                print_summary()
                x, y = total_stock(4, 5)
                total_stock_print(x, y)
                userActive = True

            elif userChoice == '2':
                x, y = average_price(4, 5)
                average_print(x, y)
                userActive = True

            elif userChoice == '3':
                genre_tally_print()
                userActive = True

            elif userChoice == '4':
                add_record()
                userActive = True

            elif userChoice == '5':
                query_record(1, 5)
                userActive = True

            elif userChoice == '6':
                sorted_print_author()
                sorted_print_genre()
                #list_sorter_full_param(0, 1, 2, 3, 4, 5, 6)
                userActive = True

            elif userChoice == '7':
                x, y = genre_sort()
                display_graph(x, y)
                userActive = True

            elif userChoice == '8':
                userActive = True
                print('Thanks for using my terrible program. Have a good day ^-^')
                quit()

            else:
                print('Please enter a number between 1 and 7 to select an option. Alternatively, enter 8 to exit.')
                time.sleep(2)


read_file()
main()
