# 큰 수의 법칙
# 동빈이의 큰 수의 법칙은 다양한 수로 이루어진 배열이 있을 때 주어진 수들을 m번 더하여 가장 큰 수를 만드는 법칙이다.
# 단 배열의 특정한 인덱스에 해당하는 수가 연속해서 k번을 초과하여 더해질 수 없는 것이 특징이다.
# # 예
# 2, 4, 5, 4, 6 m = 8 k =3
# 6 + 6 + 6 + 5 + 6 + 6 + 6 + 5
#a = [5, 8, 3]
#b = [2, 4, 5, 4, 6]

# 배열의 크기 N
# 숫자가 더해지는 횟수 M
# K 

n, m, k = map(int, input().split())

data = list(map(int, input().split()))
answer = 0

data.sort()
big = data[-1]
small = data[-2]

for i in range(m):
    if i <= k:
        answer += big
        print( i )
    else:
        k = 0
        answer += small
    
print(answer)


    
