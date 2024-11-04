from itertools import product


def solution(word):
    
    answer = []
    
    stringList = [ 'A', 'E', 'I', 'O', 'U']
    
    for i in range(1, 6):
        for temp in product(stringList, repeat=i):
            string = ''.join(temp)
            answer.append(string)
    answer.sort()
    
    index = answer.index(word)
    return index + 1
