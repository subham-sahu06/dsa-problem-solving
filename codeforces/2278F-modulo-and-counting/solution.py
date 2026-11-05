import sys
def main():
    data = sys.stdin.buffer.read().split()
    MOD = 998244353
    t = int(data[0])
    queries = [(int(data[1 + 2 * i]), int(data[2 + 2 * i])) for i in range(t)]
    LIMIT = 4001
    fact = [1] * (LIMIT + 1)
    for i in range(1, LIMIT + 1):
        fact[i] = fact[i - 1] * i % MOD
    inv_fact = [1] * (LIMIT + 1)
    inv_fact[LIMIT] = pow(fact[LIMIT], MOD - 2, MOD)
    for i in range(LIMIT, 0, -1):
        inv_fact[i - 1] = inv_fact[i] * i % MOD
    def comb(a, b):
        if b < 0 or b > a:
            return 0
        return fact[a] * inv_fact[b] % MOD * inv_fact[a - b] % MOD
    out = []
    for n, m in queries:
        top = m + 2
        ways = [0] * (top + 1)
        ways[top] = 1
        answer = 0
        steps = 0
        high = top
        while steps + 1 <= n:
            if ways[2]:
                answer = (answer + ways[2] * comb(n, steps + 1)) % MOD
            if high <= 2 or steps + 1 == n:
                break
            prefix = [0] * (high + 1)
            running = 0
            for v in range(high + 1):
                running += ways[v]
                prefix[v] = running % MOD
            new_ways = [0] * (top + 1)
            for b in range(2, high):
                hi = 2 * b - 1
                if hi > high:
                    hi = high
                new_ways[b] = (prefix[hi] - prefix[b]) % MOD
            ways = new_ways
            high -= 1
            steps += 1
        out.append(answer)
    sys.stdout.write("\n".join(map(str, out)) + "\n")
main()
