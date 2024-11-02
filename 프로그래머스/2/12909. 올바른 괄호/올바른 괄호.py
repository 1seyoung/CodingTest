from collections import deque
def solution(s):
    answer = True
    
    temp_queue = deque()
    string_queue = deque(s)
    
    
    while string_queue :
        
        top = string_queue.popleft()
        
        if top == ")":
            if not temp_queue:  # 스택이 비어있는데 닫는 괄호가 나온 경우
                return False
            temp_queue.popleft()  # 여는 괄호 제거
        elif top == "(":
            temp_queue.append(top)  # 여는 괄호 추가
    
    if temp_queue:
        answer = False
            
    
    
    return answer