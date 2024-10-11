from itertools import combinations

def solution(friends, gifts):
    answer = 0
    
    # 선물 지수용
    friends_dict = {friend : {'given' : 0, 'received' : 0, 'index' : 0} for friend in friends}
    
    gift_dict = {}
    for a, b in combinations(friends, 2):
        gift_dict[(a, b)] = {'atob': 0, 'btoa': 0}
    
    # 선물 기록 저장 
    for gift in gifts:
    
        giver = gift.split(' ')[0]
        receiver = gift.split(' ')[1]
        
        # 친구 쌍 간의 선물 기록 업데이트
        if (giver, receiver) in gift_dict:
            gift_dict[(giver, receiver)]['atob'] += 1
        elif (receiver, giver) in gift_dict:
            gift_dict[(receiver, giver)]['btoa'] += 1
        
        # 준 사람 이름 매칭해서 given +1
        friends_dict[giver]['given'] += 1

        # 받은 사람 이름 매칭해서 received+1
        friends_dict[receiver]['received'] += 1


    # 선물 지수 업데이트
    for friend in friends:
        friends_dict[friend]['index'] = friends_dict[friend]['given'] - friends_dict[friend]['received']
        
        
    
    

    # 두 사람이 선물을 주고받은 기록이 있다면, 
    # 이번 달까지 두 사람 사이에 더 많은 선물을 준 사람이 다음 달에 선물을 하나 받는다
    # ex) A->B 5 B->A 4 : 다음 달 A -> B
    answer_dict = {friend: 0 for friend in friends}
    
    for a, b in combinations(friends, 2):
        if gift_dict[(a, b)]['atob'] > gift_dict[(a, b)]['btoa']:
            answer_dict[a] +=1
        elif gift_dict[(a, b)]['atob'] < gift_dict[(a, b)]['btoa']:
            answer_dict[b] +=1
        else:
                # 두 사람이 선물 주고 받은 기록이 없거나 같다면
                # 선물 지수가 더 큰 사람이 더 작은 사람에게 선물을 받는다
                if friends_dict[a]['index'] > friends_dict[b]['index']:
                    answer_dict[a] +=1
                elif friends_dict[a]['index'] < friends_dict[b]['index']:
                    answer_dict[b] +=1
                # 선물 지수 : (준 선물 수) - (받은 선물 수)
                # 선물 지수도 같다면 다음 달에 선물을 주고 받지 x
                
    
    answer = max(answer_dict.values())

    # 찾아야 하는 것 : 선물을 가장 많이 받을 친구가 받을 선물의 수
    
    
    
    
    return answer