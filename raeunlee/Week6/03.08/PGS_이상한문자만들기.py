def solution(s):
    answer = ''
    s = list(s)
    
    cnt = 0
    for i in range(len(s)):
        if s[i] == ' ':
            cnt = 0 
            continue
        if cnt%2 == 0:
            s[i] = s[i].upper()
            cnt += 1
        else:
            s[i] = s[i].lower()
            cnt += 1
            
    return ''.join(s)