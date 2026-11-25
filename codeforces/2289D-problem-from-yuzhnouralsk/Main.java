import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        DataInputStream in = new DataInputStream(new BufferedInputStream(System.in, 1 << 16));
        int t = readInt(in);
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = readInt(in);
            long[] p = new long[n];
            long s = 0;
            boolean bad = false;
            for (int i = 0; i < n; i++) {
                s += readInt(in);
                p[i] = s;
                if (s < 0) bad = true;
            }
            sb.append(bad ? -1 : count(p, new long[n], 0, n)).append('\n');
        }
        System.out.print(sb);
    }
    static long count(long[] a, long[] tmp, int lo, int hi) {
        if (hi - lo < 2) return 0;
        int mid = (lo + hi) >>> 1;
        long inv = count(a, tmp, lo, mid) + count(a, tmp, mid, hi);
        int i = lo, j = mid, k = lo;
        while (i < mid && j < hi) {
            if (a[i] <= a[j]) tmp[k++] = a[i++];
            else {
                inv += mid - i;
                tmp[k++] = a[j++];
            }
        }
        while (i < mid) tmp[k++] = a[i++];
        while (j < hi) tmp[k++] = a[j++];
        System.arraycopy(tmp, lo, a, lo, hi - lo);
        return inv;
    }
    private static int readInt(DataInputStream in) throws IOException {
        int r = 0, b = in.read();
        while (b != '-' && (b < '0' || b > '9')) b = in.read();
        boolean neg = b == '-';
        if (neg) b = in.read();
        while (b >= '0' && b <= '9') {
            r = r * 10 + b - '0';
            b = in.read();
        }
        return neg ? -r : r;
    }
}
