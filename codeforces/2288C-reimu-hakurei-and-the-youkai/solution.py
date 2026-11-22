import sys
def main():
    d = sys.stdin.buffer.read().split()
    t = int(d[0])
    p = 1
    out = []
    for _ in range(t):
        n, x = int(d[p]), int(d[p + 1])
        p += 2
        h = sorted((int(v) + x - 1) // x for v in d[p:p + n])
        p += n
        ans = 0
        for i in range(n - 1):
            ans = max(ans, h[i] - (i + 1))
        out.append(ans)
    print("\n".join(map(str, out)))
main()
