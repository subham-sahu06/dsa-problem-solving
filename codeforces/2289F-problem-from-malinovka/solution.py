import sys
import numpy as np
def main():
    d = sys.stdin.buffer.read().split()
    t = int(d[0])
    M = 1000000
    sq = np.ones(M + 1, dtype=bool)
    i = 2
    while i * i <= M:
        sq[i * i::i * i] = False
        i += 1
    out = []
    for k in range(1, t + 1):
        n = int(d[k])
        m = np.arange(1, n + 1, dtype=np.int64)
        f = np.zeros(n + 1, dtype=np.int64)
        v = np.floor(np.sqrt(n / m)).astype(np.int64)
        v[(v + 1) * (v + 1) * m <= n] += 1
        v[v * v * m > n] -= 1
        f[1:] = v
        a = int(f[1]) ** 3 + 3 * int(f[1]) * int(np.sum(f[2:][sq[2:n + 1]] ** 2))
        s = 0
        p = 2
        while p * (p + 1) <= n:
            if sq[p]:
                r = np.arange(1, p, dtype=np.int64)
                r = r[sq[r * p]]
                q = np.arange(p + 1, n // p + 1, dtype=np.int64)
                q = q[sq[p * q]]
                if len(r) and len(q):
                    rq = np.outer(r, q)
                    w = sq[rq] * f[rq]
                    inner = (f[r * p][:, None] * w).sum(axis=0)
                    s += int((inner * f[p * q]).sum())
            p += 1
        out.append(a + 6 * s)
    sys.stdout.write("\n".join(map(str, out)) + "\n")
main()
