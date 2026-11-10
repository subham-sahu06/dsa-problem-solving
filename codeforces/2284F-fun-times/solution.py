import sys
from collections import deque
MOD = 10**9 + 7
INV2 = (MOD + 1) // 2
def solve(n, s):
    q = deque(0 if c == '1' else INV2 for c in s)
    free = s.count('0')
    v, prod = 0, 1
    for x in reversed(q):
        r = (1 - x) % MOD
        v = r * (1 + v) % MOD
        prod = prod * r % MOD
    total = 0
    for m in range(n, 1, -1):
        if m == 2:
            merged = q.popleft() * q.pop() % MOD
            q.append(merged)
            v = (1 - merged) % MOD
            prod = v
        else:
            z = q.pop()
            v = (v - prod) % MOD
            prod = prod * pow((1 - z) % MOD, MOD - 2, MOD) % MOD
            y = q.pop()
            v = (v - prod) % MOD
            prod = prod * pow((1 - y) % MOD, MOD - 2, MOD) % MOD
            a = q.popleft()
            ia = pow((1 - a) % MOD, MOD - 2, MOD)
            v = (v * ia - 1) % MOD
            prod = prod * ia % MOD
            merged = z * a % MOD
            r = (1 - merged) % MOD
            v = r * (1 + v) % MOD
            prod = prod * r % MOD
            q.appendleft(merged)
            ry = (1 - y) % MOD
            v = ry * (1 + v) % MOD
            prod = prod * ry % MOD
            q.appendleft(y)
        total = (total + v) % MOD
    return total * pow(2, free, MOD) % MOD
def main():
    data = sys.stdin.buffer.read().split()
    t = int(data[0])
    out = []
    idx = 1
    for _ in range(t):
        n = int(data[idx])
        s = data[idx + 1].decode()
        idx += 2
        out.append(solve(n, s))
    print("\n".join(map(str, out)))
main()
