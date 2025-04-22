def solution(brown, yellow):
    answer = []

    total = brown + yellow
    
    for h in range(3, int(total ** 0.5) + 1) :    # 제곱근을 구하고 싶으면 1/2 승 -> ** 0.5
        if total % h == 0 :
            w = total // h 
            if 2 * (w +h) -4 == brown :
                return [w, h]
