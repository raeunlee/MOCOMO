# 과거 코드 참조 - 순열, max
from itertools import permutations

def solution(k, dungeons):
    answer = -1
    
    for p in permutations(dungeons, len(dungeons)):
        tmp = k # 현재 체력
        count = 0
        
        for i in p:
            if tmp >= i[0]:
                tmp -= i[1]
                count += 1
                
        answer = max(answer, count) #기존의 값과 현재 카운트 중에 더 큰것을 지정
                

    return answer