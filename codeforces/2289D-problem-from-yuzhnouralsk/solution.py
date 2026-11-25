import sys
from bisect import bisect_right
def main():
    d = sys.stdin.buffer.read().split()
    t = int(d[0]); pos = 1
    out = []
    for _ in range(t):
        n = int(d[pos]); pos += 1
        p = []
        s = 0
        bad = False
        for i in range(n):
            s += int(d[pos + i])
            p.append(s)
            if s < 0:
                bad = True
        pos += n
        if bad:
            out.append(-1)
            continue
        vals = sorted(set(p))
        m = len(vals)
        tree = [0] * (m + 1)
        inv = 0
        for i in range(n - 1, -1, -1):
            r = bisect_right(vals, p[i]) - 1
            j = r
            while j > 0:
                inv += tree[j]
                j -= j & -j
            j = r + 1
            while j <= m:
                tree[j] += 1
                j += j & -j
        out.append(inv)
    sys.stdout.write("\n".join(map(str, out)) + "\n")
main()
