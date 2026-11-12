import sys
def main():
    data = sys.stdin.buffer.read().split()
    t = int(data[0])
    idx = 1
    out = []
    for _ in range(t):
        n = int(data[idx])
        k = int(data[idx + 1])
        idx += 2
        h = list(map(int, data[idx:idx + n]))
        idx += n
        def cost(d):
            a = h[:]
            for it in range(2 * n):
                i = it % n
                v = a[i - 1] - d
                if v > a[i]:
                    a[i] = v
            for it in range(2 * n - 1, -1, -1):
                i = it % n
                v = a[(i + 1) % n] - d
                if v > a[i]:
                    a[i] = v
            return sum(a) - sum(h)
        lo = 0
        hi = max(abs(h[i] - h[(i + 1) % n]) for i in range(n))
        while lo < hi:
            mid = (lo + hi) // 2
            if cost(mid) <= k:
                hi = mid
            else:
                lo = mid + 1
        out.append(lo)
    print("\n".join(map(str, out)))
main()
