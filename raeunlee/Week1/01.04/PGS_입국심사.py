def solution(n, times):
    answer = 0
    times.sort()
    start = times[0]
    end = times[-1] * n
    while start <= end:
        people = 0 # 입국 심사 완료된 사람 수
        mid = (start + end) // 2 # 중앙값
        for time in times:
            # 중앙값 동안 입국 심사가 가능한 사람 수
            people += mid//time
        # n 이상 심사할 경우 일단 answer 에 저장하고 최소 mid를 찾기
        if people >= n:
            answer = mid
            end = mid - 1
        #n보다 적게 심사, mid로는 부족
        else:
            start = mid + 1
    return answer