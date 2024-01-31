# 정말 이 문제가 왜이리 어려울까

from collections import deque

def solution(priorities, location):
    answer = 1  
    q = deque(priorities)
    idx = location
    
    while q:
        now = q.popleft() # 현재 프로세스
        
        if now < max(q):
            q.append(now)
            if idx == 0:
                idx = len(q) - 1
            else:
                idx -= 1
        else:
            if idx == 0:
                return answer
            else:
                answer += 1
                idx -= 1

    return answer