import sys
from heapq import heappush, heappop
def main():
    data = sys.stdin.buffer.read().split()
    pos = 0
    t = int(data[pos]); pos += 1
    out = []
    for _ in range(t):
        n = int(data[pos]); d = int(data[pos + 1]); pos += 2
        m = 2 * n - 1
        a = [0] * (m + 1)
        b = [0] * (m + 1)
        for k in range(n + 1, m + 1):
            a[k] = int(data[pos]); b[k] = int(data[pos + 1]); pos += 2
        dep = [0] * (m + 1)
        for k in range(m, n, -1):
            dep[a[k]] = dep[k] + 1
            dep[b[k]] = dep[k] + 1
        heaps = [None] + [[-i] for i in range(1, n + 1)]
        ref = list(range(m + 1))
        ans = [0] * (n + 1)
        for k in range(n + 1, m + 1):
            x = ref[a[k]]; y = ref[b[k]]
            hx = heaps[x]; hy = heaps[y]
            mx = -hx[0]; my = -hy[0]
            lim = my + d
            while hx and -hx[0] >= lim:
                v = -heappop(hx)
                ans[v] = dep[v] - dep[k]
            lim = mx + d
            while hy and -hy[0] >= lim:
                v = -heappop(hy)
                ans[v] = dep[v] - dep[k]
            if len(hx) < len(hy):
                x, y = y, x
                hx, hy = hy, hx
            for v in hy:
                heappush(hx, v)
            heaps[y] = None
            ref[k] = x
        for v in heaps[ref[m]]:
            ans[-v] = dep[-v]
        out.append(" ".join(map(str, ans[1:])))
    sys.stdout.write("\n".join(out) + "\n")
main()
