from collections import deque


def solution(bridge_length, weight, truck_weights):
    time = 0
    bridge = deque([0] * bridge_length) # 다리의 각 위치를 0으로
    trucks = deque(truck_weights)
    current_weight = 0 # 현재 다리 위의 무게
    
    while trucks or current_weight > 0:  # 마지막 트럭이 지날 때까지
        time += 1
        current_weight -= bridge.popleft() # 다리를 빠져나가는 것 앞으로 땡기는 것을 시뮬레이션하는 것
        
        if trucks : # 대기 중인 트럭이 있나?
            if current_weight + trucks[0] <= weight : # 다음 트럭이 올라와도 괜찮으면?
                next_truck = trucks.popleft()
                bridge.append(next_truck) # 다리에 새 트럭 추가
                current_weight  += next_truck # 현재 무게 업데이트
            else : # 다음 트럭이 올라갈 수 없으면?
                bridge.append(0) # 빈 공간 업데이트
        else:
            bridge.append(0)
                
    
    return time