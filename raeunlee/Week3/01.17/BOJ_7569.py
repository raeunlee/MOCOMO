from collections import deque

# 가로, 세로, 높이
m, n, h = map(int, input().split())

tomato_3d = [[list(map(int,input().split())) for _ in range(n)]for _ in range(h)]

q = deque()

# 익은 토마토 찾기 
for i in range(h):
    for j in range(n):
        for k in range(m):
            if tomato_3d[i][j][k] == 1:
                q.append([i,j,k])

dx = [0,0,1,-1,0,0]
dy = [1,-1,0,0,0,0]
dz = [0,0,0,0,1,-1]

while q:
    z, y, x = q.popleft()
    for i in range(6):
        nx = x + dx[i]
        ny = y + dy[i]
        nz = z + dz[i]
        if 0<=nx<m and 0<=ny<n and 0<=nz<h:
            if tomato_3d[nz][ny][nx]==0:
                tomato_3d[nz][ny][nx] = tomato_3d[z][y][x]+1
                q.append([nz,ny,nx])

flag = False

for i in range(h):
    for j in range(n):
        for k in range(m):
            if tomato_3d[i][j][k] == 0: #안익은거 발견
                flag = True
                break
            
if flag: print(-1)
else: 
    max_value = 0
    for i in range(h):
        for j in range(n):
            for k in range(m):
                max_value = max(max_value, tomato_3d[i][j][k])
    print(max_value - 1)
                