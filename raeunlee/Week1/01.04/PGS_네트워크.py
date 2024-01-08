# dfs는 오랜만이라,,, 재귀 사용법은 검색해봤음!
def dfs(n, computers, visited):
    visited[n] = True #현재 컴퓨터 방문처리
    tmp = len(computers)
    #현재 컴퓨터랑 연결된 컴퓨터들을 탐색
    for i in range(tmp):
        if computers[n][i] == 1 and not visited[i]: #방문하지 않고, 연결되어 있다면?
            dfs(i, computers, visited) #다시 반복한다

def solution(n, computers):
    answer = 0
    visited = [False for _ in range(n)] # 방문 체크 배열
    for i in range(n): #네트워크 하나씩 탐색 
        if not visited[i]: #해당 네트워크를 방문한적이 없다면
            dfs(i, computers, visited) # 재귀시작
            answer += 1 # 끝날때마다 +1을 해준다 
    return answer