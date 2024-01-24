def solution(answers):
    answer = []    
    no1 = [1,2,3,4,5]
    no2 = [2,1,2,3,2,4,2,5]
    no3 = [3,3,1,1,2,2,4,4,5,5]  
    scores = [0, 0, 0]

    for i in range(len(answers)):
        if no1[i % 5] == answers[i]:
            scores[0] += 1
        if no2[i % 8] == answers[i]:
            scores[1] += 1
        if no3[i % 10] == answers[i]:
            scores[2] += 1

    max_score = max(scores)

    for idx, s in enumerate(scores):
        if s == max_score:
            answer.append(idx+1)
            
    return answer