import sys
def main():
    data = sys.stdin.read().split()
    t = int(data[0])
    out = []
    for i in range(1, t + 1):
        n = int(data[i])
        seq = []
        time = 0
        for target in range(3):
            v = 2 * n
            while (v - time) % 3 != target:
                v -= 1
            while True:
                seq.append(v)
                time += 1
                if v <= 4:
                    break
                v -= 2
        out.append(str(len(seq)))
        out.append(" ".join(map(str, seq)))
    print("\n".join(out))
main()
