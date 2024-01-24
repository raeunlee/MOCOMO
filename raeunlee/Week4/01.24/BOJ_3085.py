#백준 사탕게임

def check():
    max_c = 0
    same_c = 1
    
    # 행 체크
    for x in range(N):
        same_c=1
        for y in range(N-1):
            if c[x][y]==c[x][y+1]:
                same_c+=1
            else:
                same_c=1
            # 최대 개수면 갱신
            if same_c > max_c:
                max_c=same_c

  # 열 체크
    for y in range(N):
        same_c=1
        for x in range(N-1):
            if c[x][y]==c[x+1][y]:
                same_c+=1
            else:
                same_c=1
            # 최대 개수면 갱신
            if same_c > max_c:
                max_c=same_c

    return max_c

N = int(input())
c = [list(map(str, input().rstrip())) for _ in range(N)]
result = 0

dx = [1,-1,0,0]
dy = [0,0,1,-1]

for x in range(N):
    for y in range(N):
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            # 배열 범위 체크
            if 0 <= nx < N and 0 <= ny < N:
                # 근처 사탕이 다른 색이면?
                if c[x][y] != c[nx][ny]:
                    #교체하고 사탕 개수 check후 갱신
                    c[nx][ny],c[x][y]=c[x][y],c[nx][ny]
                    result = max(result, check())
                    c[x][y], c[nx][ny] = c[nx][ny], c[x][y]
print(result)