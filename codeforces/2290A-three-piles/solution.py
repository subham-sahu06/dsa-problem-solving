import sys
def main():
    data = sys.stdin.read().split()
    t = int(data[0])
    out = []
    for i in range(t):
        a, b, c = map(int, data[1 + 3 * i: 4 + 3 * i])
        out.append("YES" if b - a == 1 and c - b == 1 else "NO")
    print("\n".join(out))
main()
