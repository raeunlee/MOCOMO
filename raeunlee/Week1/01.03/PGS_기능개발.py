# 오래걸림 + 검색했음 맨 마지막 count를 따로 append 해주는 게 제일 어려웠음
def solution(progresses, speeds):
    answer = []
    count = 0 
    
    while progresses: # 작업이 남아 있을 때
        if progresses[0] + speeds[0] >= 100: # 하나 개발 완료
            progresses.pop(0)
            speeds.pop(0)
            count += 1 # 배포하는 카운트
            
        else: # 개발 다 안됐을 경우
            if count > 0: #count가 0이 넘으면
                answer.append(count) 
                count = 0
            for i in range(len(progresses)):
                progresses[i] += speeds[i]

    # 맨 마지막꺼는 따로 카운트를 append해줌
    answer.append(count)
    return answer