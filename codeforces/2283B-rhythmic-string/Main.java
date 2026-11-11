import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        DataInputStream in = new DataInputStream(new BufferedInputStream(System.in, 1 << 16));
        int t = nextInt(in);
        StringBuilder out = new StringBuilder();
        while (t-- > 0) {
            int n = nextInt(in);
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextInt(in);
            }
            int[] distinct = Arrays.stream(a).distinct().toArray();
            int best = 0;
            for (int d : distinct) {
                int keep = 0;
                for (int v : a) {
                    if (v % d == 0) {
                        keep++;
                    }
                }
                best = Math.max(best, keep);
            }
            out.append(n - best).append('\n');
        }
        System.out.print(out);
    }

    private static int nextInt(DataInputStream in) throws IOException {
        int ret = 0;
        int b = in.read();
        while (b < '0' || b > '9') {
            b = in.read();
        }
        while (b >= '0' && b <= '9') {
            ret = ret * 10 + (b - '0');
            b = in.read();
        }
        return ret;
    }
}
