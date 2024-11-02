from collections import deque
def solution(progresses, speeds):
    # 각 기능 완성도 progresses
    # 하루 작업 가능량 speeds ex 하루에 1프로씩 작업 가능
    
    # 먼저 있는게 먼저 나간다 -> 큐
    
    N = len(progresses)
    answer = []
    
    progress_queue = deque(progresses)
    speed_queue = deque(speeds)
    
    while progress_queue:
        # 하루 작업 진행
        for i in range(len(progress_queue)):
            progress_queue[i] +=speed_queue[i]
            
        # 배포 가능한 기능 확인
        deploy_count = 0
        while progress_queue and progress_queue[0] >=100:
            progress_queue.popleft()
            speed_queue.popleft()
            deploy_count +=1
            
        # 배포된 기능이 있다면 answer에 추가
        if deploy_count >0 :
            answer.append(deploy_count)
    
    
    
    
    return answer