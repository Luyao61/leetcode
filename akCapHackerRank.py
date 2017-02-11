#Akuna captial code challenge
'''
word parsing
count the number of each word, and the number of each alphabet
note: input from STDIN, so may contain \n, remove \n first
'''
str = input("")
print(str)
str = str.lower()
#str = "aserh!sdfkj askh 2 sdhj123sd"
print(str)
str = str.split()

word_dict = {}
char_dict = {}

for i in range(97, 97+26):
    char_dict[chr(i)] = 0

for word in str:
    if(all(c.islower() for c in word)):
        if word not in word_dict:
            word_dict[word] = 1
        else:
            word_dict[word] += 1
        for c in word:
            char_dict[c] += 1

print(sum(word_dict.values()))
print("words")
for word in sorted(word_dict.keys()):
    print ("%s %d" % (word, word_dict[word]))
print("letters")
for c in sorted(char_dict.keys()):
    print ("%s %d" % (c, char_dict[c]))

#############
'''
rotate matrix
'''
matrix = [[1,0,0,0],[0,1,0,0],[0,0,1,0],[0,0,0,1]]
result = []
for i in range(len(matrix[0])):
    line = []
    for j in range(len(matrix)):
        line.append(0)
    result.append(line)
for i in range(len(matrix)):
    for j in range(len(matrix[0])):
        result[len(matrix[0])-1-j][i] = matrix[i][j]
print(result)
####################
'''
In a descending sorted array, find the median of sub array that greater than K
'''
array = [10,10,9,8,8,8,6,5,4,3,2,1]
target = 8

first = 0
last = len(array)-1

while first<=last :
    midpoint = (first + last)//2
    if array[midpoint] == target:
        if midpoint == 0 or array[midpoint+1] != array[midpoint]:
            break;
        else:
            first = midpoint+1
    elif array[midpoint] > target:
        first = midpoint+1
    else:
        last = midpoint-1
print(midpoint)

last = midpoint
first = 0
if((last - first) % 2 == 0):
    midpoint = (first + last)//2
    print(array[midpoint])
else:
    midpoint = (first + last)//2
    print((array[midpoint] + array[midpoint+1])/2.0)

###################
'''
order book class
print transcation, and return current max price.
'''
class OrderBook:
    dict = {}
    def __init__(self):
        self.dict = {}


    def buy(self, id, price):
        self.dict[id] = price

    def sell(self, id):
        if id in self.dict:
            del self.dict[id]

    def get_high_price(self):
        if len(self.dict) == 0:
            return -1;
        else:
            return max(self.dict.values())


    #def __del__(self):

A = OrderBook()
A.buy(1,10)
print (A.get_high_price())
A.buy(2,8)
print (A.get_high_price())
A.buy(3,12)
print (A.get_high_price())
A.buy(4,15)
print (A.get_high_price())
A.buy(5,7)
print (A.get_high_price())
A.sell(1)
print (A.get_high_price())
A.sell(3)
print (A.get_high_price())
A.sell(4)
print (A.get_high_price())
A.sell(5)
print (A.get_high_price())
A.sell(2)
print (A.get_high_price())
