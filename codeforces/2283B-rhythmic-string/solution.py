import sys


def main():
    data = sys.stdin.buffer.read().split()
    t = int(data[0])
    pos = 1
    out = []

    for _ in range(t):
        n = int(data[pos])
        a = list(map(int, data[pos + 1:pos + 1 + n]))
        pos += 1 + n

        # The kept numbers must all be multiples of the smallest kept number d,
        # so for every d count how many elements it divides.
        best = 0
        for d in set(a):
            keep = sum(1 for v in a if v % d == 0)
            if keep > best:
                best = keep
        out.append(str(n - best))

    sys.stdout.write("\n".join(out) + "\n")


main()
