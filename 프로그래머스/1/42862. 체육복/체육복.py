def solution(n, lost, reserve):
    # 한 순간의 선택을 되돌리는 선택지는 없음
    # 매 순간마다 최적이라고 판단되는 선택을 하여 최종 해답을 도출
    
    
    lost.sort()
    reserve.sort()
    # n : 전체 학생의 수
    # lost : 잃어버린 학생 번호
    # reserve : 한 벌씩 더 가져온 학생 번호
    
    # 한벌씩 더 가져온 학생이 훔침을 당했는가 부터 체크
    
    new_lost = []
    new_reserve = []
    for i in lost:
        if i not in reserve : 
            new_lost.append(i)
    
    for i in reserve:
        if i not in lost:
            new_reserve.append(i)
            
    # reserve 에 있는 사람 앞뒤로 체크 
    
    for have in new_reserve : 
        if have -1 in new_lost : # 앞번호의 학생이 체육복이 없으면?
            new_lost.remove(have-1)  #빌려줘
        elif have + 1 in new_lost : # 앞번호의 학생이 체육복이 없지 않고, 뒷 번호애가 없으면?
            new_lost.remove(have + 1)
    
    
    
    answer = n - len(new_lost)
        
        
    

    return answer