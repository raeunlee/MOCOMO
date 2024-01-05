# 과거 아이디어만 참고,,

def solution(triangle):
    answer = 0
 
    for i in range(1, len(triangle)):
        for j in range(i+1):
            if j == 0: # 맨 왼쪽 수는 직전의 첫번째 수 더하기
                triangle[i][j] += triangle[i-1][j]
            elif j == len(triangle[i]) - 1: # 맨 오른쪽은 직전의 마지막 수 더하기
                triangle[i][j] += triangle[i-1][j-1]
            else: # 중간에 있는 숫자는 양쪽 대각선 중 더 큰 수를 더한다
                triangle[i][j] += max(triangle[i-1][j-1],triangle[i-1][j])
        

    answer = max(triangle[len(triangle)-1])
    return answer