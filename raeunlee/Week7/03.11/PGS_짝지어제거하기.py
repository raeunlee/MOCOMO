from collections import deque

def solution(s):

    q = deque()
    q.append(s[0])
    for i in range(1, len(s)):
        if q and s[i] == q[-1]:
            q.pop()
        else:
            q.append(s[i])
    
    if len(q) == 0:
        return 1
    else:
        return 0