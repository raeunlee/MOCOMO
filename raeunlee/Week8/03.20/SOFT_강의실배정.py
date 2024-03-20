import sys

n = int(input())
s = []
for i in range(n):
    a, b = map(int, input().split())
    s.append([a,b])
s.sort(key = lambda x : (x[1]))
#print(s)

count = 0 
end = 0
for i in range(n):
    if s[i][0] >= end:
        count += 1
        end = s[i][1]
print(count)