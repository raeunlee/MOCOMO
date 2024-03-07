def solution(s, n):
    s = list(s)
    
    for i in range(len(s)):
        if s[i] == ' ' : 
            continue
        if s[i].isupper():
            tmp = ord('A')
        else:
            tmp = ord('a')
        s[i] = chr((ord(s[i]) - tmp + n) % 26 + tmp)
    
    return ''.join(s)