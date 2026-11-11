import sys
from collections import deque
def main():
    data = sys.stdin
    t = int(data.readline())
    for _ in range(t):
        n, m = map(int, data.readline().split())
        adj = [[] for _ in range(n + 1)]
        for _ in range(m):
            u, v = map(int, data.readline().split())
            adj[u].append(v)
            adj[v].append(u)
        comp = [0] * (n + 1)
        order = []
        cid = 0
        for s in range(1, n + 1):
            if comp[s]:
                continue
            cid += 1
            comp[s] = cid
            q = deque([s])
            while q:
                u = q.popleft()
                order.append(u)
                for w in adj[u]:
                    if not comp[w]:
                        comp[w] = cid
                        q.append(w)
        def bfs_from(r):
            seen = {r}
            res = []
            q = deque([r])
            while q:
                u = q.popleft()
                res.append(u)
                for w in adj[u]:
                    if w not in seen:
                        seen.add(w)
                        q.append(w)
            return res
        def ask(vs):
            print("? 1 " + str(len(vs)) + " " + " ".join(map(str, vs)), flush=True)
            r = int(data.readline())
            if r == -1:
                sys.exit(0)
            return r == 0
        def first_bad(lo, hi, build):
            while lo < hi:
                mid = (lo + hi) // 2
                if ask(build(mid)):
                    hi = mid
                else:
                    lo = mid + 1
            return lo
        k = first_bad(1, n, lambda c: order[:c])
        x = order[k - 1]
        bord = bfs_from(x)
        bset = set(bord)
        rest = [v for v in order if v not in bset]
        k = first_bad(1, len(bord), lambda c: rest + bord[:c])
        x2 = bord[k - 1]
        bpart = bord[:k]
        pos = {v: i for i, v in enumerate(order)}
        start = min(pos[v] for v in bord)
        before = order[:start]
        k = first_bad(1, len(before), lambda c: before[:c] + bpart)
        y = before[k - 1]
        if x == x2:
            print("!", x, y, flush=True)
            continue
        print("? 2", x, y, flush=True)
        r = int(data.readline())
        if r == -1:
            sys.exit(0)
        if r == 1:
            print("!", x, y, flush=True)
        else:
            print("!", x2, y, flush=True)
main()
