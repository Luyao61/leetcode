
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
for c in sorted(char_dict.keys()):
    print ("%s %d" % (c, char_dict[c]))



'''
word_start = 0
word_end = 0
while word_start < len(str):
    print (str[i])
    while(word_start < word_end || n < len(str) && n == ' ') n++;
    while(word_end < word_start || m < len(str) && m != ' ') m++;
'''

#for char in str:
#    print (word)
