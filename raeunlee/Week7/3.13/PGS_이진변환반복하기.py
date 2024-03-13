def solution(s):
    answer = []
    
    # 이진 변환 회차, 제거할 0의 개수
    count = 0
    zero_count = 0
    now = s
    while now != '1':
        count += 1
        tmp_count = 0
        for i in range(len(now)):
            if now[i] == '0':
                tmp_count += 1       
        zero_count += tmp_count
        # 0 제거 후 길이
        tmp = len(now) - tmp_count 
        now = format(tmp, 'b')
    
    answer = [count, zero_count]
    return answer





   