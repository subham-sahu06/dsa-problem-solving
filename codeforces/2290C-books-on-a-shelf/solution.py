import sys
from collections import Counter
def main():
    data = sys.stdin.buffer.read().split()
    t = int(data[0])
    idx = 1
    out = []
    for _ in range(t):
        n = int(data[idx])
        h = data[idx + 1: idx + 1 + n]
        idx += 1 + n
        cnt = Counter(map(int, h))
        keys = sorted(cnt)
        left = keys
        right = [v for v in reversed(keys) if cnt[v] >= 2]
        mid = []
        for v in keys:
            mid.extend([v] * (cnt[v] - 2 if cnt[v] > 2 else 0))
        out.append(str(len(left) + len(right)))
        out.append(" ".join(map(str, left + mid + right)))
    print("\n".join(out))
main()
