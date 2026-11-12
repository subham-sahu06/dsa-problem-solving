import sys
from collections import deque
def main():
    data = sys.stdin.read().split()
    mode = data[0]
    t = int(data[1])
    idx = 2
    out = []
    for _ in range(t):
        if mode == "first":
            n = int(data[idx])
            s = data[idx + 1]
            idx += 2
            edges = []
            ones = [i + 2 for i in range(n - 1) if s[i] == '1']
            if not ones:
                edges.append((1, 2))
                edges.append((2, 3))
                edges.append((1, 3))
                for v in range(4, n + 1):
                    edges.append((v - 1, v))
            else:
                w = ones[0]
                for v in range(2, n + 1):
                    if s[v - 2] == '1':
                        edges.append((1, v))
                    else:
                        edges.append((w, v))
            out.append(str(len(edges)))
            for u, v in edges:
                out.append(f"{u} {v}")
        else:
            n = int(data[idx])
            m = int(data[idx + 1])
            idx += 2
            adj = [[] for _ in range(n + 1)]
            for _ in range(m):
                u = int(data[idx])
                v = int(data[idx + 1])
                idx += 2
                adj[u].append(v)
                adj[v].append(u)
            color = [-1] * (n + 1)
            color[1] = 0
            q = deque([1])
            ok = True
            while q:
                u = q.popleft()
                for w in adj[u]:
                    if color[w] == -1:
                        color[w] = color[u] ^ 1
                        q.append(w)
                    elif color[w] == color[u]:
                        ok = False
            if not ok:
                out.append("0" * (n - 1))
            else:
                out.append("".join(str(color[v]) for v in range(2, n + 1)))
    print("\n".join(out))
main()
