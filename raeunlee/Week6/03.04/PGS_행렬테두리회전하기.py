def rotate(x1,y1,x2,y2,graph):
    first = graph[x1][y1] #가장 작은 값
    min_value = first   
    #왼쪽 ㅣ 모양
    for k in range(x1,x2):
        graph[k][y1] = graph[k+1][y1]
        min_value = min(min_value, graph[k+1][y1])
    #아래 ㅡ 모양
    for k in range(y1, y2):
        graph[x2][k] = graph[x2][k+1]
        min_value = min(min_value, graph[x2][k+1])
    #오른쪽 ㅣ 모양
    for k in range(x2, x1, -1):
        graph[k][y2] = graph[k-1][y2]
        min_value = min(min_value, graph[k-1][y2])
    #위 ㅡ 모양
    for k in range(y2, y1+1, -1):
        graph[x1][k] = graph[x1][k-1]
        min_value = min(min_value, graph[x1][k-1])
    graph[x1][y1+1] = first
    return min_value
        
def solution(rows, columns, queries):
    answer = []
    graph = [[(i) * columns + (j+1) for j in range(columns)] for i in range(rows)]
            
    for x1, y1, x2, y2 in queries:
        answer.append(rotate(x1-1,y1-1,x2-1,y2-1,graph))
    return answer