



n = int(input())

points = [tuple(map(int, input().split())) for i in range(n)]
points.sort()

cross = lambda o, a, b: (a[0] - o[0]) * (b[1] - o[1]) - (a[1] - o[1]) * (b[0] - o[0]) <= 0

lower = []
for p in points:
    while len(lower) >= 2 and cross(lower[-2], lower[-1], p):
        lower.pop()
    lower.append(p)

upper = []
for p in reversed(points):
    while len(upper) >= 2 and cross(upper[-2], upper[-1], p):
        upper.pop()
    upper.append(p)

cHull = set(lower + upper)
print(cHull)


"""
Print convechull of a set of points

Sample Input
10
10 6
4 1
4 8
9 5
7 7
10 2
3 10
1 6
0 6
7 6

Sample Output
(3, 10), (10, 6), (0, 6), (4, 1), (10, 2)
"""