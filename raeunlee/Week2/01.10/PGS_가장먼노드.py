from collections import deque

def solution(n, edge):
    answer = 0
    
    graph = [[] for _ in range(n+1)]
    
    # 각 노드의 최단거리
    distance = [-1] * (n+1)
    
    for i in range(len(edge)):
        graph[edge[i][0]].append(edge[i][1])
        graph[edge[i][1]].append(edge[i][0])
    
    q = deque([1]) #출발지점
    distance[1] = 0 #출발노드 최단거리를 0으로 두기
    
    while q:
        now = q.popleft()
        # 현재 노드에서 이동할 수 있는 모든 노드 확인
        for i in graph[now]:
            if distance[i] == -1: # 방문하지 않은 노드는
                q.append(i) # 큐에 추가 
                distance[i] = distance[now] + 1 # 최단거리 갱신
    
    # 가장 멀리 떨어진 노드 개수 구하기
    for d in distance:
        if d == max(distance):
            answer += 1
        
    return answer