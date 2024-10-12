import sys
from collections import deque
# 조건 1 > 버섯 자랄 수 있는 칸 : 0 없는칸 : 1
# 조건 2 > 혜경이는 버섯 포자를 심을 때 최소 개수로만 심으려한다 -> bfs
# 조건 3 > 농사가 가능할지 판단하고 남은 버섯 포자 개수 출력
# 조건 4 > 버섯 포자를 하나라도 사용하고 버섯이 자랄 수 있는 모든 칸에 버섯이 전부 자랐을 때 농사 가능하다고 정의

# 상하좌우 탐색
dx = [-1,1,0,0]
dy = [0,0,-1,1]

def dfs(x,y,n,board):
    queue = deque()
    queue.append((x,y))
    board[x][y] = 1
    count = 1 #네모 수 1로 시작


    while queue:
        cur_x, cur_y = queue.popleft()

        for i in range(4):
            nx = cur_x + dx[i]
            ny = cur_y + dy[i]

            if 0 <= nx <n and 0<= ny < n and board[nx][ny]==0:
                count +=1
                board[nx][ny] = 1
                queue.append((nx,ny))
    return count

def count_space(N,K,board):
    # 2. 버섯을 심을 수 있는 구역의 네모 수 체크
    mushroom = 0
    for i in range(N):
        for j in range(N):
            if board[i][j] == 0:
                # 2-1 버섯이 자랄 수 있는 칸이면 탐색을 시작
                nemo = dfs(i,j,N,board)
                mushroom += nemo//K
                if nemo %K !=0 :
                    # 네모 수가 k로 나누어 떨어지지 않으면 버섯 하나 더 필요함
                    mushroom +=1

    return mushroom
    

# 1. 입력 받기  N : 정사각형 한 변 길이 / M : 보유 버섯 포자 / K : 최대 연결 칸

N,M,K = map(int, sys.stdin.readline().split())

board = []
for _ in range(N):
    line = list(map(int,sys.stdin.readline().split() ))
    board.append(line)

use = count_space(N,K,board)

if use == 0:
    print('IMPOSSIBLE')
else:
    if use <= M:
        print('POSSIBLE')
        print(M - use)
    else:
        print('IMPOSSIBLE')





