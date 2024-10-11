# 백준 실버2 : 폴짝폴짝

# 문제 정보 : a 번째 징검다리에서 b 번째 징검다리 가지 갈때 최소한의 점프
# 조건 ; 징검다리에 쓰여있는 수의 배수만큼 떨어져있는 곳으로만 갈 수 있음

# 입력받기
import sys
from collections import deque
# 최소한-> 최단거리 -> bfs -> queue -> deque 라이브러리
def dfs_min(bridge, N, a,b):
    # 큐 초기화 : 위치, 점프 횟수
    # deque 는 양쪽에서 추가/삭제가 가능한 자료구조
    # 왜 a-1 인가 -> a 가 자연수라 1부터라 하나씩 빼야함

    # 큐에서는 재귀아녀 -> while 에서 해결

    queue = deque([(a-1,0)])

    # 방문 여부를 추적하는 리스트
    # [False] N 개로 이루어진 리스트
    visited = [False] * N
    visited[a-1] = True # 시작 위치를 방문한 것으로 표시

    while(queue): # 큐가 비어있지 않는 동안 반복

        # 큐에서 현재 위치와 점프 횟수를 가져옴
        # popleft() 는 큐의 앞쪽에서 원소를 제거하고 반화

        # 반환하고 제거하는 이유 -> 해당 징겅다리에 대해 돌린거니깐

        current, jumps = queue.popleft()

        if current == b-1: # 목표 지점에 도달했는지 확인
            return jumps # 현재까지의 점프 횟수 반환
        bridge_value = bridge[current] # 현재 징검다리의 값

        # 오른쪽으로 점프
        # range(시작값, 종료값, 스텝 크기)
        # currnet 는 현재 개구리 위치 + bridge_value 징검다리 숫자(현재)
        # current + bridge_value = 개구리가 오른쪽으로 첫 번째로 점프할 수 있는 위치
        # N 징검 다리의 총 개수
        
        # 오른쪽으로 점프
        # range(시작, 끝, 간격)으로 가능한 모든 오른쪽 점프 위치를 생성
        for i in range(current + stone_value, N, stone_value):
            if not visited[i]:  # 아직 방문하지 않은 위치라면
                visited[i] = True  # 방문 표시
                queue.append((i, jumps + 1))  # 새 위치와 증가된 점프 횟수를 큐에 추가
        
        # 왼쪽으로 점프 (오른쪽 점프와 유사한 로직)
        for i in range(current - stone_value, -1, -stone_value):
            if not visited[i]:
                visited[i] = True
                queue.append((i, jumps + 1))



    return -1  # 목표 지점에 도달할 수 없는 경우

N  = map(int, sys.stdin.readline())
bridge = list(map(int, sys.stdin.readline().split()))
a,b = map(int, sys.stdin.readline().split())

dfs_min(bridge,N, a,b)