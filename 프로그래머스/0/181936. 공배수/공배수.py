def solution(number, n, m):
    answer = 0
    # number 가 n의 배수이면서 m의 배수이면 1
    
    if number % n ==0 | number % m ==0:
        answer =1
    # 아니면 0
    return answer