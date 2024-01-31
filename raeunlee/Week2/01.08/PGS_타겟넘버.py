def solution(numbers, target):
    n = len(numbers)
    answer = 0
    
    #카운트 하나씩 해준다
    def dfs(cnt, result):
        if cnt == n: # 카운트가 n과 같?
            if result == target: # 결과값이 같?
                nonlocal answer 
                answer += 1 # answer +1
            return 
        else:  # 카운트가 n과 같지 않다면
            dfs(cnt+1, result+numbers[cnt])
            dfs(cnt+1, result-numbers[cnt])
    dfs(0,0)
    return answer