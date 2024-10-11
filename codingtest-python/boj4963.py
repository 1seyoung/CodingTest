import sys
from collections import deque

# 상하좌우 이동  대각선도
dx = [-1, 1, 0, 0, -1, -1, 1, 1]
dy = [0, 0, -1, 1, -1, 1, -1, 1]

def bfs(x,y,w,h,island_map,visited):
    queue = deque()
    queue.append((x,y))
    visited[x][y] = True

    while queue:
        cur_x , cur_y = queue.popleft()

        #상하좌우 탐색하기
        for i in range(8):
            nx = cur_x + dx[i]
            ny = cur_y + dy[i]

            # 지도 범위에 있고 아직 방문하지 않았다면? 그리고 땅이어야해
            if 0 <= nx < h and 0 <=ny < w and not visited[nx][ny] and island_map[nx][ny] == 1:
                
                visited[nx][ny] = True
                queue.append((nx,ny))





def count_lands(w,h,island_map):
    # 방문 체크 필요함
    # 시작점은 0,0 이다 상하좌우를 검색한다 연결된 곳을 깊게 파고들다 상하좌우에 더 갈 곳이 없다면 섬 카운트 1
    
    visited = [[False] * w for _ in range(h)]

    island_count = 0

    for i in range(h):
        for j in range(w):
            if island_map[i][j] == 1 and not visited[i][j]:
                # 현재 위치가 섬이고 아직 방문 하지 않았다면 탐색 시작
                bfs(i,j,w,h,island_map, visited)
                island_count +=1

    return island_count


        
anwers = []
while True:
    # 1. 입력받기
    w, h = map(int, sys.stdin.readline().split())
    if w == 0 and h ==0:
        # 입력 종료 조건 -> (0,0)
        break
    # h 개의 줄 입력 받아 map 만들기
    island_map = []
    for _ in range(h):
        line = list(map(int, sys.stdin.readline().split()))
        island_map.append(line)
    # 2. 섬의 개수 탐색하기
    # 땅 1 , 바다 0


    anwers.append(count_lands(w,h, island_map))

for i in range(len(anwers)):
    print(anwers[i])
    




