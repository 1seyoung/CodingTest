def solution(n):
    answer = 0
    
    # N이 홀수라면 N 이하의 홀수인 양의 정수 return
    if (n%2 ==1) :
        for i in range(1,n,2):
            answer +=i
        answer +=n
    # n이 짝수라면 N 이하의 짝수인 양의 정수 Return
    if (n%2 ==0) :
        for i in range(2,n,2):
            answer +=i*i
        answer +=n*n
    return answer