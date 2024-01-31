# 제일 헷갈리는 게 바로 행과 열,,

from collections import deque

def solution(maps):
    r = len(maps)
    c = len(maps[0])
    
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]
    
    q = deque([(0, 0)])
    
    # 1로만 다닐 수 있음
    while q:
        x, y = q.popleft()
        
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            
            # 다음 좌표가 1이고, 범위를 넘지 않는다면? 
            if 0 <= nx < r and 0 <= ny < c and maps[nx][ny] == 1:
                maps[nx][ny] = maps[x][y] + 1
                q.append((nx, ny))
    
    if maps[r-1][c-1] == 1:
        return -1
    else:
        return maps[r-1][c-1]
