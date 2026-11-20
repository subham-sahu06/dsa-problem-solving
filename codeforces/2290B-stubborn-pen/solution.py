import sys
def main():
    data = sys.stdin.read().split()
    t = int(data[0])
    out = []
    for i in range(t):
        s = data[2 + 2 * i]
        cur = "R"
        ans = 0
        for c in s:
            if cur != c:
                ans += 1
            cur = "B" if c == "R" else "R"
        out.append(str(ans))
    print("\n".join(out))
main()
