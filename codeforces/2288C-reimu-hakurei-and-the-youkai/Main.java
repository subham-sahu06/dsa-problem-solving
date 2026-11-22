import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        DataInputStream in = new DataInputStream(new BufferedInputStream(System.in, 1 << 16));
        int t = nextInt(in);
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = nextInt(in);
            long x = nextInt(in);
            long[] h = new long[n];
            for (int i = 0; i < n; i++) h[i] = (nextInt(in) + x - 1) / x;
            Arrays.sort(h);
            long ans = 0;
            for (int i = 0; i < n - 1; i++) ans = Math.max(ans, h[i] - (i + 1));
            sb.append(ans).append('\n');
        }
        System.out.print(sb);
    }
    private static int nextInt(DataInputStream in) throws IOException {
        int ret = 0, b = in.read();
        while (b < '0') b = in.read();
        while (b >= '0') {
            ret = ret * 10 + (b - '0');
            b = in.read();
        }
        return ret;
    }
}
