import sys


def main():
    data = sys.stdin.read().split()
    t = int(data[0])
    pos = 1
    out = []

    for _ in range(t):
        n, k = int(data[pos]), int(data[pos + 1])
        pos += 2
        cnt = [0] * (n + 1)
        for i in range(n):
            cnt[int(data[pos + i])] += 1
        pos += n

        mex = 0
        prefix = 0
        for v in range(n + 1):
            prefix += cnt[v]
            if cnt[v] == 0 or prefix < (v + 1) * k:
                break
            mex = v + 1
        out.append(str(mex))

    print("\n".join(out))


main()
