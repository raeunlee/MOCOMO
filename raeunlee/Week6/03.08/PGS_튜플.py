def solution(s):
    d = {}
    
    s = sorted(s[2:-2].split("},{"), key=len)
    
    for item in s:
        tmp = item.split(',')
        for x in tmp:
            num = int(x)
            if num in d:
                d[num] += 1
            else:
                d[num] = 1
  
    return(list(d))
