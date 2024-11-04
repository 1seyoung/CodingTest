from itertools import permutations
import math

# 소수 판별
def is_prime(num):
    if num < 2:
        return False
    for i in range(2, int(math.sqrt(num)) + 1):
        if num % i == 0:
            return False
    return True

def solution(numbers):
    answer = 0
    number_set = set()
    
    numberList = list(numbers)
    
    for i in range(1, len(numbers) + 1):
        for temp in permutations(numberList, i):
            num = int(''.join(temp))
            number_set.add(num)
            
    
    for num in number_set:
        if is_prime(num):
            answer += 1
    
    return answer