def solution(clothes):   
    # 옷장 딕셔너리
    closet = {} 
    
    # 종류를 key로 둔다
    for name, kind in clothes:
        if kind in closet.keys():
            closet[kind] += [name]
        else:
            closet[kind] = [name]

    answer = 1
    # A만 사용, B만 사용, AB 사용, 1 모두 안사용 -> (A+1)(B+1) = AB + A + B + 1
    # 종류, 의상
    for k , value in closet.items():
        answer *= (len(value) + 1)
    
    return answer - 1 # 아무것도 입지 않은 경우 1 제외

