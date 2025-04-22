from collections import defaultdict, deque

def bfs(start, visited, graph):
    
    queue = deque([start])
    visited[start] = True
    count = 1
    
    while queue :
        node = queue.popleft()
        for neighbor in graph[node]:
            if not visited[neighbor] :
                visited[neighbor] = True 
                queue.append(neighbor)
                count += 1
    return count

def solution(n, wires):
    # 그래프를 생성하는 것 부터 외우기
    
    graph = defaultdict(list) # defaltdict?
    for v1, v2 in wires:
        graph[v1].append(v2)
        graph[v2].append(v1)
        
    # 결과 -> 1: [2,3] , 2: [1,4], 3 : [1] ... 이런 느낌
        
    # 송전탑의 갯수를 알아야함 -> 찾는 것 BFS
    
    min_difference = float('inf') # Max 구할때는 0으로 해둔것과 반대 inf 기억하기
    
    # 간선 하나씩 지워보면서 최소 차이 계산
    for v1, v2 in wires :
        # 지워봐유
        graph[v1].remove(v2)
        graph[v2].remove(v1)
        
        # 두 트리 노드 숫자 차이 계산
        visited = [False] * (n + 1)
        count1 = bfs(v1, visited, graph)
        
        min_difference = min( abs(n- (2 *count1)), min_difference)
        
        # 다시 복구해
        graph[v1].append(v2)
        graph[v2].append(v1)
        
    return min_difference
        
        
        
        # 

    
    
    return answer