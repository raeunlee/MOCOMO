import heapq

def solution(scoville, K):
    answer = 0
    heap = []

    for s in scoville:
        heapq.heappush(heap, s)
        
    
    while len(heap) > 1:
        x = heapq.heappop(heap)
        if x >= K: #x가 K보다 크면 반복문 탈출
            break

        y = heapq.heappop(heap)
        tmp = x + (y * 2)
        heapq.heappush(heap, tmp)
        answer += 1

    return answer if heap and heap[0] >= K else -1