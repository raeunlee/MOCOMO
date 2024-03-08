def solution(n):
    answer = []
    tri = []
    
    # 임시 삼각형
    for i in range(1,n+1):
        row = []
        for j in range(1,i+1):
            row.append(0)
        tri.append(row)   
    
    y, x = -1 , 0
    num = 1
    for i in range(n):
        for j in range(i,n):
            angle = i % 3
            if angle == 0: y += 1
            elif angle == 1 : x += 1
            elif angle == 2 : 
                y -= 1  
                x -= 1
            tri[y][x] = num
            num += 1
    
    for i in tri:
        for j in i:
            answer.append(j)
    return answer
    
