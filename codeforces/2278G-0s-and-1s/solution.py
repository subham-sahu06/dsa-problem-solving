import sys
def main():
    data = sys.stdin.buffer.read().split()
    MOD = 998244353
    t = int(data[0])
    pos = 1
    out = []
    for _ in range(t):
        n = int(data[pos])
        pos += 1
        adj = [[] for _ in range(n + 1)]
        for _ in range(n - 1):
            u = int(data[pos])
            v = int(data[pos + 1])
            pos += 2
            adj[u].append(v)
            adj[v].append(u)
        x = data[pos]
        y = data[pos + 1]
        pos += 2
        borrow = [0] * (n + 1)
        seen = [False] * (n + 1)
        seen[1] = True
        level = [1]
        answer = 0
        power = 1
        possible = True
        while level and possible:
            depth_bit = -1
            next_level = []
            for v in level:
                diff = (y[v - 1] - x[v - 1]) - borrow[v]
                bit = diff & 1
                if depth_bit == -1:
                    depth_bit = bit
                elif bit != depth_bit:
                    possible = False
                    break
                child_borrow = 1 if diff < 0 else 0
                for c in adj[v]:
                    if not seen[c]:
                        seen[c] = True
                        borrow[c] = child_borrow
                        next_level.append(c)
            if depth_bit == 1:
                answer = (answer + power) % MOD
            power = power * 2 % MOD
            level = next_level
        out.append(str(answer) if possible else "-1")
    sys.stdout.write("\n".join(out) + "\n")


main()
