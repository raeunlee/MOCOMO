def solution(places):
    answer = []    
    for room in places:
        # 응시자들 자리 구조
        valid = 1  # 일단은 모두가 가능
        for y in range(5):
            for x in range(5):
                if room[y][x] != 'P':
                    continue
                # 거리 1인 경우 체크
                if y < 4:  # 맨 아랫줄이 아닌 경우
                    if room[y + 1][x] == 'P':  # 바로 아래에 사람이 있는 경우
                        valid = 0
                        break   
                if x < 4:  # 맨 오른쪽 열이 아닌 경우
                    if room[y][x + 1] == 'P':  # 바로 오른쪽에 사람이 있는 경우
                        valid = 0
                        break 
                # 거리 2인 경우
                if y < 3:  # 세 번째 행 이전인 경우
                    if room[y + 2][x] == 'P' and room[y + 1][x] != 'X':  # 두 칸 아래에 사람이 있고 그 사이에 파티션이 없는 경우
                        valid = 0
                        break
                if x < 3:  # 네 번째 열 이전인 경우
                    if room[y][x + 2] == 'P' and room[y][x + 1] != 'X':  # 두 칸 오른쪽에 사람이 있고 그 사이에 파티션이 없는 경우
                        valid = 0
                        break
                if y < 4 and x < 4:  # 오른쪽 아래 대각선 검사
                    if room[y + 1][x + 1] == 'P' and (room[y + 1][x] != 'X' or room[y][x + 1] != 'X'):
                        valid = 0
                        break
                if y < 4 and x > 0:  # 왼쪽 아래 대각선 검사
                    if room[y + 1][x - 1] == 'P' and (room[y + 1][x] != 'X' or room[y][x - 1] != 'X'):
                        valid = 0
                        break
        
        answer.append(valid)
    
    return answer
