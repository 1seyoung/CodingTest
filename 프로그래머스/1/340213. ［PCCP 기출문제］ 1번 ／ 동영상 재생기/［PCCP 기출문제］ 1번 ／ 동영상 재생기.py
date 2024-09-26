'''
command - prev : 10초 전 이동
command - next : 10초 후 이동
(auto) 오프닝 건너 뛰기 -> op_end +1 로 이동

vidieo_len : 동영상 길이
pos : 현재 위치
op_start , op_end : 오프닝 시작, 오프닝 끝
사용자 입력이 끝난무 동셩상 위치를 "mm:ss"형태로 return

(제한 조건)
0 ≤ mm ≤ 59
0 ≤ ss ≤ 59
분, 초가 한 자리일 경우 0을 붙여 두 자리로 나타냅니다.
비디오의 현재 위치 혹은 오프닝이 끝나는 시각이 동영상의 범위 밖인 경우는 주어지지 않습니다.

입출력 예시 시나리오

#1 : 시작위치 13:00 -> command 13:10
'''

from datetime import timedelta # 시간 계산용 

def check_op(pos, op_start, op_end):
    # (auto) 오프닝 자동 건너뛰기 부터
    if op_start <= pos <= op_end:
        
        return True
    return False
    
def convert_to_sec(timeStr):
    m, s = map(int, timeStr.split(':'))
    return m * 60 + s
    
def convert_to_time(timeSec):
    m = timeSec // 60
    s = timeSec % 60  
    return f"{m:02}:{s:02}"  
    

def solution(video_len, pos, op_start, op_end, commands):
    # 시간 변환 필요
    video_len = convert_to_sec(video_len)
    pos = convert_to_sec(pos)
    op_start = convert_to_sec(op_start)
    op_end = convert_to_sec(op_end)
    
    
    '''    
    for command in commands:
        if check_op(pos, op_start, op_end):
            pos = op_end
        
        
        if command == "prev" :
            if pos <10:
                pos = 0
            else:
                pos -= 10
        
        if command == "next":
            if video_len - pos <10 :
                pos = vidieo_len
            else :
                pos += 10
                
        if check_op(pos, op_start, op_end):
            pos = op_end
        '''
    for command in commands:
        if check_op(pos, op_start, op_end):
            pos = op_end
        
        
        if command == "prev" :
            pos = max(0,pos -10)
        
        if command == "next":
            pos = min(video_len, pos +10)
                
        if check_op(pos, op_start, op_end):
            pos = op_end

    
    answer = convert_to_time(pos)
    return answer


