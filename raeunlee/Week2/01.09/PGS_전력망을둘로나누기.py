from collections import deque

def bfs(start, visited, graph ):
    q = deque([start])
    cnt = 1
    visited[start] = True
    while q:
        x = q.popleft() # 현재 지점
        for i in graph[x]: # graph[x] 안의 요소들
            if visited[i] == False: # 방문하지 않은 수라면 
                cnt += 1 # 카운드 세준다 
                q.append(i)
                visited[i] = True
    return cnt # cnt return 
    

def solution(n, wires):
    answer = n
    graph = [[] for _ in range(n+1)]  
    
    # 그래프 만들어 주기
    for a, b in wires:
        graph[a].append(b)
        graph[b].append(a)
    
    # 각 전선의 시작점과 끝점 
    for start, end in wires:
        visited = [False] * (n+1) 
        visited[end] = True # 하나씩 끊겼다고 가정한다
        result = bfs(start, visited, graph)
        # 전체노드에서 방문한 노드의 개수를 뺀 값과 방문한 노드의 개수 차이의 절댓값을 구함
        # 최솟값 갱신
        answer = min(answer, abs(result - (n - result)))
            
    return answer