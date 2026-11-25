import sys
def main():
    d = sys.stdin.buffer.read().split()
    t = int(d[0]); pos = 1
    out = []
    for _ in range(t):
        n = int(d[pos]); pos += 1
        p = [0] + [int(x) for x in d[pos:pos + n]]
        pos += n
        left = [0] * (n + 2)
        right = [n + 1] * (n + 2)
        st = []
        for i in range(1, n + 1):
            while st and p[st[-1]] > p[i]:
                st.pop()
            left[i] = st[-1] if st else 0
            st.append(i)
        st = []
        for i in range(n, 0, -1):
            while st and p[st[-1]] > p[i]:
                st.pop()
            right[i] = st[-1] if st else n + 1
            st.append(i)
        ans = 0
        for i in range(1, n + 1):
            a = i - left[i]
            b = right[i] - i
            ans += right[i] - left[i] - 1 if min(a, b) == 1 else 2
        out.append(ans)
    sys.stdout.write("\n".join(map(str, out)) + "\n")
main()
