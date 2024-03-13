# def solution(n):
#     answer = ''
    
#     while n > 0:
#         answer += str(n % 3)
#         n = n // 3
    
    
    
#     return int(answer,3)
def solution(n):
    answer = 0
    arr = []
    while True: 
        if n == 0:
            break
        arr.append(n%3)
        n = n// 3
    arr.reverse()
    for i in range(len(arr)):
        answer += arr[i]*(3**i)
    return answer