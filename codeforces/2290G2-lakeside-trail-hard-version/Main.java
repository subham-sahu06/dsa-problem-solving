import java.io.*;
public class Main {
    static int n;
    static long[] h, a;
    static long cost(long d, long limit) {
        System.arraycopy(h, 0, a, 0, n);
        for (int it = 0; it < 2 * n; it++) {
            int i = it % n;
            int p = i == 0 ? n - 1 : i - 1;
            if (a[p] - d > a[i]) a[i] = a[p] - d;
        }
        for (int it = 2 * n - 1; it >= 0; it--) {
            int i = it % n;
            int q = i == n - 1 ? 0 : i + 1;
            if (a[q] - d > a[i]) a[i] = a[q] - d;
        }
        long total = 0;
        for (int i = 0; i < n; i++) {
            total += a[i] - h[i];
            if (total > limit) return total;
        }
        return total;
    }
    public static void main(String[] args) throws IOException {
        DataInputStream in = new DataInputStream(new BufferedInputStream(System.in, 1 << 16));
        int t = (int) readLong(in);
        StringBuilder out = new StringBuilder();
        h = new long[1];
        a = new long[1];
        while (t-- > 0) {
            n = (int) readLong(in);
            long k = readLong(in);
            if (h.length < n) {
                h = new long[n];
                a = new long[n];
            }
            for (int i = 0; i < n; i++) h[i] = readLong(in);
            long lo = 0, hi = 0;
            for (int i = 0; i < n; i++) hi = Math.max(hi, Math.abs(h[i] - h[(i + 1) % n]));
            while (lo < hi) {
                long mid = (lo + hi) / 2;
                if (cost(mid, k) <= k) hi = mid;
                else lo = mid + 1;
            }
            out.append(lo).append('\n');
        }
        System.out.print(out);
    }
    static long readLong(DataInputStream in) throws IOException {
        int b = in.read();
        while (b < '0' || b > '9') b = in.read();
        long r = 0;
        while (b >= '0' && b <= '9') {
            r = r * 10 + (b - '0');
            b = in.read();
        }
        return r;
    }
}
