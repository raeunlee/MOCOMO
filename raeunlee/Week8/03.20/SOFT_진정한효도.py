import sys

input = sys.stdin.readline
arr = []

for i in range(3):
    arr.append(list(map(int, input().split())))

answer = 1e15
for i in range(3):
    if arr[i][0] == arr[i][1] == arr[i][2]:
        answer = min(answer, 0)
    elif arr[i][0] != arr[i][1] and arr[i][0] != arr[i][2] and arr[i][1] != arr[i][2]:
        answer = min(answer, 2)
    else:
        x_max = max(arr[i])
        x_min = min(arr[i])
        answer = min(answer, abs(x_max - x_min))

answer2 = 1e15
for i in range(3):
    if arr[0][i] == arr[1][i] == arr[2][i]:
        answer2 = min(answer2, 0)
    elif arr[0][i] != arr[1][i] and arr[0][i] != arr[2][i] and arr[1][i] != arr[2][i]:
        answer2 = min(answer2, 2)
    else:
        x_max = max(arr[0][i], arr[1][i], arr[2][i])
        x_min = min(arr[0][i], arr[1][i], arr[2][i])
        answer2 = min(answer2, abs(x_max - x_min))

print(min(answer, answer2))


