from collections import deque
    
# 세로, 가로, 음식물 쓰레기의 개수
n, m, k = map(int, input().split())

food = [[0] * m for _ in range(n)]

for i in range(k):
    a, b = map(int, input().split())
    food[a-1][b-1]= 1

visited =[[False] * m for _ in range(n)]

dx = [1,-1,0,0]
dy = [0,0,1,-1]

q = deque()

max_count = 0 

for i in range(n):
    for j in range(m):
        if food[i][j] == 1 and not visited[i][j]:
            q.append([i, j])
            visited[i][j] = True
            count = 1

            while q:
                y, x = q.popleft()
                for k in range(4):
                    nx = x + dx[k]
                    ny = y + dy[k]
                    if 0 <= nx < m and 0 <= ny < n and not visited[ny][nx] and food[ny][nx] == 1:
                        q.append([ny, nx])
                        visited[ny][nx] = True
                        count += 1

            max_count = max(max_count, count)

print(max_count)
