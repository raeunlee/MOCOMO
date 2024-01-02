#풀이시간: 5분, 검색안함

def solution(arr):
    answer = []    
    tmp = arr[0]
    answer.append(tmp)
    for i in range(1, len(arr)):
        if arr[i] == arr[i-1]:
            continue
        else:
            answer.append(arr[i])
    return answer