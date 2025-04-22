def solution(name):
    
    n = len(name)
    count = 0
    
    # 위 아래 최소 횟수
    for i in range(n):
        # 현재 위치에서 목표 문자로의 조작 위 아래 중 하나 골라야함
        up_down = min(ord(name[i])  - ord('A'), ord('Z') - ord(name[i]) + 1)
        count += up_down
    # 좌우 이동 최적화
    min_move = n -1
    
    for i in range(n):
        next_pos = i + 1
        # i 이후에 A가 아닌 첫번째 위치를 찾아야함
        while next_pos < n and name[next_pos] == 'A' : 
            next_pos +=1
        min_move = min(min_move, 2 * i + n - next_pos, 2 * (n - next_pos) + i)
        # 2번째 : 왼쪽에서 돌아서 오른쪽으로 돌아오는 경우
            
        # 3번째 : 끝까지 갔다가 다시 돌아오는 경로
    count += min_move
    # 체크할꺼
    return count