from collections import deque

m, n = map(int, input().split())
tomato = []

#토마토 지도
for i in range(n):
    tomato.append(list(map(int, input().split())))

q = deque()
# 익은 토마토 찾기
for i in range(n):
    for j in range(m):
        if tomato[i][j] == 1:
            q.append((i,j))

# 8 방향
dx = [-1,0,1,0]
dy = [0,-1,0,1]

while q:
    x, y = q.popleft() 
    for i in range(4):
        nx = x + dx[i] 
        ny = y + dy[i]
        # 범위를 벗어나지 않고, 0이라면 1이 된다
        if 0 <= nx < n and 0 <= ny < m and tomato[nx][ny] == 0:
            tomato[nx][ny] = tomato[x][y] + 1
            q.append([nx, ny])

flag = False
for line in tomato:
    for each in line:
        if each == 0: # 안익은 토마토 발견
            flag = True
            break

if flag: print(-1)
else: print(max(map(max,tomato))-1)