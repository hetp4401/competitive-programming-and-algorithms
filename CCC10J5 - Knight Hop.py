start = input().split()
x, y = int(start[0]), int(start[1])

end = input().split()
xx, yy = int(end[0]), int(end[1])

move = [[1, 2], [1, -2], [-1, 2], [-1, -2], [2, 1], [-2, 1], [2, -1], [-2, -1]]
s = set()
s.add((x, y))

i = 0
current = [(x, y)]
while (xx, yy) not in s:
    temp = []
    for pos in current:
        for d in move:
            x = pos[0] + d[0]
            y = pos[1] + d[1]
            if (x, y) not in s and 1 <= x <= 8 and 1 <= y <= 8:
                temp.append((x, y))
                s.add((x, y))
    current = temp
    i += 1

print(i)


"""
Input
2 1
3 3

Output
1

Input
4 2
7 5

Output
2
"""