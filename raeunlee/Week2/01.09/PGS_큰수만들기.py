def solution(number, k):
    stack = [number[0]] # 맨 처음 숫자 넣어줌 
    for num in number[1:]: # 첫번째 숫자 이후로 탐색
        # 스택 길이가 0보다 크고, 가장 위의 스택이 num보다 작고, k가 0보다 크면?
        while len(stack) > 0 and stack[-1] < num and k > 0:
            k -= 1
            stack.pop()
            # 팝팝팝
        # 아닌 경우는 스택을 append
        stack.append(num)
    if k != 0: #k가 0이아니면, 위에서부터 출력
        stack = stack[:-k]
    return ''.join(stack)