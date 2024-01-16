def solution(participant, completion):
    answer = ''
    
    participant.sort()
    completion.sort()
    
    #순서대로 탐색했을 때, 발견하면 그 이름 return
    for i in range(len(completion)):
        if completion[i] != participant[i]:
            # 동명이인 이슈로 불일치 하는 이름을 찾으면 바로 break
            answer += participant[i]
            break
    
    if answer == '':
        answer += participant[-1]
        
    return answer