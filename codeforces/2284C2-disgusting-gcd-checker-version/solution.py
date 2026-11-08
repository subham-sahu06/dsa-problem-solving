import sys
from math import gcd
from collections import deque


def solve(a, b):
    if a == b:
        return []
    if gcd(a, b) == 1:
        return [b - a]

    for c in range(a + 1, b):
        if gcd(c, a) == 1 and gcd(c, b) == 1:
            return [c - a, b - c]

    length = b - a
    dist = [-1] * (length + 1)
    par = [0] * (length + 1)
    dist[0] = 0
    queue = deque([0])
    while queue:
        u = queue.popleft()
        for v in range(u + 1, length + 1):
            if dist[v] == -1 and gcd(a + u, a + v) == 1:
                dist[v] = dist[u] + 1
                par[v] = u
                queue.append(v)

    steps = []
    cur = length
    while cur != 0:
        steps.append(cur - par[cur])
        cur = par[cur]
    return steps[::-1]


def main():
    data = sys.stdin.read().split()
    t = int(data[0])
    out = []
    cache = {}
    for i in range(t):
        a, b = int(data[1 + 2 * i]), int(data[2 + 2 * i])
        if (a, b) not in cache:
            cache[(a, b)] = solve(a, b)
        steps = cache[(a, b)]
        out.append(str(len(steps)))
        if steps:
            out.append(" ".join(map(str, steps)))
    print("\n".join(out))


main()
