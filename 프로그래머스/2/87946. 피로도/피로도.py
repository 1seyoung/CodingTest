from itertools import permutations

def solution(k, dungeons):
    max_count = 0
    
    # k : 유저의 현재 피로도
    # dungeons : [ [1던전 최소 필요 피로도 ,1던전 소모 피로도], , ] > [[80,20],[50,40],[30,10]]	
    
    # 피로도 시스템 : 현재 피로도 - 소모 피로도(입장조건 : 최소 필요도)
    # 백트랙킹 : 모든 가능한 경우를 탐색하면서 조건에 맞지 않는 겨 ㅇ우는 빠르게 포기하고 되돌아가 다른 경우를 탐색하는 방식 보통 재귀?
    
    # 던전의 모든 조합 -> 순열 -> permutations
    for order in permutations(dungeons):
        current_stamina = k
        count = 0
        
        # 각 던전에 대해 대해 최소 필요 피로도를 확인하고 탐험 가능 여부 확인해보기\
        for entry, consume in order:
            if current_stamina  >= entry :
                current_stamina -= consume
                count +=1
            else:
                break 
        
        max_count = max(max_count , count)
    
    
    return max_count