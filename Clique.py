

nodes, links = map(int, input().split())

n = {}
for i in range(links):
    a, b = map(int, input().split())
    n[a] = n.get(a, set()) | set([b])
    n[b] = n.get(b, set()) | set([a])

def clique(c, v, g):
    if len(v) == 0 and len(g) == 0:
        return len(c) if len(c) > 0 else 1
    else:
        u = sorted(list(v | g), key=lambda x: len(n[x]))[0]
        m = 0
        for node in g - n[u]:
            m = max(clique(c | set([node]), v & n[node], g & n[node]), m)
            g = g - set([node])
            v = v | set([node])
        return m

print(clique(set(), set(), set(list(n.keys()))))



"""
A bunch of people on Facebook would like to find out the largest clique among them.
(Maybe this will be the next facebook application?)

A clique is defined as a group of people where everyone is friends with everyone else.
Given a list of friends (friendship works both ways), your job is to output the size of this clique.
For the sake of privacy (and your convenience), we have replaced the names of the people with numbers.
Input
Number of people, 1 ≤ N ≤ 32
Number of friendships, 1 ≤ M ≤ N*(N-1)/2
M lines, each with 2 numbers 1 ≤ a, b ≤ N meaning that a and b are friends.
There will be no duplicate edges.

NOTE: 50% of test cases will have N ≤ 24.
Output
The size of the maximum clique.
Sample Input
6 7
2 3
2 4
2 5
3 4
3 5
4 5
5 6
Sample Output
4

Friends 2,3,4,5 form the largest clique.
"""