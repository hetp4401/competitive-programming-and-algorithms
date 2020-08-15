



k = int(input())
p = int(input())

s = {}

def piday(t, l, n):
    if n != 1:
        c = 0
        for i in range(min(t, l-n+1), (l//n)-1, -1):
            if (l-i)/(n-1) <= i and (l-i)/(n-1) >= 1:
                c += s[(i, l-i, n-1)] if (i, l-i, n-1) in s else piday(i, l-i,n-1)
        s[(t, l, n)] = c
        return c
    return 1

print(piday(k, k, p))


"""
You may know that March 14 is known as "π-day", since 3.14 (which is the third month and fourteenth day) is a good approximation of π.

Mathematicians celebrate this day by eating pie.

Suppose that you have n pieces of pie, and k people who are lined up for pieces of pie. All n pieces of pie will be given out. Each person will get at least one piece of pie, but mathematicians are a bit greedy at times. So, they always get at least as many of pieces of pie as the person in front of them.

For example, if you have 8 pieces of pie and 4 people in line, you could give out pieces of pie in the following five ways (with the first person in line being the first number in the list): [1, 1, 1, 5], [1, 1, 2, 4], [1, 1, 3, 3], [1, 2, 2, 3], [2, 2, 2, 2].

Notice that if k = n, there is only one way to give out the pieces of pie: every person gets exactly one piece. Also, if k = 1, there is only one way to give out the pieces of pie: that single person gets all the pieces.

Write a program that determines the number of ways that the pieces of pie can be given out.

Input
The first line of input is the integer number of pieces of pie, n (1 ≤ n ≤ 250).
The second line of input is the integer k which is the number of people in line (1 ≤ k ≤ n).

For at least 20% of the marks for this problem, n ≤ 9. For at least 50% of the marks for this problem, n ≤ 70. For at least 85% of the marks for this problem, n ≤ 120.

Output
The output will consist of a single integer which is the number of ways that pieces of pie can be distributed. The output is guaranteed to be less than 231.

Sample Input 1
8
4

Sample Output 1
5

Sample Input 2
6
2

Sample Output 2
3
"""