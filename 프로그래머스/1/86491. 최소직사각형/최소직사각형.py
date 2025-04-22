def solution(sizes):
    # 지갑을 만들어 모든 명함 들어가는
    
    # 모든 명함을 넣을 수 있는 가장 작은 지갑
    
    # 들어온 가로 중에 가장 큰것 세로중에 가장 큰것 고르기
    max_width = 0
    max_height = 0
    for temp in sizes:
        temp.sort()
        max_width = max(max_width, temp[0])
        max_height = max(max_height, temp[1])
    
    #출력값은 명함의 크기 (가로 x 세로)
    answer = max_width * max_height
    return answer