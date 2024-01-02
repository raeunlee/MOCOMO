# 에라토스테네스의 체, 순열 사용법, set을 활용한 중복제거 등 검색함.. 1시간 소요

import itertools
import math 

def is_prime(num):
    if num < 2:
        return False
    for i in range(2, int(math.sqrt(num)) + 1):
        if num % i == 0:
            return False
    return True

def solution(numbers):
    answer = 0
    tmp = set()  # 중복 제거를 위해 set 사용
    
    # 자릿수별 순열 구해주기
    for i in range(1, len(numbers) + 1):       
        nPr = itertools.permutations(numbers, i)
        for p in nPr:
            tmp.add(int(''.join(p)))  # 중복 제거 후 set에 추가
    
    tmp = list(tmp)
    print(tmp)

    # 소수인지 아닌지 판별하기 
    for t in tmp:
        t = int(t)
        if is_prime(t):
            answer += 1
            print(t)
    return answer
