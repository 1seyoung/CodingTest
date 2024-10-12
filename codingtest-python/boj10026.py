import sys
from collections import deque


#상하좌우 탐색
dx = [-1,1,0,0]
dy = [0,0,-1,1]

def bfs_R(x,y,N,board,visited):
    queue = deque()
    queue.append((x,y))
    visited[x][y] = True


    while queue:
        cur_x, cur_y = queue.popleft()
    
        for i in range(4):  
            nx = cur_x + dx[i]
            ny = cur_y + dy[i]

            if 0<=nx <N and 0<=ny <N and board[nx][ny] == "R" and not visited[nx][ny]:
                #범위에 벗어나지 않고 R이면 
                visited[nx][ny] = True
                queue.append((nx,ny))

def bfs_G(x,y,N,board,visited):
    queue = deque()
    queue.append((x,y))
    visited[x][y] = True


    while queue:
        cur_x, cur_y = queue.popleft()
    
        for i in range(4):  
            nx = cur_x + dx[i]
            ny = cur_y + dy[i]

            if 0<=nx <N and 0<=ny <N and board[nx][ny] == "G" and not visited[nx][ny]:
                #범위에 벗어나지 않고 R이면 
                visited[nx][ny] = True
                queue.append((nx,ny))



def bfs_B(x,y,N,board,visited):
    queue = deque()
    queue.append((x,y))
    visited[x][y] = True


    while queue:
        cur_x, cur_y = queue.popleft()
    
        for i in range(4):  
            nx = cur_x + dx[i]
            ny = cur_y + dy[i]

            if 0<=nx <N and 0<=ny <N and board[nx][ny] == "B" and not visited[nx][ny]:
                #범위에 벗어나지 않고 R이면 
                visited[nx][ny] = True
                queue.append((nx,ny))


def convert_for_color_blindness(board):
    return [['R' if cell == 'G' else cell for cell in row] for row in board]


def count_space_for_general(n,board):
    visitedR = [[False] * n  for _ in range(n)]
    visitedG = [[False] * n  for _ in range(n)]
    visitedB = [[False] * n  for _ in range(n)]
    count = 0

    for i in range(n):
        for j in range(n):
            if board[i][j] == "R" and not visitedR[i][j] :
                # 현재 위치가 R이고 아직 방문 하지 않았다면 탐색 시작
                bfs_R(i,j,n,board,visitedR)
                count +=1
            elif board[i][j] == "G" and not visitedG[i][j] :
                bfs_G(i,j,n,board,visitedG)
                count +=1
            elif board[i][j] == "B" and not visitedB[i][j] :
                bfs_B(i,j,n,board,visitedB)
                count +=1
    return count

                
    

# 1. 입력 받기
board = []
N = int(sys.stdin.readline())

board = [list(sys.stdin.readline().strip()) for _ in range(N)]

color_blind_board = convert_for_color_blindness(board)
color_blind_count = count_space_for_general(N,color_blind_board)

normal_count = count_space_for_general(N,board)
print(normal_count, color_blind_count)






