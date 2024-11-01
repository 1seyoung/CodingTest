def solution(array, commands): 
    answer = []
    
    for command in commands:
        
        i = command[0] -1
        j = command[1] 
        k = command[2] -1
        

        print(i,j,k)
        
        new_array = array[i:j]
        
        #print(new_array)
        new_array.sort()
        print(new_array)
        answer.append(new_array[k])
        
    return answer