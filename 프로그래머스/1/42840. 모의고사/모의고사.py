def solution(answers):
    answer = []
    
    N = len(answers)
    
    first_pattern = [1,2,3,4,5]
    second_pattern = [2,1,2,3,2,4,2,5]
    third_pattern = [3,3,1,1,2,2,4,4,5,5]
    
    first_count = 0
    second_count = 0
    third_count = 0
    
    for idx, num in enumerate(answers):
        #first
        check1 = idx % len(first_pattern)
        if num == first_pattern[check1]:
            first_count += 1
        #second
        check2 = idx % len(second_pattern)
        if num == second_pattern[check2]:
            second_count += 1
        
        #thrid
        check3 = idx % len(third_pattern)
        if num == third_pattern[check3]:
            third_count += 1
            
    count = [first_count, second_count, third_count]
    count_max = max(count)
    for idx, x in enumerate(count):
        if x == count_max :
            answer.append(idx+1)
        
    
    
    
    return answer