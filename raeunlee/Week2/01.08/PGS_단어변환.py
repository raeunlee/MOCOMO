from collections import deque

def solution(begin, target, words):
    if target not in words:
        return 0
    
    q = deque()
    q.append([begin, 0])
    
    while q:
        b, cnt = q.popleft()
        if b == target:
            return cnt
        
        for i in range(0, len(words)):
            dif = 0
            word = words[i] #단어 하나씩
            
            for j in range(len(b)):
                if b[j] != word[j]:
                    dif += 1
                    
            if dif == 1:
                q.append([words[i], cnt+1])
                
    return cnt
