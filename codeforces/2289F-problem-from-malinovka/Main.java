import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        DataInputStream in = new DataInputStream(new BufferedInputStream(System.in, 1 << 16));
        int M = 1000000;
        boolean[] sq = new boolean[M + 1];
        Arrays.fill(sq, true);
        for (long i = 2; i * i <= M; i++) for (long j = i * i; j <= M; j += i * i) sq[(int) j] = false;
        int[][] R = new int[1001][];
        int[] buf = new int[1000];
        for (int p = 2; p <= 1000; p++) {
            int c = 0;
            for (int r = 1; r < p; r++) if (sq[r * p]) buf[c++] = r;
            R[p] = Arrays.copyOf(buf, c);
        }
        int t = readInt(in);
        int[] f = new int[M + 1];
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = readInt(in);
            for (int m = 1; m <= n; m++) {
                long k = (long) Math.sqrt((double) n / m);
                while ((k + 1) * (k + 1) * m <= n) k++;
                while (k * k * m > n) k--;
                f[m] = (int) k;
            }
            long a = (long) f[1] * f[1] * f[1];
            for (int q = 2; q <= n; q++) if (sq[q]) a += 3L * f[q] * f[q] * f[1];
            long s = 0;
            for (int p = 2; (long) p * (p + 1) <= n; p++) {
                if (!sq[p]) continue;
                int[] rp = R[p];
                for (int q = p + 1; (long) p * q <= n; q++) {
                    if (!sq[p * q]) continue;
                    long inner = 0;
                    for (int r : rp) if (sq[r * q]) inner += (long) f[r * p] * f[r * q];
                    s += inner * f[p * q];
                }
            }
            sb.append(a + 6 * s).append('\n');
        }
        System.out.print(sb);
    }
    private static int readInt(DataInputStream in) throws IOException {
        int r = 0, b = in.read();
        while (b < '0') b = in.read();
        while (b >= '0') {
            r = r * 10 + b - '0';
            b = in.read();
        }
        return r;
    }
}
